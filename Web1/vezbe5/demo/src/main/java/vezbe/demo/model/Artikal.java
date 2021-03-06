package vezbe.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artikal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private double cena;
    private VrstaArtikla vrstaArtikla;
    private double kolicina;
    private Mera mera;
    private String opis;

    @ManyToMany (mappedBy = "artikli")
    @JsonIgnore
    private Set<Restoran> restorani = new HashSet<>();

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Porudzbina porudzbina;

    public Artikal() {
    }

    public Artikal(String naziv, double cena, VrstaArtikla vrstaArtikla) {
        this.naziv = naziv;
        this.cena = cena;
        this.vrstaArtikla = vrstaArtikla;
    }

    public Artikal(String naziv, double cena, VrstaArtikla vrstaArtikla, double kolicina) {
        this.naziv = naziv;
        this.cena = cena;
        this.vrstaArtikla = vrstaArtikla;
        this.kolicina = kolicina;
    }

    public Artikal(String naziv, double cena, VrstaArtikla vrstaArtikla, double kolicina, Mera mera, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.vrstaArtikla = vrstaArtikla;
        this.kolicina = kolicina;
        this.mera = mera;
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public VrstaArtikla getVrstaArtikla() {
        return vrstaArtikla;
    }

    public void setVrstaArtikla(VrstaArtikla vrstaArtikla) {
        this.vrstaArtikla = vrstaArtikla;
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
