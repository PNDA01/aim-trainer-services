package aimtrainer.aimtrainerservices;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = -8537962680206576813L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private int age;
    private String nom;
    private String mail;

    public User() {
        super();
    }

    public User(String prenom, int age, String nom, String mail) {
        super();
        this.prenom = prenom;
        this.age = age;
        this.nom = nom;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
