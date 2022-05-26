package vezbe.demo.dto;

import vezbe.demo.model.Mera;
import vezbe.demo.model.VrstaArtikla;

public class ArtikalDto {
    private String naziv;

    private double cena;

    private VrstaArtikla vrstaArtikla;

    private double kolicina;

    private Mera mera;

    private String opis;

    public ArtikalDto() {
    }

    public ArtikalDto(String naziv, double cena, VrstaArtikla vrstaArtikla, double kolicina, Mera mera, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.vrstaArtikla = vrstaArtikla;
        this.kolicina = kolicina;
        this.mera = mera;
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public VrstaArtikla getVrstaArtikla() {
        return vrstaArtikla;
    }

    public void setVrstaArtikla(VrstaArtikla vrstaArtikla) {
        this.vrstaArtikla = vrstaArtikla;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public Mera getMera() {
        return mera;
    }

    public void setMera(Mera mera) {
        this.mera = mera;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
