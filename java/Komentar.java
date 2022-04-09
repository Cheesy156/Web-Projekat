package com.company;

public class Komentar {
    private Kupac kupac;
    private Restoran restoran;
    private String tekst;
    private int ocena; // od 1 do 5

    public Komentar(Kupac kupac, Restoran restoran, String tekst, int ocena) {
        this.kupac = kupac;
        this.restoran = restoran;
        this.tekst = tekst;
        this.ocena = ocena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public String getTekst() {
        return tekst;
    }

    public int getOcena() {
        return ocena;
    }
}
