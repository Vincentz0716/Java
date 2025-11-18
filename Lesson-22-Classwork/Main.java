class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o); }
  void printt(Object o){ System.out.print(o); }

  void init(){

    // Problem 1: create an array of friends
    String[] friends = {"Alice", "Bob", "Charlie", "David"};

    // Problem 2: test convert function
    double[] temperaturesCelsius = {0, 10, 20, 30};
    double[] temperaturesFahrenheit = convert(temperaturesCelsius);

    // Print results
    for (String f : friends) {
      print(f);
    }

    for (double t : temperaturesFahrenheit) {
      print(t);
    }
  }

  /*
  Problem 1:
  In the init function, create an array of friends.
  */
  String[] friends = {"Alice", "Bob", "Charlie", "David"};

  /*
  Problem 2:
  convert Celsius array to Fahrenheit array
  */
  double celsiusToFarhenheit(double c){
    return c * 9 / 5 + 32;
  }

  double[] convert(double[] celsiusTemps){
    double[] farhenheitTemps = new double[celsiusTemps.length];
    for(int i = 0; i < celsiusTemps.length; i++){
      farhenheitTemps[i] = celsiusToFarhenheit(celsiusTemps[i]);
    }
    return farhenheitTemps;
  }

}  
