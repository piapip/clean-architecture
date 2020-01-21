package station;

public class Station {
	private int id;
	private String name;
	private double distanceToTerminus;
	
	public Station(int id, String name, double distance) {
		this.id = id;
		this.name = name;
		this.distanceToTerminus = distance;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getDistanceToTerminus() {
		return distanceToTerminus;
	}
	
	public String toString() {
		return "Id: " + id + "\nName: " + name; 
	}
}
