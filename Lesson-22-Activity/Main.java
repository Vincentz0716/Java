class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    //Using this array to test your summArray and avgArray function
    int nums[] = {10,15,22,54,32,34,65,87,45,100,23,99,95,87,56,83};

    // test output
    print("Sum: " + sumArray(nums));
    print("Average: " + avgArray(nums));

    // Use these two arrays to test your quizGrader function
    char[] studentAns = {'A','A','B','C','D','C'};
    char[] ansKey = {'A','B','B','C','D','C'};

    // test output
    print("Quiz Grade: " + quizGrader(studentAns, ansKey) + "%");
  }

  //Problem 1:
  // Write a function called sumArray that accepts an array of integers and
  // returns the sum of all the values in the array.
  int sumArray(int arr[]){
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
    }
    return sum;
  }

  //Problem 2
  // Write a function called avgArray that accepts an array of integers and
  // returns the average of the values in the array
  double avgArray(int nums[]){
    int sum = sumArray(nums);
    return (double)sum / nums.length;
  }

  //Problem 3
  // Write a function called quizGrader that accepts two arrays of characters.  One array 
  // represents the students answers and the other array represents the answer key.
  //
  // Return the quiz grade by counting the number of correct answers divided by
  // the number of quistions.
  double quizGrader(char studentAns[], char ansKey[]){
    int correct = 0;
    for(int i = 0; i < studentAns.length; i++){
      if(studentAns[i] == ansKey[i]){
        correct++;
      }
    }
    return (double)correct / studentAns.length * 100.0;
  }
}
