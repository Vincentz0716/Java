class Main {
  public static void main(String[] args)throws Exception {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init()throws Exception{

    CreateList list=new CreateList("CR101.csv");
    Student[] students = list.getStudentArray();

    // add your code below here

    int passing = 0;
int failing = 0;

// Challenge 1
for(Student s : students){
  if(s.gpa >= 65) passing++;
  else failing++;
}

print("Passing students: " + passing);
print("Failing students: " + failing);

// Challenge 2
double failingPercent = (double)failing / students.length * 100;
print("Percent failing: " + failingPercent + "%");

// Challenge 3
int failingCastro = 0;
for(Student s : students){
  if(s.gpa < 65 && s.findTeacher("Castro R")){
    failingCastro++;
  }
}
print("Failing students with Castro R: " + failingCastro);

// Challenge 4
int failingNoMusic = 0;
for(Student s : students){
  if(s.gpa < 65 && !s.findCourseStartingWith("UL")){
    failingNoMusic++;
  }
}
print("Failing students NOT taking music: " + failingNoMusic);

// Challenge 5
print("Failing students taking music (IDs):");
for(Student s : students){
  if(s.gpa < 65 && s.findCourseStartingWith("UL")){
    print(s.id);
  }
}

// Challenge 6
int freshSophHighGPA = 0;
for(Student s : students){
  if((s.gradeLevel == 9 || s.gradeLevel == 10) && s.gpa > 90){
    freshSophHighGPA++;
  }
}
print("Freshmen & Sophomores with GPA > 90: " + freshSophHighGPA);

// Challenge 7
int bothTeachers = 0;
for(Student s : students){
  if(s.findTeacher("Banu") && s.findTeacher("Porchetta")){
    bothTeachers++;
  }
}
print("Students with BOTH Banu and Porchetta: " + bothTeachers);

// Challenge 8
int freshmen=0, sophomores=0, juniors=0, seniors=0;
for(Student s : students){
  if(s.gradeLevel == 9) freshmen++;
  else if(s.gradeLevel == 10) sophomores++;
  else if(s.gradeLevel == 11) juniors++;
  else if(s.gradeLevel == 12) seniors++;
}

print("Freshmen: " + freshmen);
print("Sophomores: " + sophomores);
print("Juniors: " + juniors);
print("Seniors: " + seniors);

// Challenge 9
int pFresh=0, pSoph=0, pJunior=0, pSenior=0;
for(Student s : students){
  if(s.findTeacher("Porchetta")){
    if(s.gradeLevel == 9) pFresh++;
    else if(s.gradeLevel == 10) pSoph++;
    else if(s.gradeLevel == 11) pJunior++;
    else if(s.gradeLevel == 12) pSenior++;
  }
}

print("Porchetta students by grade:");
print("Freshmen: " + pFresh);
print("Sophomores: " + pSoph);
print("Juniors: " + pJunior);
print("Seniors: " + pSenior);

    
    
  }







  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}