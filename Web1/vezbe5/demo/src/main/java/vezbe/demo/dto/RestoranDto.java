package vezbe.demo.dto;

import vezbe.demo.model.*;

import java.util.Set;

public class RestoranDto {
    private Restoran restoran;

    private Set<Artikal> artikli;

    private String naziv;

    private String tipRestorana;

    private double geografskaDuzina;

    private double geografskaSirina;

    private String adresa;

    private Lokacija lokacija;

    private String menadzer; //username menadzera

    public RestoranDto() {
    }

    // za prikaz svih restorana :/
    public RestoranDto(Restoran restoran) {
        this.naziv = restoran.getNaziv();
        this.tipRestorana = restoran.getTipRestorana();
        this.lokacija = restoran.getLokacija();
        this.artikli = restoran.getArtikli();
    }

    public RestoranDto(String naziv, String tipRestorana, double geografskaDuzina, double geografskaSirina, String adresa, String menadzer) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.geografskaDuzina = geografskaDuzina;
        this.geografskaSirina = geografskaSirina;
        this.adresa = adresa;
        this.menadzer = menadzer;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTipRestorana() {
        return tipRestorana;
    }

    public void setTipRestorana(String tipRestorana) {
        this.tipRestorana = tipRestorana;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public double getGeografskaDuzina() {
        return geografskaDuzina;
    }

    public void setGeografskaDuzina(double geografskaDuzina) {
        this.geografskaDuzina = geografskaDuzina;
    }

    public double getGeografskaSirina() {
        return geografskaSirina;
    }

    public void setGeografskaSirina(double geografskaSirina) {
        this.geografskaSirina = geografskaSirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(String menadzer) {
        this.menadzer = menadzer;
    }

    public Restoran CommunicateRestoran() {
        return new Restoran(naziv, tipRestorana, lokacija);
    }
}
