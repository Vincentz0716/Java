
class Main {

	public static void main(String[] args) {
		(new Main()).init();
	}

	void init() {
		System.out.print("Enter GPA value: ");
		double gpaValue = Input.readDouble();
		System.out.printf("%.2f\n", gpa(gpaValue));

		System.out.print("Enter grade level: ");
		int gradeLevel = Input.readInt();
		System.out.print("Enter number of credits earned: ");
		int creditsEarned = Input.readInt();
		System.out.println(isGraduating(gradeLevel, creditsEarned));

		System.out.print("Enter weight in pounds: ");
		double weight = Input.readDouble();
		System.out.print("Enter height in inches: ");
		double height = Input.readDouble();
		System.out.println(BMI(weight, height));

		System.out.print("Enter weight in pounds: ");
		double shipWeight = Input.readDouble();
		System.out.printf("%.2f\n", shippingCost(shipWeight));

		System.out.print("Enter light frequency in THz: ");
		int frequency = Input.readInt();
		System.out.println(blueOrViolet(frequency));
	}

	/* Challenge 1:

	Write a function "gpa" that takes in the GPA value and returns the calcuation : if it's over 90, return gpa*1.1, otherwise return the raw gpa.
	
	*/
	double gpa(double gpaValue){
		if(gpaValue > 90){
			return gpaValue * 1.1;
		} else {
			return gpaValue;
		}
	}

	/* Challenge 2:

	Write a function "isGraduating" that accepts the grade level and number of credits earned that returns the boolean value TRUE if a student is a Senior and has 44 or more credits, otherwise return FALSE. 

	In the init function:
	Display to console "Student is Graduating" or "Student is NOT Graduating" depending on the value return by the function.
	*/

	boolean isGraduating(int gradeLevel, int creditsEarned){
		if(gradeLevel == 12 && creditsEarned >= 44){
			return true;
		} else {
			return false;
		}
	}

	/*
	Challenge 3:
	BMI
	Write a function "BMI" that accepts a weight in pounds and 
	height in inches. Calculate the BMI (google the formula) and 
	return return the following:
		BMI 18.4 or less return Underweight
		BMI is 18.5 - 24.9	(inclusive) return Normal
		BMI is 25.0 - 39.9	(inclusive) return Overweight
		BMI is 40.0	or greater return  Obese  
	*/
	String BMI(double weight, double height){
		double bmi = (weight / (height * height)) * 703;
		if(bmi <= 18.4){
			return "Underweight";
		} else if(bmi >= 18.5 && bmi <= 24.9){
			return "Normal";
		} else if(bmi >= 25.0 && bmi <= 39.9){
			return "Overweight";
		} else {
			return "Obese";
		}
	}

	/* 
	Challenge 4:

	Write a function "shippingCost" that accepts a weigth 
	in units of pounds and returns:
		- 0.00, if 10 pounds or less,
		- 5.00, if more than 10 pounds but 15 pounds 
		or less,
		- 10.00, if more than 15 pounds but 25 pounds 
		or less,
		- 10.00 Plus 2 cents per pound over 25 pound, 
		if over 25 pounds.
		 */  
	double shippingCost(double weight){
		double cost = 0;
		if(weight <= 10){
			cost = 0;		
		} else if(weight > 10 && weight <= 15){
			cost = 5;
		} else if(weight > 15 && weight <= 25){
			cost = 10;
		} else if(weight > 25){
			cost = 10 + (0.02 * (weight - 25));
		}
		return cost;
	}

	/* 
	Challenge 5:

	Write a function "blueOrViolet" that accepts a light frequency in THz units and returns true for either blue frequence (600-670 THz) or violet frquence (700-750 THz), otherwise return false

	*/
	boolean blueOrViolet(int frequency){
		if((frequency >= 600 && frequency <= 670) || (frequency >= 700 && frequency <= 750)){
			return true;
		} else {
			return false;
		}
	}

}