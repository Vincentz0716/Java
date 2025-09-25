
 class Main {
	public static void main(String[] args) {
    	(new Main()).init();
	}

  void init(){
    

/*  
    Challenge 1:
    Create two integer variables and Assign values to them. 
    Calculate the sum of the two numbers and store the 
    calculated sum and then display it.
    
*/
    int num1 = 5;
    int num2 = 10;
    int sum = num1 + num2;
    System.out.println("Sum of num1 and num2: " + sum);

/*  
    Challenge 2:
    Create three variables to assign three grades and Assign values to each grade. 
    Calculate the sum of the three grades and store the 
    calculated sum and then display it.
    
*/
    int grade1 = 85;
    int grade2 = 90;
    int grade3 = 78;
    int totalGrades = grade1 + grade2 + grade3;
    System.out.println("Total of three grades: " + totalGrades);


/*  
    Challenge 3:
    Calculate the average from the three grades from challenge 2,
    store the value and then display it.
    Declare and assign values to any new variables
    NOTE: Does it look correct, check with a calculator?
*/
    double average = totalGrades / 3.0;
    System.out.println("Average of three grades: " + average);


/*  
    Challenge 4:
    Write the following equation in EQ1.PNG file in Java; store the result and the display it:
    Declare and assign values to any new variables
    result = A/(x+1)

*/
    int A = 10;
    int x = 2;
    double result = (double) A / (x + 1);
    System.out.println("Result of A/(x+1): " + result);
/*  
    Challenge 5:
    Using the variables same variables from challenge4 above, write the following equation in EQ2.PNG file in Java, store the result and the display it:
    y=2x(x+1)(-x/2)/A
    Declare and assign values to any new variables

*/
    int o = 3;
    int j = 5;
    double y = 2 * o * (o + 1) * (-o / 2) / j;
    System.out.println("Value of y: " + y);
   




/*  
    Challenge 6:
    Create the variables and write the equation in
    file  EQ3.PNG
    Declare and assign values to any new variables
*/

    int base = 6;
    int height = 8;
    double area = 0.5 * base * height;
    System.out.println("Area : " + area);




/*  
    **** Bonus Challenge ****:
    Create a variable that stores the total number of eggs 
    and assign it 100. We want to fill as many baskets with 
    eggs as we can. Each basket can hold only 12 eggs.

    1) Write the java code that will calcute how many baskets
    of 12 eggs can we fill fully.

    HINT: What do we get when we divide an integer by 
    an integer in Java

    2) Write the java code that will calculate how many eggs
    are left over after we filled as many baskets of 12 eggs.
*/
    int totalEggs = 100;
    int eggsPerBasket = 12;
    int fullBaskets = totalEggs / eggsPerBasket;
    int leftoverEggs = totalEggs % eggsPerBasket;
    System.out.println("Full baskets: " + fullBaskets);
    System.out.println("Leftover eggs: " + leftoverEggs);




    // **************************************************
    // **** Don't write any code below here.  ***********
    // **************************************************
  }
}