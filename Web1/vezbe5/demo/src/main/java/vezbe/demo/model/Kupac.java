package vezbe.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {
    @OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //porudzbine
    private Set<Porudzbina> porudzbine = new HashSet<>();

    private int broj_skupljenih_bodova;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL) //tip kupca
    private TipKupca tip;

    @OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY) //komentari
    private Set<Komentar> komentari = new HashSet<>();

    public Kupac() {

    }

    public Kupac(String korisnickoIme, String lozinka, String ime, String prezime, String pol, LocalDate datum_rodjenja, Uloga uloga, int broj_skupljenih_bodova) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
        this.broj_skupljenih_bodova = broj_skupljenih_bodova;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }

    public int getBroj_skupljenih_bodova() {
        return broj_skupljenih_bodova;
    }

    public void setBroj_skupljenih_bodova(int broj_skupljenih_bodova) {
        this.broj_skupljenih_bodova = broj_skupljenih_bodova;
    }

    public TipKupca getTip() {
        return tip;
    }

    public void setTip(TipKupca tip) {
        this.tip = tip;
    }

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }
}
