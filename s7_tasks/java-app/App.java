import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", e -> {
            byte[] body = "Hello World from Java deployment".getBytes();
            e.sendResponseHeaders(200, body.length);
            e.getResponseBody().write(body);
            e.close();
        });
        server.start();
    }
}
