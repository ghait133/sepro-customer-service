package com.sepro.customerservice.dto;


public class CustomerGlobalInformation {
    String haarDiagnose;
    String kopfDiagnose;
    String haarstaerke;
    String haarzustand;
    String kopfHautZustand;
    private String bemerkungen;
    Long customerId;
    Long partnerId;

    public String getBemerkungen() {
        return bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getHaarDiagnose() {
        return haarDiagnose;
    }

    public void setHaarDiagnose(String haarDiagnose) {
        this.haarDiagnose = haarDiagnose;
    }

    public String getKopfDiagnose() {
        return kopfDiagnose;
    }

    public void setKopfDiagnose(String kopfDiagnose) {
        this.kopfDiagnose = kopfDiagnose;
    }

    public String getHaarstaerke() {
        return haarstaerke;
    }

    public void setHaarstaerke(String haarstaerke) {
        this.haarstaerke = haarstaerke;
    }

    public String getHaarzustand() {
        return haarzustand;
    }

    public void setHaarzustand(String haarzustand) {
        this.haarzustand = haarzustand;
    }

    public String getKopfHautZustand() {
        return kopfHautZustand;
    }

    public void setKopfHautZustand(String kopfHautZustand) {
        this.kopfHautZustand = kopfHautZustand;
    }

}
