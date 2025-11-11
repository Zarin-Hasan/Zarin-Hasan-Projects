package model;

public class Blueprint {
	private int floorCapacity;//number of floors
	private int floorsDone;
	private Floor[] floors;

	public Blueprint(int floors) {
		this.floors = new Floor[floors];
		this.floorCapacity = floors;
		this.floorsDone = 0;
	}
	
	
	public Blueprint(Blueprint other) {
		this(other.floorCapacity);
		
		for(int i = 0; i< other.floorsDone; i++) {
			this.floors[i] = new Floor(other.floors[i]);
		}
		this.floorsDone = other.floorsDone;
	}


	public String toString()
	{
		double percentage = (this.floorsDone/(double)this.floorCapacity)*100.00;
		String Percentage = String.format("%.1f", percentage);
		//"0.0 percents of building blueprint completed (0 out of 7 floors)"
		String result = String.format("%s percents of building blueprint completed (%d out of %d floors)",
							Percentage,
							this.floorsDone,
							this.floorCapacity);
		return result;
	}
	
	 public void addFloorPlan(Floor f1) {
		  this.floors[this.floorsDone] = f1;
		  this.floorsDone++;
		
	}


	  public Floor[] getFloors() {
		Floor[] result = new Floor[this.floorsDone];
		
		for(int i = 0; i< this.floorsDone; i++) {
			result[i] = new Floor(this.floors[i]);
		}
		return result;
	  }

}
