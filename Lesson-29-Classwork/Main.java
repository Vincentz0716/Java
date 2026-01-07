class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o); }
  void printt(Object o){ System.out.print(o); }

  void init(){

    Dog toto = new Dog();
    toto.name = "Toto";
    toto.breed = "Terrier";
    toto.age = 3;

    Dog snoopy = new Dog();
    snoopy.name = "Snoopy";
    snoopy.breed = "Beagle";
    snoopy.age = 5;

    Dog poophy = new Dog();
    poophy.name = "Poophy";
    poophy.breed = "Poodle";
    poophy.age = 2;

    toto.bark();
    snoopy.bark();
    poophy.bark();
  }

  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range + lower);
  }
}
