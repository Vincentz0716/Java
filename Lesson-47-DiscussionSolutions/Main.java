import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.sql.*;

import java.net.InetSocketAddress;
import java.util.Map;

//For compiling on the shell on repl: Same on mac
//javac -cp sqlite-jdbc-3.23.1.jar: Main.java
//java -cp sqlite-jdbc-3.23.1.jar: Main

//Use for windows
//javac -cp sqlite-jdbc-3.23.1.jar; Main.java
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }


  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() throws IOException{
   

    // create a port - our Gateway
    int port = 8500;
      
    //create the HTTPserver object
    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);

    // create the database object
    Database db = new Database("jdbc:sqlite:chinook.db");
    
    //create a route handler to repond the a request
    // this is our default route
    server.createContext("/", new RouteHandler("Default route...") );

    // create a route called customers that gets all
    // the customer records
    String sql = "";
    sql  = " Select * from customers ";
    server.createContext("/customers", new RouteHandler(db,sql) );

    // Create a route called a
    sql  = " Select customers.firstname,customers.lastname, ";
    sql += " invoices.invoiceDate from customers ";
    sql += " Inner Join invoices ON customers.customerid=invoices.customerid ";
    server.createContext("/customer/invoices", new RouteHandler(db,sql) );

      
    //Start the server
    server.start();

    System.out.println("Server is listening on port "+port);
       
      
    }    
}


