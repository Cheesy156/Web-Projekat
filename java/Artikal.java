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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public com.company.vrstaArtikla getVrstaArtikla() {
        return vrstaArtikla;
    }

    public void setVrstaArtikla(com.company.vrstaArtikla vrstaArtikla) {
        this.vrstaArtikla = vrstaArtikla;
    }

    public String getKolicina() {
        return kolicina;
    }

    public void setKolicina(String kolicina) {
        this.kolicina = kolicina;
    }

    public com.company.mera getMera() {
        return mera;
    }

    public void setMera(com.company.mera mera) {
        this.mera = mera;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
