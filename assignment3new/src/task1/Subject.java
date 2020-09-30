package task1;


public class Subject {
	
	private String subjectName; // private values for best practice
	private String subjectCode;
	
	public Subject(String a, String b){ // constructor for name and code
		subjectName = a;
		if (isValidCode(b)==true) { // checking to see if the subject code provided is valid, only assigning the value if it IS valid
			subjectCode = b;
		}else {
			System.out.println("The subject code "+b+" is not valid");
		}
	}
	
	public String getName() { // getter method for subject name
		return subjectName;
	}
	
	public String getCode() { // getter method for subject code
		return subjectCode;
	}
	
	public boolean codeExists(Subject[] a, String b) { 
		for (int i=0;i<a.length;i++) { // for loop to go through all the Subject objects
			if (codeMatches(a[i].subjectCode,b)) { // using getter method, find the subject code for that object and compare values
				return true; // will only return true if there is an object with the same subject code, otherwise does not get to this point
			}
		}
		return false; // only returns false if there is no object in the array with the subject code being compared to
	}
	
	public boolean isValidCode(String a) {
		if(a.length()==6) { // check to see if string passed is correct length
			String first=a.substring(0, 3); // splicing string into two halves
			String second=a.substring(3, 6);
			
			boolean firstBool=isLetter(first);
			boolean secondBool=isNumber(second);
			
			if (firstBool && secondBool==true) { // only returning true if BOTH the first and last three elements of string are correct type
				return true;
			}else return false;
			
		}else {
			return false;
		}		
	}
	
	public boolean isLetter(String a) {
		for (char i: a.toCharArray()) { // send the string to an array so we can loop through the array
			if (!Character.isAlphabetic(i)) { // checking to see if the array has an element that is not alphabetical
				return false; // if one element is not alphabetical then returning false
			}
		}
		return true; // if the array is alphabetical return true
	}
	
	public boolean isNumber(String a) { // same concepts as the "isLetter" method
		for (char i: a.toCharArray()) {
			if (!Character.isDigit(i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean codeMatches(String a, String b) {
		if (a.equals(b)) { // testing to see if string a and b are exactly the same, return the appropriate value if yes
			return true;
		}else return false;
	}
	
	public String toString() {
		String returningValue = getName()+","+getCode()+"\n"; //adding a new line for when we write objects to a file
		return returningValue;
	}

}
