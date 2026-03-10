import java.io.IOException;
import java.sql.*;

class Main {

  public static void main(String[] args) throws IOException {
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o); }

  void init() {

    try {

      Class.forName("org.sqlite.JDBC");
      Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
      Statement stmt = conn.createStatement();
      ResultSet rs;
      String sql;

      // Challenge 2
      print("Challenge 2:");
      sql = "SELECT * FROM cr101 WHERE Teacher1='BANU';";
      rs = stmt.executeQuery(sql);

      while(rs.next()){
        print(rs.getString("StudentID") + " " +
              rs.getString("Course") + " " +
              rs.getString("Teacher1"));
      }

      // Challenge 3
      print("\nChallenge 3:");
      sql = "SELECT * FROM cr101 WHERE Teacher1='PORCHETTA' AND Period=10;";
      rs = stmt.executeQuery(sql);

      while(rs.next()){
        print(rs.getString("StudentID") + " " +
              rs.getString("Course") + " " +
              rs.getInt("Period"));
      }

      // Challenge 4
      print("\nChallenge 4:");
      sql = "SELECT COUNT(StudentID) AS TotalStudents FROM cr101;";
      rs = stmt.executeQuery(sql);

      if(rs.next()){
        print("Total Students: " + rs.getInt("TotalStudents"));
      }

      // Challenge 5
      print("\nChallenge 5:");
      sql = "SELECT StudentID, Course, Period FROM cr101 " +
            "WHERE Room IN (322,105,106,323) AND Grade='11';";
      rs = stmt.executeQuery(sql);

      while(rs.next()){
        print(rs.getString("StudentID") + " " +
              rs.getString("Course") + " " +
              rs.getInt("Period"));
      }

      // Challenge 6
      print("\nChallenge 6:");
      sql = "SELECT * FROM cr101 WHERE Course LIKE 'M%X';";
      rs = stmt.executeQuery(sql);

      while(rs.next()){
        print(rs.getString("StudentID") + " " +
              rs.getString("Course"));
      }

      conn.close();

    } catch(Exception e){
      print(e.getMessage());
    }

  }
}