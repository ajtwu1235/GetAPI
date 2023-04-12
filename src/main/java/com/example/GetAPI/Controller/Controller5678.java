package com.example.GetAPI.Controller;

import com.example.GetAPI.domain.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

public class Controller5678 {

   public void start() throws IOException{

       int port = 5678; // 서버 포트 번호
       HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
       server.createContext("/", new MyHandler());
       server.createContext("/sum",new MyHandler2());
       server.setExecutor(null); // 기본 executor 사용
       server.start();
       System.out.println("Server started on port " + port);

    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {

            String response = """
                    {
                        "message" : "server check "
                    }
                    """;
            t.getResponseHeaders().add("Content-Type", "application/json"); // 응답 헤더 설정
            t.sendResponseHeaders(200, response.getBytes().length); // 응답 코드와 길이 설정
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class MyHandler2 implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {

            // 절대경로를 사용했어요!  쓰실거면 본인 디렉토리 상황에맞게 수정해주세요!
            String filePath ="C:\\Users\\thkim\\SpringProject\\GetAPI\\src\\main\\java\\com\\example\\GetAPI\\data\\input\\user.json";

            ObjectMapper objectMapper = new ObjectMapper();

            int sum=0;
            // JSON 파일 읽기
            User[] users = objectMapper.readValue(new File(filePath),User[].class);

            for(User user: users){
                System.out.println(user.getPost_count());
                sum+=user.getPost_count();
            }


            String response = "{\"sum\": \""+sum+"\"}"; // JSON 형태의 응답 내용
            t.getResponseHeaders().add("Content-Type", "application/json"); // 응답 헤더 설정
            t.sendResponseHeaders(200, response.getBytes().length); // 응답 코드와 길이 설정
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
