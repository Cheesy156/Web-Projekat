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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="restoran_id")
    private Set<Artikal> artikli = new HashSet<>();

    @OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY)
    private Set<Komentar> komentari = new HashSet<>();

    @OneToOne
    private Lokacija lokacija;

    public Restoran() {
    }

    public Restoran(String naziv, String tipRestorana, Set<Artikal> artikli, Lokacija lokacija) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.artikli = artikli;
        this.lokacija = lokacija;
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

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }
}
