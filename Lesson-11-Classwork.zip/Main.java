class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }

  void init(){
    System.out.println(getUsername("vincent@gmail.com"));
    
    System.out.println(splitReverse("Happy Days"));
    System.out.println(splitReverse("apple"));

    System.out.println(createUsername("Vincent","Zhou","226576494"));
    System.out.println(createUsername("joe","biden","123567890"));

    
  }

  
  String getUsername(String email){
    int pos = email.indexOf("@");
    return email.substring(0,pos);
  }

  String splitReverse(String s){
    int middle = s.length()/2;
    return s.substring(middle) + s.substring(0,middle);
  }

  String createUsername(String fName, String lName, String osis){
    return fName.substring(0,1)+lName+osis.substring(osis.length()-4);
  }
}