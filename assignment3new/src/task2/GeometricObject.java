package task2;

public abstract class GeometricObject {
	private String colour;
	private boolean filled;
	private java.util.Date dateCreated;
	
	public GeometricObject() {
		this.dateCreated = new java.util.Date();
	}
	
	public GeometricObject(String a, boolean b) {
		this.dateCreated = new java.util.Date();
		this.colour=a;
		this.filled=b;
	}
	
	public void setColour(String a) {
		this.colour = a;
	}
	
	public void setFilled(boolean a) {
		this.filled = a;
	}
	
	public String getColour() {
		return colour;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	
	public String toString() {
		return ("created on " + getDateCreated() + "\ncolour: " + getColour() + " and filled: " + isFilled());
	}
	
	
	public abstract double getArea();
	public abstract double getPerimeter();
}
