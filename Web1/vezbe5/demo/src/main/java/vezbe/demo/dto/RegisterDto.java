package vezbe.demo.dto;

import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Uloga;

import java.time.LocalDate;

public class RegisterDto {
    private String username;

    private String password;

    private String ime;

    private String prezime;

    private String pol;

    private LocalDate datumRodjenja;

    public RegisterDto() {
    }

    public RegisterDto(String username, String password, String ime, String prezime, String pol, LocalDate datumRodjenja) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Korisnik CommunicateKorisnik() {
        return new Korisnik(username, password, ime, prezime, pol, datumRodjenja, Uloga.Kupac);
    }
}
