package vezbe.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {
    @OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Porudzbina> porudzbine = new HashSet<>();

    private int broj_skupljenih_bodova;
    @OneToOne
    @JoinColumn(name = "tip_id")
    private TipKupca tip;

    @OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Komentar> komentar = new HashSet<>();

    public Kupac(String korisnickoIme, String lozinka, String ime, String prezime, String pol, Date datum_rodjenja, Uloga uloga, Set<Porudzbina> porudzbine, int broj_skupljenih_bodova, TipKupca tip) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
        this.porudzbine = porudzbine;
        this.broj_skupljenih_bodova = broj_skupljenih_bodova;
        this.tip = tip;
    }

    public Kupac() {

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
}
