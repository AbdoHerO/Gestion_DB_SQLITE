package com.example.abdohero.gestion;

/**
 * Created by abdohero on 11/19/17.
 */

public class Contact {
    private String nom;
    private String prenom;
    private int age;
    private String email;
    private String phone;
    private String id;
    public Contact()
    {

    }
    public Contact(String id,String nom, String prenom, int age, String email, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.id=id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
