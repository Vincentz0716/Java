class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o); }
  void printt(Object o){ System.out.print(o); }

  void init(){

    String[] friends = {"Alice", "Bob", "Charlie", "David"};

    double[] temperaturesCelsius = {0, 10, 20, 30};
    double[] temperaturesFahrenheit = convert(temperaturesCelsius);

    for (String f : friends) {
      print(f);
    }

    for (double t : temperaturesFahrenheit) {
      print(t);
    }
  }


  String[] friends = {"Alice", "Bob", "Charlie", "David"};

  
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
