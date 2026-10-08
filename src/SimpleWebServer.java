import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleWebServer {
    public static void main(String[] args) {
        try {
            int port = 8000;
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/", new HelloHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("Server is running on http://localhost:" + port);
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
    static class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = ("Jaden, This is a simple Java server.");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
}