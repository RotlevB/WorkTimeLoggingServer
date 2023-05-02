import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class HTTPServer {
    private LogServer server;

    public HTTPServer() {
        this.server = new LogServer();
    }

    public void start() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/enter", new EnterHandler());
        httpServer.createContext("/exit", new ExitHandler());
        httpServer.createContext("/info", new InfoHandler());
        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("HTTP server is running on port 8080");
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.sendResponseHeaders(statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private class EnterHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Map<String, String> queryParams = getQueryParams(exchange.getRequestURI().getQuery());
            int id = Integer.parseInt(queryParams.get("id"));
            boolean result = server.newEntry(id);
            System.out.println("enter " + result);
            if (result) {
                sendResponse(exchange, 200, "OK");
            } else {
                sendResponse(exchange, 500, "Error");
            }
        }
    }

    private class ExitHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Map<String, String> queryParams = getQueryParams(exchange.getRequestURI().getQuery());
            int id = Integer.parseInt(queryParams.get("id"));
            boolean result = server.newExit(id);
            System.out.println("exit " + result);
            if (result) {
                sendResponse(exchange, 200, "OK");
            } else {
                sendResponse(exchange, 500, "Error");
            }
        }
    }

    private class InfoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Map<String, String> queryParams = getQueryParams(exchange.getRequestURI().getQuery());
            String response;
            if (queryParams.containsKey("id")) {
                int id = Integer.parseInt(queryParams.get("id"));
                response = server.getEmployeeString(id);
            } else {
                response = server.toString();
            }
            System.out.println(response);
            sendResponse(exchange, 200, response);
        }
    }

    private Map<String, String> getQueryParams(String query) {
        Map<String, String> result = new HashMap<>();
        if (query == null) {
            return result;
        }
        String[] queryParams = query.split("&");
        for (String param : queryParams) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                result.put(pair[0], pair[1]);
            }
        }
        return result;
    }
}
