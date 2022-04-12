package vezbe.demo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {
    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, String pol, Date datum_rodjenja, Uloga uloga, Restoran restoran) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
        this.restoran = restoran;
    }

    public Menadzer() {

    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
