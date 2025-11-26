import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    /*Challenge1: Read in the file Original.txt and store it in a variable */
    String fileContents = "";
    try{
      fileContents = Files.readString(Path.of("Original.txt")); 
    }catch(IOException e){
      print("Error reading file: " + e.getMessage());
      return;
    }    
    
    // Run encoder on the file contents and print result
    String encoded = encode(fileContents);
    print("\nEncoded File Contents:");
    print(encoded);
    // Decode the encoded string and print to verify round-trip
    String decoded = decode(encoded);
    print("\nDecoded File Contents:");
    print(decoded);
  }
/*
   // Challenge2: 
  //  Write the function encode that takes in a string
  //  and create a new string that using a caesar cipher 
  // by shifting all ascii values by 3.  Don't worry about
  // wrapping arount the alphabet.
*/  String encode(String s){
    String encoded = "";
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      c += 3;
      encoded += c;
    }
    return encoded;
  }
  /*
  // Challenge3: 
  //  Write the function decode that takes in a string
  //  and reverses what the function in chanllenge 2
  //  so that you get the original message.
*/  String decode(String s){
    String decoded = "";
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      c -= 3;
      decoded += c;
    }
    return decoded;
  }
  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}