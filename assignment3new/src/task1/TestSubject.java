package task1;

import java.io.*;
import java.util.Scanner;

public class TestSubject {
	
	public static void main(String[] args) {	
		boolean var = true; // creating variables and objects to use later	
		int x=0;
		String subName;
		String subCode;
		Scanner input=new Scanner(System.in); // creating scanner object to get input from user
		
		Subject[] subjects = readFile(); // read the file and store contents in a Subject object array
		System.out.print("Would you like to enter a subject? (true/false) ");
		var=input.nextBoolean();
		if(var==true) {
			for(int i=0;i<subjects.length;i++) {
				System.out.println("Subject Name at index "+i+" is: "+subjects[i].getName()); // printing out the subject names with their index in array
				System.out.println("Subject Code at index "+i+" is: "+subjects[i].getCode());
			}
		}
		while(var) {
			input.nextLine(); // clears the parser/buffer to ensure subName does not absorb anything unexpectedly
			
			System.out.print("Please enter subject name: ");
			subName = input.nextLine(); // basic input method
			System.out.print("Please enter subject code: ");
			subCode = input.nextLine();
	
			if(subjects[0].codeExists(subjects, subCode)) { // starting if function by checking to see if the new code already exists
				while(subjects[0].codeExists(subjects, subCode)) { // while loop that doesn't break out until the new code is unique
					System.out.print("Sorry but that code already exists, please enter a unique code: ");
					subCode = input.nextLine(); // prompting user for a unique subject code
				}
			}
			
			Subject sub = new Subject(subName, subCode); // creating a new subject code for adding to array
			x = subjects.length+1; // getting length for the new array
			Subject[] tempArray = new Subject[x]; // creating a new array one element larger than previously
			
			for(int i=0;i<subjects.length;i++) {
				tempArray[i] = subjects[i]; // this for loop is for copying the array into a new one to store later
			}
			subjects = tempArray; // assigning the old array to the new one
			subjects[subjects.length-1] = sub; // adding the new subject object to the new array created
			
			System.out.print("Would you like to enter another subject? (true/false) ");
			var = input.nextBoolean();
			if(var==false) { // only writing the file when the user is finished added subjects
				writeFile(subjects); //write contents of array to subjects array
			}
			
		}
		
		
		input.close(); // close scanner to help with resource leakage
		System.out.println("Closing program, thank you"); // a prompt to show that the program has correctly closed
	}

	
	public static Subject[] readFile() {
		try { // inside a try function as errors can often be thrown due to incorrect file names
			int i=0; // creating variables for later
			int x=0;
			
			File file = new File("C:\\Users\\Mark\\eclipse-workspace\\Assignment3\\src\\task1\\test.txt"); // open the file
			Scanner scan = new Scanner(file); // scan the contents of the file
			Scanner scan1 = new Scanner(file); // scan the contents of the file
			
			while (scan1.hasNextLine()) { //quickly find the amount of lines in the file so we know how large to make the array
				scan1.nextLine();
				x++;
			}		
			scan1.close(); // closing the scanner to help with resource leakage
			Subject[] subjects = new Subject[x]; // creating the subject object array, will need to figure out how to make it the correct length later
			
			for(;scan.hasNextLine();) {
				String temp = scan.nextLine(); // read the line of the file and assigning it to the string variable
				String[] splitString = temp.split(","); // splitting the string at the delimiter
				Subject subjectCode = new Subject(splitString[0],splitString[1]); // creating a Subject object with information from file
				subjects[i] = subjectCode; //adding the created subject to a subject array
				i++;
			}
			
			scan.close(); //closing scan to prevent resource leakage
			return subjects; // returning the object array
		} catch(FileNotFoundException e) {
			System.out.println("The file was not able to be found");
			e.printStackTrace();
			Subject[] NULL = new Subject[0]; //create a null array to pass back to indicate that an error has occurred
			return NULL;
		}
	}
	
	public static void writeFile(Subject[] a) {
		try {
			FileWriter writer = new FileWriter("C:\\Users\\Mark\\eclipse-workspace\\Assignment3\\src\\task1\\test.txt"); // opening the text file to write into
			for (int i=0;i<a.length;i++) { // for loop to go through each element of array
				writer.write(a[i].toString()); // calling function from Subject class to easily write to file
				System.out.println("Successfully wrote line from index "+i); // prompting the user to show that all elements were correctly written
			}
			writer.close(); // closing the writer to help with resource leakage
		} catch(IOException e) { // catch unexpected errors
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
}
