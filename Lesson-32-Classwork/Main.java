class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o) {
    System.out.println(o);
  }

  void init() {

    double[] g1 = {60, 70, 90};
    double[] g2 = {65, 75, 60};
    double[] g3 = {78, 70, 80};
    double[] g4 = {64, 77, 90};
    double[] g5 = {77, 76, 70};

    String[] courses1 = {"EEFG7QH", "FSFC3", "HQFC3TH", "HUF43X"};
    String[] courses2 = {"MRF43", "PGF43Q3C", "SCF43QG", "HUF43X"};
    String[] courses3 = {"MRF43", "PGF43Q3C", "SCF43QG", "HUF43X"};
    String[] courses4 = {"MRF43", "PGF43Q3C", "SCF43QG", "HUF43X"};
    String[] courses5 = {"MRF43", "PGF43Q3C", "SCF43QG", "HUF43X"};

    // Calculate averages FIRST
    double avg1 = calcAvg(g1);
    double avg2 = calcAvg(g2);
    double avg3 = calcAvg(g3);
    double avg4 = calcAvg(g4);
    double avg5 = calcAvg(g5);

    // Create array
    Student[] studentList = new Student[5];

    // PASS averages (double), NOT arrays
    studentList[0] = new Student("Tom", 9, avg1, courses1);
    studentList[1] = new Student("Jerry", 11, avg2, courses2);
    studentList[2] = new Student("Ren", 10, avg3, courses3);
    studentList[3] = new Student("Stimpy", 9, avg4, courses4);
    studentList[4] = new Student("Krusty", 9, avg5, courses5);

    // Problem 1 & 2
    double[] avgs = {avg1, avg2, avg3, avg4, avg5};
    int above70 = 0;

    for (int i = 0; i < avgs.length; i++) {
      print("Student " + (i + 1) + " average: " + avgs[i]);

      if (avgs[i] > 70) {
        above70++;
      }
    }

    print("Number of students with average above 70: " + above70);
  }

  double calcAvg(double[] grades) {
    double sum = 0;
    for (double g : grades) {
      sum += g;
    }
    return sum / grades.length;
  }
}
