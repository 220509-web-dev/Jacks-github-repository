package com.revature.quizzzard;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class Driver {

    public static void main(String[] args) throws InterruptedException {

        try {

            HttpServer httpserver = HttpServer.create(new InetSocketAddress(8080),  0);
            httpserver.setExecutor(Executors.newFixedThreadPool(10));

            httpserver.createContext("/hello", new HelloHandler() );

            //local anonymous class
            HttpContext context = httpserver.createContext("/test-1", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    String payload = "This request was process by thread: " + Thread.currentThread().getName();
                    exchange.sendResponseHeaders(200, payload.length());
                    exchange.getResponseBody().write(payload.getBytes(StandardCharsets.UTF_8));
                    exchange.getResponseBody().close();
                }
            });

            //java 8 lambda expression (inline implementation of a functional interface's ones abstract method)
            httpserver.createContext("/test-2", exchange -> {
                String payload = "This request was handled by a lambda expression handler";
                exchange.sendResponseHeaders(200, payload.length());
                exchange.getResponseBody().write(payload.getBytes(StandardCharsets.UTF_8));
                exchange.getResponseBody().close();
            });

            System.out.println("Application server started on port 8080");
            httpserver.start();

        } catch (IOException e) {
            System.err.println("could not start the web server");
            Thread.sleep(500); //wait 500 ms to log to console
            throw new RuntimeException(e);
        }


    }


}
