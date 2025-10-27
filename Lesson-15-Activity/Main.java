class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }
  
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    print("[" + spaces(5) + "DONE]");
    print(harmonic(5));
    print(sin(10, Math.PI / 6));
    fib(10);
    mTable(10);
    
  }

/* 
Challenge 1:
Write a function spaces that accepts an integer N and returns a string with N spaces.
In the init function display the space with the work "DONE" concatentated at the end.
 
*/


  String spaces(int n){
    String result = "";
    for(int i = 0; i < n; i++){
      result += " ";
    }
    return result;
  }  



/* 
Challenge 2:
Write a function harmonic that accepts an integer N and return the sum of:
1/1 + 1/2 + 1/3 + ...+ 1/N
*/
  double harmonic(int n){
    double sum = 0.0;
    for(int i = 1; i <= n; i++){
      sum += 1.0 / i;
    }
    return sum;
  }
/* 

Challenge 3:
Approximate the function sine. Using the formule in Sine.PNG
Write a function sin that accepts the number of terms to sum and the degree in radiant (pi/6) and return the sum.
*/
  double fact(int n){
    int result = 1;
    for(int i = 2; i <= n; i++){
      result *= i;
    }
    return result;
  }  
  double sin(int terms, double radian){
    double sum = 0.0;
    for(int n = 0; n < terms; n++){
      double numerator = Math.pow(-1, n) * Math.pow(radian, 2*n + 1);
      double denominator = fact(2*n + 1);
      sum += numerator / denominator;
    }
    return sum;
  }
/* 
Challenge 4:
Write function fib where the function accepts a integer N and displays the first N fibinocci numbers. The sequence of numbers are 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,...

Example: N=6 , the function displays: 0, 1, 1, 2, 3, 5
*/
  void fib(int n){
    int a = 0, b = 1;
    for(int i = 0; i < n; i++){
      printt(a + " ");
      int next = a + b;
      a = b;
      b = next;
    }
    print("");
  }
/*
Challenge 5:
Create a function mTable that displays the multiplication table as shown in file MTable.png

HINT: Create a function nRow that can generate and display the numbers in a row. Use that function within a loop to generate all the rows.
*/
  void nRow(int n, int row){
    for(int i = 1; i <= n; i++){
      printt((i * row) + "\t");
    }
    print("");
  }
  
  void mTable(int n){
    for(int i = 1; i <= n; i++){
      nRow(n, i);
    }
  }

  /*
Bonus  Challenge:

NCR (combination) formula is used to find the possible arrangements where selection is done without order consideration 

To calculate the combination of a set with N items being arranged in a grouping of R elements from the set:
nCr = N!/(R!(N-R)!)  (NOTE: N! is fact(N), the function you just wrote above).


Write a function nCr that accepts an integer N and R and returns the permuation. NOTE: Use the function fact from challenge 3 in this function. Test this function before moving on to the next function
    
Write a function biCoeff that accepts an integer N and displays the binomial coeffiecents for 
(A + B)^N expansion.  HINT: You do this by calling nCr function you wrote in a loop from 1 to N

Example: 
Look at BinomialExapansion.png
biCoeff(5) ==> 1 5 10 10 5 1
biCoeff(4) ==> 1 4 6 4 1
*/




  
}