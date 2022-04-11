package vezbe.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Dostavljac extends Korisnik implements Serializable {
    @OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbine = new HashSet<>();

    public Dostavljac(String korisnickoIme, String lozinka, String ime, String prezime, String pol, Date datum_rodjenja, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
}
