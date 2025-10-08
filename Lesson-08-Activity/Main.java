class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  // Challenge 1: Display integer
  void displayInteger() {
    System.out.print("Enter an integer: ");
    int userInput = Input.readInt();
    System.out.println("You entered: " + userInput);
  }

  // Challenge 2: Fahrenheit → Celsius
  double fahrenheitToCelsius(double fahrenheit) {
    double v = (fahrenheit - 32) * 5.0 / 9.0;
    return v;
  }

  // Challenge 3: Volume of a sphere
  double volumeOfSphere(double radius) {
    double vs = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    return vs;
  }

  // Challenge 4: Volume of a cone
  double volumeOfCone(double radius, double height) {
    double vc = (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    return vc;
  }

  // Challenge 5: Distance between two points
  double distance(double x1, double y1, double x2, double y2) {
    double D = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    return D;
  }

  void init() {
    // Challenge 1 test
    displayInteger();

    // Challenge 2 test
    System.out.print("Enter temperature in Fahrenheit: ");
    double fahrenheit = Input.readDouble();
    System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(fahrenheit));

    // Challenge 3 test
    System.out.print("Enter the radius of the sphere: ");
    double r = Input.readDouble();
    System.out.println("Volume of the sphere: " + volumeOfSphere(r));

    // Challenge 4 test
    System.out.print("Enter the radius of the cone: ");
    double coneR = Input.readDouble();
    System.out.print("Enter the height of the cone: ");
    double coneH = Input.readDouble();
    System.out.println("Volume of the cone: " + volumeOfCone(coneR, coneH));

    // Challenge 5 test
    System.out.print("Enter x1: ");
    double x1 = Input.readDouble();
    System.out.print("Enter y1: ");
    double y1 = Input.readDouble();
    System.out.print("Enter x2: ");
    double x2 = Input.readDouble();
    System.out.print("Enter y2: ");
    double y2 = Input.readDouble();
    System.out.println("Distance between two points: " + distance(x1, y1, x2, y2));
  }
}