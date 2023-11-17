/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginterminal;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

/**
 *
 * @author Dimas Kenang Surya Ardani
 */
public class LoginTerminal {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Gson gson = new Gson (); 
        ErrorHandler handle = new ErrorHandler();
        Boolean loggedIn = false;
        while (true){
        while(true){
            try {
                System.out.print("Pilih Layanan \n1. Login \n2. Registrasi \n Jawaban : ");
                int option = scanner.nextInt();
                scanner.nextLine();
                handle.processOption(option);
                handle.setOption(option);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid option. Please choose 1 or 2.");
            }
        }
        
        while(true){
            try {
                System.out.print("Login \n");
                System.out.println("Enter ID :");
                int Id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Name :");
                String Name = scanner.nextLine();
                System.out.println("Enter Password :");
                String Password = scanner.nextLine();
                handle.processUser(Name, Password);
                user.setId(Id);
                user.setName(Name);
                user.setPassword(Password);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Please fill the form");
            }
        }

        String jsonRequest = gson.toJson(user);
        System.out.println(jsonRequest);
        System.out.println(handle.getOption());
        HttpClient httpClient = HttpClient.newHttpClient();
        
        if (handle.getOption() == 1){
        HttpRequest loginRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:5245/login"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonRequest))
                .build();
        
        HttpResponse<String> loginResponse = httpClient.send(loginRequest, BodyHandlers.ofString());
        System.out.println(loginResponse.body());
        
        } else {
              HttpRequest regisRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:5245/api/UserAPI"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonRequest))
                .build();    
        HttpResponse<String> regisResponse = httpClient.send(regisRequest, BodyHandlers.ofString());
        System.out.println(regisResponse.body());
        }
        }
    }
}