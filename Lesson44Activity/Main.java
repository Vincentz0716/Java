
//For compiling on the shell on repl: Same on mac
//javac -cp sqlite-jdbc-3.23.1.jar: Main.java

//Use for windows
//javac -cp sqlite-jdbc-3.23.1.jar; ServerExample.java
import java.io.IOException;
import java.sql.*;

class Main {

  public static void main(String[] args) throws IOException {
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o); }
  void printt(Object o){ System.out.print(o); }

  void init() {

    String sql = "";
    Database db = new Database("jdbc:sqlite:chinook.db");

    ResultSet rs;

    try {

      // 1
      print("\n--- Problem 1 ---");
      sql = "SELECT t.Name AS TrackName, a.Title AS AlbumName " +
            "FROM Track t " +
            "JOIN Album a ON t.AlbumId = a.AlbumId " +
            "LIMIT 30;";
      rs = db.query(sql);
      while(rs.next()){
        print(rs.getString("TrackName") + " | " + rs.getString("AlbumName"));
      }

      // 2
      print("\n--- Problem 2 ---");
      sql = "SELECT c.FirstName, c.LastName, i.InvoiceId, i.InvoiceDate " +
            "FROM Invoice i " +
            "JOIN Customer c ON i.CustomerId = c.CustomerId " +
            "WHERE i.InvoiceDate BETWEEN '2012-04-01' AND '2012-04-30';";
      rs = db.query(sql);
      while(rs.next()){
        print(rs.getString("FirstName") + " " +
              rs.getString("LastName") + " | " +
              rs.getInt("InvoiceId") + " | " +
              rs.getString("InvoiceDate"));
      }

      // 3
      print("\n--- Problem 3 ---");
      sql = "SELECT i.CustomerId, i.InvoiceId, t.Name AS TrackName, il.UnitPrice, il.Quantity " +
            "FROM Invoice i " +
            "JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId " +
            "JOIN Track t ON il.TrackId = t.TrackId " +
            "LIMIT 20;";
      rs = db.query(sql);
      while(rs.next()){
        print("Customer: " + rs.getInt("CustomerId") +
              " | Invoice: " + rs.getInt("InvoiceId") +
              " | Track: " + rs.getString("TrackName") +
              " | Price: " + rs.getDouble("UnitPrice") +
              " | Qty: " + rs.getInt("Quantity"));
      }

      // 4
      print("\n--- Problem 4 ---");
      sql = "SELECT DISTINCT c.FirstName, c.LastName " +
            "FROM Customer c " +
            "JOIN Invoice i ON c.CustomerId = i.CustomerId " +
            "WHERE i.BillingCountry IN ('USA', 'Germany', 'Poland');";
      rs = db.query(sql);
      while(rs.next()){
        print(rs.getString("FirstName") + " " + rs.getString("LastName"));
      }

      // 5
      print("\n--- Problem 5 ---");
      sql = "SELECT t.Name " +
            "FROM Track t " +
            "JOIN Genre g ON t.GenreId = g.GenreId " +
            "WHERE g.Name = 'Latin' " +
            "LIMIT 20;";
      rs = db.query(sql);
      while(rs.next()){
        print(rs.getString("Name"));
      }

      // 6
      print("\n--- Problem 6 ---");
      sql = "SELECT DISTINCT a.Title " +
            "FROM Album a " +
            "JOIN Track t ON a.AlbumId = t.AlbumId " +
            "JOIN Genre g ON t.GenreId = g.GenreId " +
            "WHERE g.Name = 'Jazz';";
      rs = db.query(sql);
      while(rs.next()){
        print(rs.getString("Title"));
      }

      // 7
      print("\n--- Problem 7 ---");
      sql = "SELECT DISTINCT ar.Name " +
            "FROM Artist ar " +
            "JOIN Album a ON ar.ArtistId = a.ArtistId " +
            "JOIN Track t ON a.AlbumId = t.AlbumId " +
            "JOIN Genre g ON t.GenreId = g.GenreId " +
            "WHERE g.Name = 'Pop';";
      rs = db.query(sql);
      while(rs.next()){
        print(rs.getString("Name"));
      }

    } catch(Exception e){
      print(e);
    }
  }
}