package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dostavljac extends Korisnik implements Serializable {

    @OneToMany (mappedBy = "dostavljac", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //porudzbina
    private Set<Porudzbina> porudzbine = new HashSet<>();

    public Dostavljac() {
    }

    public Dostavljac(String korisnickoIme, String lozinka, String ime, String prezime, String pol, LocalDate datum_rodjenja, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
}
