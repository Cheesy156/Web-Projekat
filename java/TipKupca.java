package vezbe.demo.model;

import java.util.Date;
import java.util.Set;

class TipKupca extends Kupac{
    private String ime;
    private double popust;
    private int trazeni_bodovi;

    public TipKupca(String korisnickoIme, String lozinka, String ime, String prezime, String pol, Date datum_rodjenja, Uloga uloga, Set<Porudzbina> porudzbine, int broj_skupljenih_bodova, TipKupca tip, String ime1, double popust, int trazeni_bodovi) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga, porudzbine, broj_skupljenih_bodova, tip);
        this.ime = ime1;
        this.popust = popust;
        this.trazeni_bodovi = trazeni_bodovi;
    }

    @Override
    public String getIme() {
        return ime;
    }

    @Override
    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public int getTrazeni_bodovi() {
        return trazeni_bodovi;
    }

    public void setTrazeni_bodovi(int trazeni_bodovi) {
        this.trazeni_bodovi = trazeni_bodovi;
    }
}
