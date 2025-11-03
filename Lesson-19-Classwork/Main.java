class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
    print(addNums());
    print(generatePin());
  }

  String addNums(){
    int num1 = (int)(Math.random() * 56) - 5;
    int num2 = (int)(Math.random() * 56) - 5;
    return num1 + " + " + num2 + " = ?";
  }

  int generatePin(){
    StringBuilder pin = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      int digit = (int)(Math.random() * 6) + 3;
      pin.append(digit);
    }
    return Integer.parseInt(pin.toString());
  }
}
