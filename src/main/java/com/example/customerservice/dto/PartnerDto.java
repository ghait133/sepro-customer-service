package com.example.customerservice.dto;

import com.example.customerservice.entity.Adresse;

import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class PartnerDto {

    private String email;

    private String telNumbre;

    private String longName;

    private String shortName;

    private Long sector_id;

    private String companyName;

    @OneToOne(targetEntity = Adresse.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "adresse_id", foreignKey = @ForeignKey(name = "id"))
    private Adresse adresse;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumbre() {
        return telNumbre;
    }

    public void setTelNumbre(String telNumbre) {
        this.telNumbre = telNumbre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getSector_id() {
        return sector_id;
    }

    public void setSector_id(Long sector_id) {
        this.sector_id = sector_id;
    }
}
