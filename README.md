# Employee Performance Management System (C)

This project is a **console-based employee management system** written in C, implemented in `Assignment.c`.  
It allows users to manage employee data such as name, ID, salary, department, and performance scores.

##  Features
- Add and update employee information  
- Search employees by name  
- Display all employees sorted by performance score  
- Dynamic memory allocation for flexible employee storage  
- Performance score calculated using experience and salary  
- Input validation and efficient data management using structures and pointers  

##  Key Concepts
- Structs for organizing employee data  
- Dynamic memory management with `malloc` and `realloc`  
- Sorting using `qsort` and custom comparison functions  
- String manipulation and searching with `strstr`  
- Modular design with multiple functions handling specific tasks  

##  How to Run
Compile and run the program using GCC:
```bash
gcc Assignment.c -o Assignment
Assignment
```
## Example Use
```
Employee Performance Management System
1. Add Employee
2. Update Employee
3. Display All Employees
4. Search Employee by Name
5. Exit
Please Enter your choice: 3
```
# Example output
```
Employee Records (sorted by Performance Score):

Name: Alice Johnson
ID: 101
Salary: 72000.00
Department: HR
Years of Experience: 5 years
Performance Score: 57.60
```
