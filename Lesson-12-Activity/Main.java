class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }

  void init(){
    System.out.println(creditCardType("4111111111111111")); // Visa
    System.out.println(pigLatin("hello")); // ellohay
    System.out.println(nycLocate("10001")); // Manhattan
    System.out.println(getMonth("03/15/2024")); // March
    System.out.println(validatePswd("abcde")); // true
    System.out.println(validatePswd("abcd^")); // false
  }

  String creditCardType(String num){
    if(num.startsWith("4"))
      return "Visa";
    else if (num.startsWith("34") || num.startsWith("37"))
      return "American Express";
    else if (num.startsWith("51") || num.startsWith("55"))
      return "Mastercard";
    else if (num.startsWith("36"))
      return "Diner Club";
    else if (num.startsWith("6011") || num.startsWith("65"))
      return "Discover";
    else
      return "Unknown card";
  }

  String pigLatin(String word){
    return word.substring(1) + word.substring(0,1) + "ay";
  }

  String nycLocate(String zip){
    String pre = zip.substring(0,3);

    if(pre.equals("100") || pre.equals("101") || pre.equals("102"))
      return "Manhattan";
    else if (pre.equals("103"))
      return "Staten Island";
    else if (pre.equals("104"))
      return "Bronx";
    else if (pre.equals("112"))
      return "Brooklyn";
    else if(pre.equals("113") || pre.equals("111") || pre.equals("114"))
      return "Queens";
    else
      return "Unknown";
  }

  String getMonth(String date){
    String month = date.substring(0,2);
    if (month.equals("01"))
      return "January";
    else if (month.equals("02"))
      return "February";
    else if (month.equals("03"))
      return "March";
    else if (month.equals("04"))
      return "April";
    else if (month.equals("05"))
      return "May";
    else if (month.equals("06"))
      return "June";
    else if (month.equals("07"))
      return "July";
    else if (month.equals("08"))
      return "August";
    else if (month.equals("09"))
      return "September";
    else if (month.equals("10"))
      return "October";
    else if (month.equals("11"))
      return "November";
    else if (month.equals("12"))
      return "December";
    else 
      return "Unknown";
  }

  boolean validatePswd(String pswd){
    if(pswd.length()>=5 && pswd.length()<=8){
      if( pswd.indexOf("^")==-1 && 
          pswd.indexOf("*")==-1 &&
          pswd.indexOf("(")==-1 &&
          pswd.indexOf(")")==-1 )
        return true;
      else
        return false;
    }
    else
      return false;
  }

}
