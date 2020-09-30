package task2;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{

	private double side;
	
	public Octagon() {
		this.side = 1;
	}
	
	public Octagon(double a, String b, boolean c) {
		this.side = a;
		setColour(b);
		setFilled(c);
	}
	
	public Octagon clone() {
		try {
			/**
			Octagon octagonClone = (Octagon)super.clone();
			**/
			
			return (Octagon)super.clone();
		}catch(CloneNotSupportedException ex){
			return null;
		}
	}
	
	public double getSide() {
		return this.side;
	}
	
	public double getPerimeter() {
		double peri=(8*getSide());
		return peri;
	}
	
	public double getArea() {
		double side = getSide();
		double area = ((2+2*Math.sqrt(2))*side*side);
		return area;
	}
	
	@Override
	public int compareTo(Octagon o) {
		if (getArea()>o.getArea()) {
			return 1;
		}else if (getArea()<o.getArea()) {
			return -1;
		}else return 0;
	}

}
