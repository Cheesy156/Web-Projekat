package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Dostavljac extends Korisnik{
    private ArrayList<Porudzbina> porudzbine;

    public Dostavljac(String korisnickoIme, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Uloga uloga, ArrayList<Porudzbina> porudzbine) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
        this.porudzbine = porudzbine;
    }
}
