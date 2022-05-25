package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true)
    private String username;

    private String lozinka;

    private String ime;
    private String prezime;

    private String pol;
    private LocalDate datum_rodjenja;
    private Uloga uloga;

    public Korisnik(String username, String lozinka, String ime, String prezime, String pol, LocalDate datum_rodjenja, Uloga uloga) {
            this.username = username;
            this.lozinka = lozinka;
            this.ime = ime;
            this.prezime = prezime;
            this.pol = pol;
            this.datum_rodjenja = datum_rodjenja;
            this.uloga = uloga;
    }

    public Korisnik() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getPol() {
        return pol;
    }

    public LocalDate getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUsername(String korisnickoIme) {
        this.username = korisnickoIme;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setDatum_rodjenja(LocalDate datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "korisnickoIme='" + username + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pol=" + pol +
                ", datum_rodjenja=" + datum_rodjenja +
                ", uloga=" + uloga +
                '}';
    }
}
