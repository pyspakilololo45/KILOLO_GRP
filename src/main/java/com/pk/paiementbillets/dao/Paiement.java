/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pk.paiementbillets.dao;

/**
 *
 * @author USER
 */
public class Paiement {
    
    /**private int id;*/
    private String nom;
    private String sexe;
    private String age;
    private String prix;
    private String numeroBlts;
    
    
    
    public Paiement(){
        
    }
    
    public Paiement(String nom, String prix, String numeroBlts, String sexe, String age ){
        /**this.id = id;*/
        this.nom = nom;
        this.prix = prix;
        this.numeroBlts= numeroBlts;
        this.sexe= sexe;
        this.age= age;
    }

    /**public Paiement(String text, String string, String age, String string0, String numeroBlts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getNumeroBlts() {
        return numeroBlts;
    }

    public void setNumeroBlts(String numeroBlts) {
        this.numeroBlts = numeroBlts;
    }*/
    public String toString(){
        String str;
        if( this.nom != null  && this.age != null && this.sexe != null && this.prix != null && this.numeroBlts != null){
        str = "Description de votre client ";
        str += "nom :"+ this.nom +"\n";
        str += "age :"+ this.age + "\n";
        str += "sexe :"+ this.sexe + "\n";
        str += "prix :"+ this.prix + "\n";
        str += "numeroBlts : "+ this.numeroBlts + "\n";
        }else{
            str = "Aucune information !";
        }
        return str;
    } 
    
}
