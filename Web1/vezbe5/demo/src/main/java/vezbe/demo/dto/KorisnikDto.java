package vezbe.demo.dto;

import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Uloga;

import java.time.LocalDate;

public class KorisnikDto {
    private String username;

    private String lozinka;

    private String ime;
    private String prezime;

    private String pol;
    private LocalDate datum_rodjenja;
    private Uloga uloga;

    public KorisnikDto() {
    }

    public KorisnikDto(String username, String lozinka, String ime, String prezime, String pol, LocalDate datum_rodjenja, Uloga uloga) {
        this.username = username;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga = uloga;
    }

    public KorisnikDto(Korisnik k){
        this.username = k.getUsername();
        this.lozinka = k.getLozinka();
        this.ime = k.getIme();
        this.prezime = k.getPrezime();
        this.pol = k.getPol();
        this.datum_rodjenja = k.getDatum_rodjenja();
        this.uloga = k.getUloga();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public LocalDate getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(LocalDate datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }
}
