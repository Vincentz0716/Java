class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o) { System.out.println(o); }
  void printt(Object o) { System.out.print(o); }

  void init() {

    double[] g1 = {60, 70, 90};
    double[] g2 = {65, 75, 60};

    String[] courses1 = {"EEFG7QH", "FSFC3", "HQFC3TH", "HUF43X"};
    String[] courses2 = {"MRF43", "PGF43Q3C", "SCF43QG", "HUF43X"};

    // Create two student objects
    Student s1 = new Student("Alice", g1, courses1);
    Student s2 = new Student("Bob", g2, courses2);

    // Test checkCourse method
    print("Alice taking HUF43X? " + s1.checkCourse("HUF43X"));
    print("Alice taking MRF43? " + s1.checkCourse("MRF43"));

    print("Bob taking HUF43X? " + s2.checkCourse("HUF43X"));
    print("Bob taking FSFC3? " + s2.checkCourse("FSFC3"));
  }

  int randInt(int lower, int upper) {
    int range = upper - lower;
    return (int)(Math.random() * range + lower);
  }
}

class Student {
  String name;
  double[] grades;
  String[] courses;

  
  Student(String name, double[] grades, String[] courses) {
    this.name = name;
    this.grades = grades;
    this.courses = courses;
  }

  // Problem 2: checkCourse method
  boolean checkCourse(String course) {
    for (int i = 0; i < courses.length; i++) {
      if (courses[i].equals(course)) {
        return true;
      }
    }
    return false;
  }
}
