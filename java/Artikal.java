package com.company;

enum vrstaArtikla{jelo, pice;}
enum mera{grami, mililitri;}

public class Artikal {
    private String naziv;
    private double cena;
    private vrstaArtikla vrstaArtikla;
    private String kolicina;
    private mera mera;
    private String opis;

    public Artikal(String naziv, double cena, com.company.vrstaArtikla vrstaArtikla, String kolicina, com.company.mera mera, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.vrstaArtikla = vrstaArtikla;
        this.kolicina = kolicina;
        this.mera = mera;
        this.opis = opis;
    }
}
