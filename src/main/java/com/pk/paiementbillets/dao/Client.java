/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pk.paiementbillets.dao;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Client {
    
    private String serverIp = "127.0.0.1";
   private int serverPort = 8085;
   private Socket socket = null;
   private DataOutputStream dos = null;
   
   public Client(){
       try{
          socket = new Socket(serverIp,serverPort);
          System.out.println("Connexion vers le server etablie");
          dos = new DataOutputStream(socket.getOutputStream());
          
          Scanner sc=new Scanner(System.in);
          
          while(true){
              try{
                 System.out.println("Entrez votre message");
                 String message = sc.nextLine();
                 dos.writeUTF(message);
                 dos.flush();
              }catch(Exception ex){
                  ex.printStackTrace();
                  break;
              }
          }
          dos.close();
          socket.close();
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
}
