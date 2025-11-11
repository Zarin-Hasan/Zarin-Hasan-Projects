#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {

	char name[100];
        int employeeID;
        float salary;
        char department[50];
        int experience;
        float performanceScore;

} Employee;



void addEmployee(Employee *emp,int *count){

        printf("Enter name of employee: ");
        scanf(" %[^\n]",emp[*count].name);


        printf("Enter employee ID: ");
        scanf("%d", &emp[*count].employeeID);
        while (getchar() != '\n');


        printf("Enter salary: ");
        scanf("%f", &emp[*count].salary);
        while (getchar() != '\n');


        printf("Enter department: ");
        scanf(" %[^\n]", emp[*count].department);


        printf("Enter years of experience: ");
        scanf("%d", &emp[*count].experience);
        while (getchar() != '\n');
        emp[*count].performanceScore = (0.3 * emp[*count].experience + 0.7 * emp[*count].salary / 1000);

        (*count)++;

}


void updateEmployee(Employee *emp,int *count)

{

        int id;

        printf("Enter Employee ID to update:  ");
        scanf("%d",&id);
        while (getchar() != '\n');


        for(int i =0; i < *count; i++){

                if (emp[i].employeeID == id){

                        printf("Enter new salary:  ");
                        scanf("%f",&emp[i].salary);
                        while (getchar() != '\n');



                        printf("Enter new department:  ");
                        scanf(" %[^\n]",emp[i].department);

                        printf("Employee information updated sucessfully!\n");
			emp[i].performanceScore = (0.3 * emp[i].experience + 0.7 * emp[i].salary / 1000);
                        return;

                }
        }

	printf("Employee with ID %d was not found.\n", id);

}

int sortEmployeesByPerformance(const void *a, const void *b) {

	Employee *e1 = (Employee *)a;
	Employee *e2 = (Employee *)b;

	if (e2->performanceScore > e1->performanceScore) return 1;
	else if (e2->performanceScore < e1->performanceScore) return -1;
	else return 0;

}


void displayEmployees(Employee *emp, int count) {

	if (count == 0) {
	printf("No employees to display.\n");
	return;
	}

	qsort(emp, count, sizeof(Employee), sortEmployeesByPerformance);
	printf("Employee Records (sorted by Performance Score):\n\n");


	for (int i = 0; i < count; i++) {

        	printf("Name: %s\n", emp[i].name);
       		printf("ID: %d\n", emp[i].employeeID);
        	printf("Salary: %.2f\n", emp[i].salary);
        	printf("Department: %s\n", emp[i].department);
        	printf("Years of Experience: %d years\n", emp[i].experience);
        	printf("Performance Score: %.2f\n\n", emp[i].performanceScore);

    	}

}

void searchEmployeeByName(Employee *emp, int count) {
	char name[50];
	printf("Enter name to search: ");
	scanf(" %[^\n]", name); 

	int found = 0;

	printf("Search Results:\n");
	for (int i = 0; i < count; i++) {

		if (strstr(emp[i].name, name) != NULL) {
			printf("\nEmployee found:\n");
        		printf("Name: %s\n", emp[i].name);
        		printf("ID: %d\n", emp[i].employeeID);
        		printf("Salary: %.2f\n", emp[i].salary);
			printf("Department: %s\n", emp[i].department);
			printf("Years of Experience: %d years\n", emp[i].experience);
			found = 1;
			}
		}
		if (!found){
			printf("No employee found with name containing \"%s\".\n", name);
		}
}


int main(){

        int capacity = 2;
        int count = 0;
        int choice;

        Employee *emp = malloc(capacity*sizeof(Employee));

        if (!emp){

                printf("Memory allocation failed!\n");
                return 1;

        }

	while(1) {

		printf("Employee Performance Management System\n1.  Add Employee\n2.  Update Employee\n3.  Display All Employees\n4.  Search Employee by Name\n5.  Exit\n");
	        printf("Please Enter your choice:  ");
        	scanf("%d",&choice);

	        while(choice > 5 || choice < 1){

        	        printf("Please enter a number from the menu:  ");
                	scanf("%d",&choice);

        	}

        	if(choice == 1) {
			if(capacity == count){

                		capacity *= 2;
                		emp = realloc(emp,capacity*sizeof(Employee));

                		if(!emp){

                        		printf("Memory allocation failed!\n");

                		}
			}
			addEmployee(emp,&count);

        	} else if(choice == 2){

                	updateEmployee(emp,&count);

        	} else if(choice == 3){
			displayEmployees(emp,count);
		} else if (choice == 4){
			searchEmployeeByName(emp,count);
		}else if(choice == 5) {break;}

	}

        	free(emp);
        	return 0;

}


