package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {
    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, String pol, LocalDate datum_rodjenja, Uloga uloga, Restoran restoran) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
        this.restoran = restoran;
    }

    public Menadzer(String username, String lozinka, String ime, String prezime, String pol, LocalDate datum_rodjenja, Uloga uloga) {
        super(username, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
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
