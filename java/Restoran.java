package com.company;

public class Restoran extends Artikal extends Lokacija {
    private String naziv;
    private String tipRestorana;

    public Restoran(String naziv, double cena, com.company.vrstaArtikla vrstaArtikla, String kolicina, com.company.mera mera, String opis, String naziv1, String tipRestorana) {
        super(naziv, cena, vrstaArtikla, kolicina, mera, opis);
        this.naziv = naziv1;
        this.tipRestorana = tipRestorana;
    }
}
