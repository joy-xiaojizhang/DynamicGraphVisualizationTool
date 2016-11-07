package server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/*
* a simple static http server
*/
public class GraphHttpServer {

	//static String HTML_FILE = "/src/server/browser/dynamic_graph_page.html";
	//static String JS_FILE = "/src/server/browser/draw_graph.js";
	//static String CSS_FILE = "/src/server/browser/page_style.css";
	static String ABS_PATH = new File("").getAbsolutePath() + "/src/server";
  
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/browser", new DisplayHandler());
    //server.createContext("/draw_graph.js", new LoadJsHandler());
    //server.createContext("/page_style.css", new LoadCssHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
  }

  static class DisplayHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
      String file = t.getRequestURI().toString();
      InputStream is = new FileInputStream(ABS_PATH + file);
      StringWriter writer = new StringWriter();
      IOUtils.copy(is, writer, Charset.defaultCharset());
      String response = writer.toString();
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }
}
