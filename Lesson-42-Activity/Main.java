import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
        (new Main()).init();
    }

    void print(Object o) { System.out.println(o); }

    void init() {

        Database db = new Database("jdbc:sqlite:students.db");

        print("Connected to database\n");

        String sql = "";

        // -------- Challenge 1 --------
        print("Challenge 1 - Checking records");
        sql = "SELECT * FROM CR101 WHERE StudentID='STUDENT1001' AND Period=3;";
        print(db.runSQL(sql, "table-auto"));
        sql = "UPDATE CR101 SET Room='122' WHERE StudentID='STUDENT1001' AND Period=3;";
        print(db.runSQL(sql, "table-auto"));

        // -------- Challenge 2 --------
        print("Challenge 2 - Checking records");
        sql = "SELECT * FROM CR101 WHERE StudentID='STUDENT1200' AND Course='ZQCTEDA';";
        print(db.runSQL(sql, "table-auto"));
        sql = "DELETE FROM CR101 WHERE StudentID='STUDENT1200' AND Course='ZQCTEDA';";
        print(db.runSQL(sql, "table-auto"));

        // -------- Challenge 3 --------
        print("Challenge 3 - Checking records");
        sql = "SELECT * FROM CR101 WHERE (Teacher1='DOYLE' OR Teacher2='DOYLE') AND Period IN (4,5);";
        print(db.runSQL(sql, "table-auto"));
        sql = "UPDATE CR101 SET Room='213' WHERE (Teacher1='DOYLE' OR Teacher2='DOYLE') AND Period IN (4,5);";
        print(db.runSQL(sql, "table-auto"));

        // -------- Challenge 4 --------
        print("Challenge 4 - Checking records");
        sql = "SELECT * FROM CR101 WHERE Course='MQF44QGF' AND Section=1 AND (Teacher1='ARCHETTI' OR Teacher2='ARCHETTI');";
        print(db.runSQL(sql, "table-auto"));
        sql = "UPDATE CR101 SET Teacher1=CASE WHEN Teacher1='ARCHETTI' THEN 'ROFFLER' ELSE Teacher1 END, " +
              "Teacher2=CASE WHEN Teacher2='ARCHETTI' THEN 'ROFFLER' ELSE Teacher2 END " +
              "WHERE Course='MQF44QGF' AND Section=1;";
        print(db.runSQL(sql, "table-auto"));

        // -------- Challenge 5 --------
        print("Challenge 5 - Checking records");
        sql = "SELECT * FROM CR101 WHERE StudentID='STUDENT999';";
        print(db.runSQL(sql, "table-auto"));
        sql = "UPDATE CR101 SET Grade=11, OffClass='Junior' WHERE StudentID='STUDENT999';";
        print(db.runSQL(sql, "table-auto"));

        // -------- Challenge 6 --------
        print("Challenge 6 - Checking student");
        sql = "SELECT * FROM CR101 WHERE StudentID='STUDENT1231';";
        print(db.runSQL(sql, "table-auto"));
        sql = "INSERT INTO CR101 (StudentID, Course, Section, Teacher1, Period, Room, OffClass, Grade) " +
              "VALUES ('STUDENT1231', 'MKUFTC6', 1, 'CASTRO R', 9, '322', '', 0);";
        print(db.runSQL(sql, "table-auto"));

        print("\nAll challenges completed.");
    }
}