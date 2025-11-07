class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }
  
  void print(Object o){System.out.println(o);}
  void printt(Object o){System.out.print(o);}

  void init(){
    print("Rolling dice: " + rollDice());
    print("Lotto numbers: " + lotto());
    diceDistribution(1000);
    print(additionTutor());
    print(mathQuiz());
  }

/* 
Challenge 1:
Write a function rollDice that rolls two dice and returns the two values as one string.
Example:
rollDice() ==> "2 6"
rollDice() ==> "3 1"
*/
  String rollDice() {
    int die1 = (int)(Math.random() * 6) + 1;
    int die2 = (int)(Math.random() * 6) + 1;
    return String.valueOf(die1).concat(" ").concat(String.valueOf(die2));
  }

/* 
Challenge 2:
Write a function lotto that returns a string of 5 numbers from 1 to 48.
Example:
lotto() ==> "5 17 23 34 45"
lotto() ==> "1 8 19 28 33"  
*/
  String lotto() {
    String result = String.valueOf((int)(Math.random() * 48) + 1);
    int i = 1;
    while (i < 5) {
      int number = (int)(Math.random() * 48) + 1;
      result = result.concat(" ").concat(String.valueOf(number));
      i++;
    }
    return result;
  }

/* 
Challenge 3:
Write a function diceDistribution that accepts an integer N and rolls a die N times, keeps a counter of the number of times 1,2,3,4,5,6 was rolled (need a counter for each) and displays the counters for each.
  
Try N for 100, 1,000, 100,000, 1,000,000

What do the results look like as the number N gets larger?  
*/
  void diceDistribution(int N) {
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0;
    int i = 0;
    while (i < N) {
      int roll = (int)(Math.random() * 6) + 1;
      if (roll == 1) c1++;
      else if (roll == 2) c2++;
      else if (roll == 3) c3++;
      else if (roll == 4) c4++;
      else if (roll == 5) c5++;
      else c6++;
      i++;
    }

    print("1: " + c1);
    print("2: " + c2);
    print("3: " + c3);
    print("4: " + c4);
    print("5: " + c5);
    print("6: " + c6);
  }

/* 
Challenge 4:
Write a function additionTutor that generates two random numbers and prompts the user for what the sum of the two numbers. If the answer is correct return "Correct!" otherwise return "Incorrect".
*/
  String additionTutor() {
    int num1 = (int)(Math.random() * 100) + 1;
    int num2 = (int)(Math.random() * 100) + 1;
    int correctAnswer = num1 + num2;
    return "What is " + num1 + " + " + num2 + "? Correct answer: " + correctAnswer;
  }

}


