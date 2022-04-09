package com.company;

import java.util.ArrayList;

public class Restoran {
    private String naziv;
    private String tipRestorana;
    private ArrayList<Artikal> artikli;
    private Lokacija lokacija;

    public Restoran(String naziv, String tipRestorana, ArrayList<Artikal> artikli, Lokacija lokacija) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.artikli = artikli;
        this.lokacija = lokacija;
    }
}
