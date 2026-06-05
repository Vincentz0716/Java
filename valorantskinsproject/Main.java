import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

// Compile:
// javac -cp sqlite-jdbc-3.23.1.jar: Main.java
// Run:
// java -cp sqlite-jdbc-3.23.1.jar: Main

class Main {
  public static void main(String[] args) throws IOException{
    (new Main()).init();
  }

  void print(Object o){System.out.println(o);}
  void printt(Object o){System.out.print(o);}

  void init() throws IOException{
    int port = 8500;

    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);

    Database db = new Database("jdbc:sqlite:valorant.db");

    // All Valorant skins
    String skinsSQL =
      "SELECT s.id, s.skin_name, s.weapon_type, s.rarity, s.price_vp, s.release_year, " +
      "c.collection_name, c.theme, c.bundle_tier " +
      "FROM skins s " +
      "INNER JOIN collections c ON s.collection_id = c.id " +
      "ORDER BY c.collection_name ASC, s.weapon_type ASC;";
    server.createContext("/skins", new RouteHandler(db, skinsSQL));

    // Collections page/stat cards
    String collectionsSQL =
      "SELECT c.id, c.collection_name, c.theme, c.bundle_tier, " +
      "COUNT(s.id) AS skin_count, AVG(s.price_vp) AS average_price " +
      "FROM collections c " +
      "INNER JOIN skins s ON c.id = s.collection_id " +
      "GROUP BY c.id, c.collection_name, c.theme, c.bundle_tier " +
      "ORDER BY skin_count DESC;";
    server.createContext("/collections", new RouteHandler(db, collectionsSQL));

    // Weapon breakdown analysis
    String weaponsSQL =
      "SELECT weapon_type, COUNT(id) AS skin_count, AVG(price_vp) AS average_price " +
      "FROM skins " +
      "GROUP BY weapon_type " +
      "ORDER BY skin_count DESC;";
    server.createContext("/weapons", new RouteHandler(db, weaponsSQL));

    // Rarity breakdown
    String raritiesSQL =
      "SELECT rarity, COUNT(id) AS skin_count, AVG(price_vp) AS average_price " +
      "FROM skins " +
      "GROUP BY rarity " +
      "ORDER BY skin_count DESC;";
    server.createContext("/rarities", new RouteHandler(db, raritiesSQL));

    // Analysis route
    String analysisSQL =
      "SELECT c.collection_name, c.bundle_tier, COUNT(s.id) AS skin_count, " +
      "MIN(s.price_vp) AS lowest_price, MAX(s.price_vp) AS highest_price, AVG(s.price_vp) AS average_price " +
      "FROM collections c " +
      "INNER JOIN skins s ON c.id = s.collection_id " +
      "GROUP BY c.collection_name, c.bundle_tier " +
      "ORDER BY skin_count DESC;";
    server.createContext("/analysis", new RouteHandler(db, analysisSQL));

    server.start();

    System.out.println("Server is listening on port "+port);
  }
}
