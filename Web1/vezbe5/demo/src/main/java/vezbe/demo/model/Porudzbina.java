package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Porudzbina implements Serializable {
    @Id
    private UUID uniqueID = UUID.randomUUID(); // uid type

    @OneToMany(mappedBy = "porudzbina",fetch = FetchType.LAZY, cascade = CascadeType.ALL) //artikli
    private Set<PoruceniArtikli> poruceni_Artikli = new HashSet<>();

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "restoran_id")//restoran
    private Restoran restoran;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //dostavljac
    private Dostavljac dostavljac;

    private LocalDateTime vreme;

    private double cena;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL) //korisnik
    private Kupac kupac;

    private Status status;

    private LocalDateTime datumPorudzbine;

    public Porudzbina() {
    }

    public Porudzbina(LocalDateTime vreme, double cena, Status status) {
        this.vreme = vreme;
        this.cena = cena;
        this.status = status;
    }

    public Set<PoruceniArtikli> getPoruceni_Artikli() {
        return poruceni_Artikli;
    }

    public void setPoruceni_Artikli(Set<PoruceniArtikli> poruceni_Artikli) {
        this.poruceni_Artikli = poruceni_Artikli;
    }

    public void addPoruceni_Artikli(PoruceniArtikli poruceni_Artikli) { this.poruceni_Artikli.add(poruceni_Artikli);}

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public LocalDateTime getVreme() {
        return vreme;
    }

    public void setVreme(LocalDateTime vreme) {
        this.vreme = vreme;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
    }

    public LocalDateTime getDatumPorudzbine() {
        return datumPorudzbine;
    }

    public void setDatumPorudzbine(LocalDateTime datumPorudzbine) {
        this.datumPorudzbine = datumPorudzbine;
    }
}
