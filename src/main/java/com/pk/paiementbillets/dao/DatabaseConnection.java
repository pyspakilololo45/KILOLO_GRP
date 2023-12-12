/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pk.paiementbillets.dao;

import com.pk.paiementbillets.PaiementBillets;
import com.pk.paiementbillets.dao.Paiement;
import java.sql.*;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public abstract class DatabaseConnection implements AutoCloseable{
    
    private Connection connection;
    
    public DatabaseConnection(String URL, String user, String pwd) throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/paiement","root" , "");
    }
    public void inserPaiement( String nom, String prix,String numeroBlts, String age, String sexe) throws SQLException{
        String requete = "insert into paiement(nom, numeroBlts, prix, age, sexe) values(?,?,?,?,?)";
        
        try
            (PreparedStatement statement= connection.prepareStatement(requete)){
            
            statement.setString(1, nom);
            statement.setString(2, numeroBlts);
            statement.setString(3, prix);
            statement.setString(4, age);
            statement.setString(3, sexe);
            
            statement.executeUpdate();
            
        }
    }
    public void  updatePaiement(int id,String nom, String prix,String numeroBlts, String age, String sexe) throws SQLException{
        
        String requete = "update paiement set nom=?, prix=?, numeroBlts=?,where id=?";
        
         try
            (PreparedStatement statement= connection.prepareStatement(requete)){
            
            statement.setString(1, nom);
            statement.setString(2, numeroBlts);
            statement.setString(3, prix);
            statement.setString(4, age);
            statement.setString(3, sexe);
            
            statement.executeUpdate();
            
        }
                
    }
    public void  deletePaiement(int id) throws SQLException{
        String requete = "delete from paiement where id =?";
        
        try
            (PreparedStatement statement= connection.prepareStatement(requete)){
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    public  List<Paiement> getAllPaiements() throws SQLException{
        
        List<Paiement> paiements;
        paiements = new ArrayList<>();
                String requete = "select*from paiement";
               
         try
            (PreparedStatement statement=  connection.prepareStatement(requete);
                 ResultSet resultSet = statement.executeQuery()){
             while(resultSet.next())
             {
                 int id = resultSet.getInt("id");
                 String nom = resultSet.getString("nom");
                 String numeroBlts = resultSet.getString("numeroBlts");
                 String prix = resultSet.getString("prix");
                 String age= resultSet.getString("age");
                 String sexe = resultSet.getString("sexe");
                
                 Paiement paiement = new Paiement(nom, prix, numeroBlts, sexe, age);
                 
                 paiements.add(paiement);
             }
         }
         return paiements;
            }
             public Paiement getPaiementById(int id) throws SQLException{
                 String requete = "select*from paiement where id =?";
                 
            try(PreparedStatement statement =connection.prepareStatement(requete)){
                
                     statement.setInt(1, id);
                     
                     try(ResultSet resutSet = statement.executeQuery()){
                         if(resutSet.next()){
                String nom = resutSet.getString("nom");
                String numeroBlts = resutSet.getString("numeroBlts");
                String prix = resutSet.getString("prix");
                
                return new Paiement(nom, prix, numeroBlts, prix, nom);
                        }
                 }
             }
            return null;
        }
             
            @Override
           public void close()throws SQLException{
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
           }
}
            
                
            
                 
          
