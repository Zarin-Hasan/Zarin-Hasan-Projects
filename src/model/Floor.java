package model;

public class Floor {
	
	private int fixedCap;
	private int areaSum;

	private Unit[] units;
	private int nou; //number of units

	public Floor(int fixedCapacity) {
		this.fixedCap = fixedCapacity;
		this.units = new Unit[20];
		this.nou = 0;
	}
	
	public Floor(Floor other) {
		this(other.fixedCap);
		for(int i = 0; i < other.nou; i++)
		{
			this.units[i] = new Unit(other.units[i]);
		}
		this.nou = other.nou;
	}
	
	public void addUnit(String room, int width, int length) throws InsufficientFloorSpaceException {
		if (this.fixedCap - this.areaSum - width*length < 0) {
			throw new InsufficientFloorSpaceException("Error: Insufficient floor space available");
		}
		else {
			Unit u = new Unit(room, width, length);
			this.units[this.nou] = u;
			this.nou++;
			this.areaSum += width*length;
		}
		
		
	}
	public String toString()
	{
		String list = "[";
		for (int i = 0; i < this.nou; i++) {
			Unit u = units[i];
			list += String.format("%s: %d sq ft (%d' by %d')", 
							u.getRoomName(),
							u.getWidth()*u.getLength(),
							u.getWidth(),
							u.getLength());
		if (i < this.nou-1) {
			list += ", ";
		}
		}
		list += "]";
		String s = "";
		s = String.format("Floor's utilized space is %d sq ft (%d sq ft remaining): "
				, this.areaSum, this.fixedCap-this.areaSum);
		s += list;
		return s;
	}
	
	public int numberOfEqualUnits(Unit u) {
		int result = 0;
		for(int i = 0; i <this.nou; i++)
		{
			if(this.units[i].equals(u)) {
				result++;
			}
		}
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Floor other = (Floor)obj;
		boolean equal = this.fixedCap == other.fixedCap;
		if (equal) {
			for (int i = 0; equal && i < this.nou; i++)
			{
				Unit u = this.units[i];
				equal = this.numberOfEqualUnits(u) == other.numberOfEqualUnits(u);
			}
		}
		return equal;
		
	}



}
