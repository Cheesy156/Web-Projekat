package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StatusRestorana statusRestorana;

    private String naziv;

    private String tipRestorana;

    @ManyToMany
    @JoinTable(name = "RestoranArtikli",
            joinColumns = @JoinColumn(name = "restoran_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artikal_id", referencedColumnName = "id"))
    private Set<Artikal> artikli = new HashSet<>();

    @OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY)
    private Set<Komentar> komentari = new HashSet<>();

    @OneToOne
    private Lokacija lokacija;

    @OneToOne(fetch = FetchType.LAZY)
    private Menadzer menadzer;

    public Restoran() {
    }

    public Restoran(String naziv, String tipRestorana, Set<Artikal> artikli, Lokacija lokacija, StatusRestorana statusRestorana) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.artikli = artikli;
        this.lokacija = lokacija;
        this.statusRestorana = statusRestorana;
    }

    public Restoran(String naziv, String tipRestorana, Lokacija lokacija) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.lokacija = lokacija;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
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

    public StatusRestorana getStatusRestorana() { return statusRestorana; }

    public void setStatusRestorana(StatusRestorana statusRestorana) { this.statusRestorana = statusRestorana; }
}
