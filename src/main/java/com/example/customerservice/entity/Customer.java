package com.example.customerservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends BaseIdEntity{


    String vorname;
    String nachname;
    String email;
    String telNumbre;

    @OneToOne(targetEntity = Adresse.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "adresse_id", foreignKey = @ForeignKey(name = "id"))
    private Adresse adresse;


    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelNumbre() {
        return telNumbre;
    }

    public void setTelNumbre(String telNumbre) {
        this.telNumbre = telNumbre;
    }

}
