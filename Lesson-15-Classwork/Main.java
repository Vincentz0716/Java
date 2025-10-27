class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }

  void init(){

    //Genenrate a secret number from 1 to 10
    int n = (int)(Math.random()*(10-1+1)+1);

    System.out.println("Guess a integer from 1 to 10");
    int guess = Input.readInt();

    while(guess != n){
       System.out.println("Guess a integer from 1 to 10");
       guess = Input.readInt();
    }
    System.out.println("You won!!");
    System.out.println("The number was "+n);    
    
  }

}