class Main {
    public static void main(String[] args) {
        (new Main()).init();
    }

    void init() {

/*  
    Challenge 1:
    Ask the user to enter an integer and display it.
*/
      System.out.print("Enter an integer: ");
      int userInput = Input.readInt();
      System.out.println("You entered: " + userInput);
	
/*  
    Challenge 2:
    Convert Fahrenheit to Celsius and display the result.
*/
	System.out.print("Enter temperature in Fahrenheit: ");
	  double fahrenheit = Input.readDouble();
	  double celsius = (fahrenheit - 32) * 5.0 / 9.0;
	  System.out.println("Temperature in Celsius: " + celsius);

/*  
    Challenge 3:
    Ask for the radius of a sphere and calculate the volume.
*/
	System.out.print("Enter the radius of the sphere: ");
	  double radius = Input.readDouble();
	  double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	  System.out.println("Volume of the sphere: " + volume);
/*  
    Challenge 4:
    Ask for the radius and height of a cone and calculate the volume.
*/
	System.out.print("Enter the radius of the cone: ");
	  double coneRadius = Input.readDouble();
	  System.out.print("Enter the height of the cone: ");
	  double coneHeight = Input.readDouble();
	  double coneVolume = (1.0 / 3.0) * Math.PI * Math.pow(coneRadius, 2) * coneHeight;
	  System.out.println("Volume of the cone: " + coneVolume);

/*  
    Challenge 5:
    Ask for two points and calculate the distance between them.
*/
	System.out.print("Enter x1: ");
	  double x1 = Input.readDouble();
	  System.out.print("Enter y1: ");
	  double y1 = Input.readDouble();
	  System.out.print("Enter x2: ");
	  double x2 = Input.readDouble();
	  System.out.print("Enter y2: ");
	  double y2 = Input.readDouble();
	  double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	  System.out.println("Distance between two points: " + dist);
	}

}
   