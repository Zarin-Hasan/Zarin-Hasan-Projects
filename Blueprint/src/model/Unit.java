package model;

public class Unit {
	
	private String roomName;
	private int width;
	private int length;
	private boolean footToMeter = false;
	private double widthM;
	private double lengthM;
	

	public Unit(String room, int width, int length) {
		this.roomName = room;
		this.width = width;
		this.length = length;
	}
	
	public Unit(Unit other)
	{
		this(other.roomName,other.width,other.length);
		
	}

	public String getRoomName()
	{
		return this.roomName;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getLength() {
		return this.length;
	}
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		else if(obj == null ||  this.getClass() != obj.getClass())
		{
			return false;
		}
		
		Unit other = (Unit) obj;
		return 		this.roomName.equals(other.roomName) 
				&& this.width*this.length == other.width*other.length;			
		
	}
	public String toString()
	{
		String p = "";
		if (!this.footToMeter)
	
		{
			 p = String.format("A unit of %d square feet (%d' wide and %d' long) functioning as %s"
				,this.width*this.length,this.width,this.length,this.roomName);
		}
		else 
		{
			p = String.format("A unit of %.2f square meters (%.2f m wide and %.2f m long) functioning as %s"
					,this.widthM*this.lengthM,this.widthM,this.lengthM,this.roomName);
		}
		return p;
	}

	public void toggleMeasurement() {
		this.footToMeter = !this.footToMeter;
		this.widthM = this.width * 0.3048;
		this.lengthM = this.length * 0.3048;	
	}	

}
