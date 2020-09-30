package task2;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // creating scanner to receive input from user
		
		System.out.print("Please enter the octagon sides length: ");
		double sideLength = input.nextDouble();
		
		System.out.print("Please enter the colour of the octagon: ");
		input.nextLine(); // clearing buffer
		String octagonColour = input.nextLine();
		
		System.out.print("Please enter if the octagon is filled (true/false): ");
		boolean filled = input.nextBoolean();
		
		Octagon octagon1 = new Octagon(sideLength,octagonColour,filled); // create object
		
		System.out.println("The area of this octagon is: " + octagon1.getArea());
		System.out.println("The perimeter of this octagon is: " + octagon1.getPerimeter());
		
		Octagon octagonClone1 = octagon1.clone(); // creating a shallow clone of octagon
		
		if (octagon1.compareTo(octagonClone1)<0) {
			System.out.println("Octagon 1 is smaller in aread than the compared octagon");
		}else if(octagon1.compareTo(octagonClone1)>0){
			System.out.println("Octagon 1 is larger in area than the compared octagon");
		}else {
			System.out.println("Octagon 1 is the same area as the compared octagon");
		} 
		input.close(); // closing to prevent resource leak
	}

}
