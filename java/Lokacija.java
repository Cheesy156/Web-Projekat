package com.company;

public class Lokacija {
    private double GeografskaDuzina;
    private double GeografskaSirina;
    private String Adresa;

    public Lokacija(double geografskaDuzina, double geografskaSirina, String adresa) {
        GeografskaDuzina = geografskaDuzina;
        GeografskaSirina = geografskaSirina;
        Adresa = adresa;
    }

    public double getGeografskaDuzina() {
        return GeografskaDuzina;
    }

    public double getGeografskaSirina() {
        return GeografskaSirina;
    }

    public String getAdresa() {
        return Adresa;
    }
}
