import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8500;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Use your Database class
        Database db = new Database("jdbc:sqlite:chinook.db");

        // Default route
        server.createContext("/", exchange -> {
            String message = "Server is running!";
            exchange.sendResponseHeaders(200, message.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(message.getBytes());
            os.close();
        });

        // /tracks route
        server.createContext("/tracks", exchange -> {
            String response;
            try {
                String sql = "SELECT TrackId, Name, AlbumId, Milliseconds, UnitPrice FROM Track";
                response = db.runSQL(sql, "json"); // Your Database class returns JSON
            } catch (Exception e) {
                response = "{\"error\":\"" + e.getMessage().replace("\"","\\\"") + "\"}";
            }
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server listening on port " + port);
    }
}