package vezbe.demo.model;

import java.util.Date;

public class Menadzer extends Korisnik{
    private Restoran restoran;

    public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, String pol, Date datum_rodjenja, Uloga uloga, Restoran restoran) {
        super(korisnickoIme, lozinka, ime, prezime, pol, datum_rodjenja, uloga);
        this.restoran = restoran;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
