class Main {
    public static void main(String[] args) {
        (new Main()).init();
    }

    void init() {
/*  
    Challenge 1:
    Create the variables, ask the user for the variable values,
    write the equation in file EQ1-act6 and display the equation value.
*/
    System.out.print("Enter value of x: ");
    int x = Input.readInt();
    double y = Math.pow(x, 7);
    System.out.println("The value of y (x^7) is: " + y);

/*  
    Challenge 2:
    Create the variables, ask the user for the variable values,
    write the equation in file EQ1.1-act6 and display the equation value.
*/
    System.out.print("Enter value of a: ");
    int a = Input.readInt();
    double b = Math.pow(a, 3) + 5;
    System.out.println("The value of b (a^3 + 5) is: " + b);

/*  
    Challenge 3:
    Create the variables, ask the user for the variable values,
    write the equation in file EQ2-act6 and display the equation value.
*/
    System.out.print("Enter value of t: ");
    int t = Input.readInt();

    System.out.print("Enter value of r: ");
    int r = Input.readInt();

    double s = Math.pow(t, 5) * Math.pow((r + 2), 4);
    System.out.println("The value of s (t^5 * (r+2)^4) is: " + s);

/*  
    Challenge 4:
    Create the variables, ask the user for the variable values,
     write the equation in file EQ3-act6 and display the equation value.
*/
System.out.print("Enter value of A: ");
int A = Input.readInt();

System.out.print("Enter value of B: ");
int B = Input.readInt();

double C = Math.sqrt(A + B);
System.out.println("The value of C (sqrt(A + B)) is: " + C);

/*  
    Challenge 5:
    Create the variables, ask the user for the variable values,
    write the equation in file EQ4-act6 and display the equation value.
*/
    System.out.print("Enter value of X2: ");
    int X2 = Input.readInt();

    System.out.print("Enter value of X1: ");
    int X1 = Input.readInt();

    System.out.print("Enter value of Y2: ");
    int Y2 = Input.readInt();

    System.out.print("Enter value of Y1: ");
    int Y1 = Input.readInt();

    double D = Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));
    System.out.println("The value of D is: " + D);

/*  
    Challenge 6:
    Create the variables, ask the user for the variable values,
    write the equation g = sin(deg) and display the equation value.
*/
    System.out.print("Enter value of deg: ");
    int deg = Input.readInt();
    double g = Math.sin(Math.toRadians(deg));
    System.out.println("The value of g (sin(deg)) is: " + g);

/*  
    Challenge 7:
    Create the variables, ask the user for the variable values,
    write the equation in file EQ5-act6 and display the equation value.
*/
    System.out.print("Enter value of M: ");
    int M = Input.readInt();

    System.out.print("Enter value of N: ");
    int N = Input.readInt();

    double K = Math.pow(M, 5) / Math.sqrt(N + 1);
    System.out.println("The value of K is: " + K);

/*  
*** Bonus Challenge ***:
    Create the variables, ask the user for the variable values,
    write the equation in file Ch-act6 and display the equation value.

    HINT: What does the "plus minus" after "-b" mean.
    quadratic formula: x = (-b ± √(b² - 4ac)) / 2a
*/
    System.out.print("Enter value of a: ");
    int a1 = Input.readInt(); 
    System.out.print("Enter value of b: ");
    int b1 = Input.readInt();
    System.out.print("Enter value of c: ");
    int c1 = Input.readInt();
    double root1 = (-b1 + Math.sqrt(Math.pow(b1, 2) - 4 * a1 * c1)) / (2 * a1);
    double root2 = (-b1 - Math.sqrt(Math.pow(b1, 2) - 4 * a1 * c1)) / (2 * a1);
    System.out.println("The roots of the equation are: " + root1 + " and " + root2);
            
        
        // **************************************************
        // **** Don't write any code below here.  ***********
        // **************************************************
    }
}
