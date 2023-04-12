package com.example.GetAPI;

import com.example.GetAPI.Controller.Controller5678;
import com.example.GetAPI.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

@SpringBootApplication
public class GetApiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GetApiApplication.class, args);

		Controller5678 controller5678=new Controller5678();
		controller5678.start();


	}



}
