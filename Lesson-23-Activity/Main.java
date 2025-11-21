class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o) { System.out.println(o); }
  void printt(Object o) { System.out.print(o); }

  void init() {
    /* 
    Challenge 1:
    Create an array of emojis and then display each emoji.
    Using the link of unicodes: https://unicode.org/emoji/charts/emoji-list.html

    When printing, use the convertToEmoji function to display
    the actual emoji.
    */
    String[] emojis = {
      "1F600", // Grinning Face
      "1F602", // Face with Tears of Joy
      "1F609", // Winking Face
      "1F60D", // Smiling Face with Heart-Eyes
      "1F618", // Face Blowing a Kiss
      "1F622", // Crying Face
      "1F620", // Angry Face
      "1F634", // Sleeping Face
      "1F44D", // Thumbs Up
      "1F389"  // Party Popper
    };

    for (String code : emojis) {
      print(convertToEmoji(code));
    }

    /*
    Challenge 2:
    Write a function total that accepts an array of prices and returns the sum of prices plus tax. Use a tax rate of 8.525%.
    
    To test the function, create an array of prices in the init function.
    */
    double totalPrice = total(new double[]{19.99, 5.49, 3.50, 12.00});
    print("Total Price (including tax): $" + String.format("%.2f", totalPrice));

    /*
    Challenge 3:
    Create a function isin that accepts an array of integers and an integer number and returns true if the number is in the array, otherwise return false.

    Create an array of integers to test the function isin.
    */
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    boolean found = isin(nums, 5);
    print("Is 5 in the array? " + found);

    /*
    Challenge 4:
    Create a function checkLotto that accepts an array representing 6 lotto number picks and an array representing 6 lotto numbers drawn, and returns how many winning lotto number picks were in the lotto numbers drawn.
    */
    int[] picks = {5, 12, 22, 33, 45, 56};
    int[] drawn = {5, 12, 22, 41, 48, 56};
    int winningCount = checkLotto(picks, drawn);
    print("Number of matching lotto numbers: " + winningCount);

    /*
    Challenge 5:
    Write a function primeList that takes in an integer N and the function returns the first N prime numbers.
    */
    int N = 10;  // Get the first 10 prime numbers
    print("First " + N + " prime numbers: " + primeList(N));
  }

  double total(double[] prices) {
    double sum = 0.0;
    for (double price : prices) {
      sum += price;
    }
    double taxRate = 0.08525;
    sum += sum * taxRate;
    return sum;
  }

    boolean isin(int[] arr, int num) {
      for (int n : arr) {
        if (n == num) {
          return true;
        }
      }
      return false;
    }

  int checkLotto(int[] picks, int[] drawn) {
    int count = 0;
    for (int pick : picks) {
      if (isin(drawn, pick)) {
        count++;
      }
    }
    return count;
  }

  String convertToEmoji(String code) {
    return String.valueOf(Character.toChars(Integer.parseInt(code, 16)));
  }

  int randInt(int lower, int upper) {
    int range = upper - lower;
    return (int)(Math.random() * range + lower);
  }

  boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  // Challenge 5: Prime number list
  String primeList(int N) {
    StringBuilder primes = new StringBuilder();
    int count = 0;
    int num = 2; // Start checking from 2 (smallest prime number)
    while (count < N) {
      if (isPrime(num)) {
        primes.append(num).append(" ");
        count++;
      }
      num++;
    }
    return primes.toString().trim();
  }
}
