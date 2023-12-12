/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pk.paiementbillets;

import com.pk.paiementbillets.dao.DatabaseConnection;
import com.pk.paiementbillets.dao.Paiement;
import com.pk.paiementbillets.dao.GraBlts;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author USER
 */
public class PaiementBillets {

    public static void main(String[] args) {
        
        /**Scanner scanner = new Scanner(System.in);
        try{
                   DatabaseConnection databaseConnection = new DatabaseConnection
        ("jdbc:mysql://localhost:3306/paiement","root" , "");
           System.out.println("Nom du client :");
           String nom = scanner.nextLine();
           System.out.println("Numero Billets :");
           String numeroBlts = scanner.nextLine();
           System.out.println("Montant à Payé");
           String prix = scanner.nextLine();
           
           
                     
               databaseConnection.inserPaiement(nom, prix, numeroBlts);
               
           System.out.println("Paiement enregistré avec succès !");
           
           List<Paiement> paiements =databaseConnection.getAllPaiements();
           for (Paiement paiement: paiements){
               System.out.println(paiement);
           }
            System.out.println("ID du paiement à lire: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Paiement paiement =databaseConnection.getPaiementById(id);
            if(paiement != null){
            System.out.println("Paiement trouvé : "+ paiement);
        }else{
                System.out.println("Aucune paiement trouve avec l'ID spécifié.");
                }
            System.out.println("ID du paiement à mettre à jour: ");
            id = scanner.nextInt();
            scanner.nextInt();
            
            System.out.println("Nouveau nom du client : ");
            nom=scanner.nextLine();
              
            System.out.println("Nouveau numero billets : ");
            numeroBlts=scanner.nextLine();
              
            System.out.println("Nouveau prix : ");
            prix=scanner.nextLine();
            
            databaseConnection.updatePaiement(id, nom, prix, numeroBlts);
            
            System.out.println("Paiement mis à jour avec succès !");
            System.out.println("ID du paiement à Supprimer: ");
            id=scanner.nextInt();
            
            databaseConnection.deletePaiement(id);
            System.out.println("Paiement supprime avec succès !");    
       }catch(SQLException e){
           
           System.out.println("Erreur lors de l'enregistrement du paiement: "
           +e.getMessage());
       }*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraBlts().setVisible(true);
            }
        });
    }  
}
