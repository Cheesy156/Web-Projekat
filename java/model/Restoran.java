package vezbe.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private String tipRestorana;

    @OneToMany
    @JoinColumn(name = "restoran")
    private Set<Artikal> artikli = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "restoran")
    private Set<Lokacija> lokacija;

    public Restoran() {
    }

    public Restoran(String naziv, String tipRestorana) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
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

    public String getTipRestorana() {
        return tipRestorana;
    }

    public void setTipRestorana(String tipRestorana) {
        this.tipRestorana = tipRestorana;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Set<Lokacija> getLokacija() {
        return lokacija;
    }

    public void setLokacija(Set<Lokacija> lokacija) {
        this.lokacija = lokacija;
    }
}
