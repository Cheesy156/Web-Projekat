package com.company;

import java.util.Date;

public class Menadzer extends Korisnik{
    private Restoran restoran;

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Uloga uloga, Restoran restoran) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
        this.restoran = restoran;
    }
}
