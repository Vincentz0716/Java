class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }
  
  void print(Object o){ System.out.println(o); }
  void printt(Object o){ System.out.print(o); }

  void init() {

    // Challenge 2: create two Car objects
    Car car1 = new Car("Toyota", "Red", "Camry", 2018, 12000);
    Car car2 = new Car("Honda", "Blue", "Civic", 2015, 9000);

    // Challenge 3: display brand, model, and value
    print(car1.brand + " " + car1.model + " $" + car1.value);
    print(car2.brand + " " + car2.model + " $" + car2.value);

    // Bonus: display brand and model if value > 10,000
    if (car1.value > 10000) {
      print(car1.brand + " " + car1.model);
    }

    if (car2.value > 10000) {
      print(car2.brand + " " + car2.model);
    }
  }

  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }
}

// Car class (from UML)
class Car {

  String brand;
  String color;
  String model;
  int year;
  double value;

  Car(String brand, String color, String model, int year, double value) {
    this.brand = brand;
    this.color = color;
    this.model = model;
    this.year = year;
    this.value = value;
  }

  void honk() {
    System.out.println("Honk!");
  }
}
