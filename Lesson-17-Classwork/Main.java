class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void println(Object o){ System.out.println(o);}
  void print(Object o){ System.out.print(o);}

  void init(){

    print(swapLetter("the seen","e","%")); //==> "th% s%%n"
    print(encryption2("abcdefghi")); //==> "aebfcgdhi"
    print(encryption2("abcdefgh")); //==> "aebfcgdh"
    print(encryption3("abcdef")); //==> "afbecd"
    print(encryption3("abcde")); //==> "aebd"
    
  }
/* 
  Problem 1:

Write a function swapLetter that accepts a string to modify, a string find and a string replace.  The function returns a string with all the find letter's and replaces them with the replace string.

Hint:Build a new string.
Example: swapLetter("the seen","e","%")  ==> "th% s%%n"
*/ 
 String swapLetter(String str, String find, String replace){
    String result = "";
    for(int i = 0; i < str.length(); i++){
      String currentChar = str.substring(i, i + 1);
      if(currentChar.equals(find)){
        result += replace;
      } else {
        result += currentChar;
      }
    }
    return result;
  }
/* 
Problem 2:
Write a function encryption2 that accepts a string and returns the string where the orginal string is split in half and each letter from each of the half's is used to create a new string using the 

Example: There are two examples, one is odd number of chars and the second is even number of chars.

encryption2("abcdefghi")==> "aebfcgdhi"

 process:  "abcdefghi" -> "abcd" "efghi"  -> "ae" + "bf" + "cg" + "dh" +"i"  -> "aebfcgdhi"

encryption2("abcdefgh") ==> "aebfcgdh"
 process:  "abcdefgh" -> "abcd" "efgh"  -> "ae" + "bf" + "cg" + "dh"  -> "aebfcgdh"
*/ 
 String encryption2(String str){
    String firstHalf = str.substring(0, str.length() / 2);
    String secondHalf = str.substring(str.length() / 2);
    String result = "";
    
    int maxLength = Math.max(firstHalf.length(), secondHalf.length());
    
    for(int i = 0; i < maxLength; i++){
      if(i < firstHalf.length()){
        result += firstHalf.substring(i, i + 1);
      }
      if(i < secondHalf.length()){
        result += secondHalf.substring(i, i + 1);
      }
    }
    
    return result;
  }

/* 
Problem 3:
Write a function encryption3 that accepts a string and returns the string that rearranges the characters of the incoming string as: 1st,last,2nd,last-1,3rd,last-2,... 
and so on.

Example
encryption3("abcdef")==> "afbecd"
encryption3("abcde")==> "aebd"
*/ 
  String encryption3(String str){
      String result = "";
      int left = 0;
      int right = str.length() - 1;
      
      while(left <= right){
        if(left == right){
          result += str.substring(left, left + 1);
        } else {
          result += str.substring(left, left + 1);
          result += str.substring(right, right + 1);
        }
        left++;
        right--;
      }
      
      return result;
    }

  //will use reverse for problem 3
  String reverse(String s){
    String bld="";
    for(int x=s.length()-1; x>=0; x--)
      bld+=s.substring(x,x+1);

    return bld;
  }


}