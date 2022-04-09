package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

enum status{obrada, u_pripremi, ceka_dostavljaca, u_transportu, dostavljena, otkazana;}

public class Porudzbina extends Restoran{
    private String uniqueID = UUID.randomUUID().toString();
    private ArrayList<Artikal> poruceni_Artikli;
    private Restoran restoran;

    LocalDateTime vreme = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String vreme_formatirano = vreme.format(format);

    private double cena;
    private String kupac; // korisnicko ime

    private status status;

    public Porudzbina(String naziv, String tipRestorana, ArrayList<Artikal> artikli, Lokacija lokacija, String uniqueID, ArrayList<Artikal> poruceni_Artikli, Restoran restoran, double cena, String kupac, com.company.status status) {
        super(naziv, tipRestorana, artikli, lokacija);
        this.uniqueID = uniqueID;
        this.poruceni_Artikli = poruceni_Artikli;
        this.restoran = restoran;
        this.cena = cena;
        this.kupac = kupac;
        this.status = status;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public ArrayList<Artikal> getPoruceni_Artikli() {
        return poruceni_Artikli;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public double getCena() {
        return cena;
    }

    public String getKupac() {
        return kupac;
    }

    public com.company.status getStatus() {
        return status;
    }

    public void setStatus(com.company.status status) {
        this.status = status;
    }
}
