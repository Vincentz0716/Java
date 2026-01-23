import java.io.*;  
import java.util.Scanner;  
import java.util.ArrayList;

class CreateList{
  ArrayList<Student> list = new ArrayList<Student>(); 
  ArrayList<String> courses; 
  ArrayList<String> teachers;
  
  
  CreateList(String fileName)throws Exception{
    String line="";
    int count=0, grade=0;
    String id = "";
    BufferedReader br = new BufferedReader(
              new FileReader("CR101.csv"));  
    line = br.readLine();// skip first line
    while ((line = br.readLine()) != null ){  
      
      String[] s = line.split(","); 
      
      if(id.equals(s[0]) ){
        courses.add(s[3]);
        teachers.add(s[5]);
        
      }
      else{
        if(count!=0){
          list.add(new Student(id,grade,
                teachers,courses,randInt(45,100)));
        }
        
        id = s[0];
        grade = Integer.parseInt(s[2]);
        courses = new ArrayList<String>();
        courses.add(s[3]);
        teachers = new ArrayList<String>();
        teachers.add(s[5]);
        count++;
      }
    }  
    System.out.println("Number of students: "+count);
  }

  Student[] getStudentArray(){
    return  list.toArray(new Student[0]);
  }

  
  private int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }


}