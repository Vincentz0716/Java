class Main {

  public static void main(String[] args) {
    (new Main()).init();
  }

  void init(){
   
    System.out.println(collegeCredit("MKUFCE1"));
    System.out.println(collegeCredit("MKUFC1"));

    System.out.println(getCounsoler("1D0"));
    System.out.println(getCounsoler("D10"));
    System.out.println(getCounsoler("1F0"));
    System.out.println(getCounsoler("F10"));
    System.out.println(getCounsoler("1C0"));
    System.out.println(getCounsoler("C10"));
    System.out.println(getCounsoler("1G0"));
    System.out.println(getCounsoler("G10"));
    System.out.println(getCounsoler("1E0"));
    System.out.println(getCounsoler("E10"));
    System.out.println(getCounsoler("1B0"));
    System.out.println(getCounsoler("B10"));
    System.out.println(getCounsoler("1L0"));
    System.out.println(getCounsoler("L10"));
    System.out.println(getCounsoler("1M0"));
    System.out.println(getCounsoler("M10"));
    System.out.println(getCounsoler("1P0"));
    System.out.println(getCounsoler("P10"));
    System.out.println(getCounsoler("1S0"));
    System.out.println(getCounsoler("S10"));
    System.out.println(getCounsoler("1T0"));
    System.out.println(getCounsoler("T10"));
    System.out.println(getCounsoler("1Z0"));
    System.out.println(getCounsoler("Z10"));
    System.out.println(getCounsoler("1X0"));
    System.out.println(getCounsoler("X10"));

    System.out.println(imageType("fistQuater.png"));
    System.out.println(imageType("StudentList.PdF"));
    System.out.println(imageType("building1.JPEG"));
    System.out.println(imageType("building2q.jpg"));
    System.out.println(imageType("ironman.gif"));
  }

  boolean collegeCredit(String course){
    if(course.substring(5,6).equals("M") ||
       course.substring(5,6).equals("E") )
      return true;
    else
      return false;
  }
  
  String getCounsoler(String ofcl){
    if(ofcl.substring(0,1).equals("D") || 
       ofcl.substring(1,2).equals("D")){
      return  "Dinn";
    }
    else if(ofcl.substring(0,1).equals("F") || 
       ofcl.substring(1,2).equals("F")){
      return  "Flores";
    }
    else if(ofcl.substring(0,1).equals("C") || 
       ofcl.substring(1,2).equals("C")){
      return  "Chu";
    }
    else if(ofcl.substring(0,1).equals("G") || 
       ofcl.substring(1,2).equals("G")){
      return  "Gibson";
    }
    else if(ofcl.substring(0,1).equals("E") || 
       ofcl.substring(1,2).equals("E")){
      return  "Eyzengart";
    }
    else if(ofcl.substring(0,1).equals("B") || 
       ofcl.substring(1,2).equals("B")){
      return  "Berrouet";
    }
    else if(ofcl.substring(0,1).equals("L") || 
       ofcl.substring(1,2).equals("L")){
      return  "Shim Lee";
    }
    else if(ofcl.substring(0,1).equals("M") || 
       ofcl.substring(1,2).equals("M")){
      return  "Meltzer";
    }
    else if(ofcl.substring(0,1).equals("P") || 
       ofcl.substring(1,2).equals("P")){
      return  "Paccione";
    }
    else if(ofcl.substring(0,1).equals("S") || 
       ofcl.substring(1,2).equals("S")){
      return  "Fiore";
    }
    else if(ofcl.substring(0,1).equals("T") || 
       ofcl.substring(1,2).equals("T")){
      return  "Tsai";
    }
    else if(ofcl.substring(0,1).equals("Z") || 
       ofcl.substring(1,2).equals("Z")){
      return  "Zayes";
    }
    else
      return "Unknown";
  }

  String imageType(String fileName){
    int pos = fileName.indexOf(".");
    
    if (fileName.substring(pos+1).equalsIgnoreCase("JPEG") ||
       fileName.substring(pos+1).equalsIgnoreCase("JPG")){
        return "Joint Photograpic Experts Group";
       }
    else if (fileName.substring(pos+1).equalsIgnoreCase("PNG") ){
        return "Portable Network Graphics";
       }
    else if (fileName.substring(pos+1).equalsIgnoreCase("GIF") ){
        return "Graphics Interchage Format";
       }
    else if (fileName.substring(pos+1).equalsIgnoreCase("PDF") ){
        return "Portalbe Document Format";
       }
    else 
      return "Unknow file type";
  }
}
