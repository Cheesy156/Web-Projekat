package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
public class Porudzbina implements Serializable {
    @Id
    private String uniqueID = UUID.randomUUID().toString();

    @OneToMany
    @JoinColumn(name = "porudzbina")
    private Set<Artikal> poruceni_Artikli;

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    private LocalDateTime vreme;

    private double cena;
    private String kupac; // korisnicko ime

    private Status status;

    public Porudzbina() {
    }

    public Porudzbina(LocalDateTime vreme, double cena, Status status) {
        this.vreme = vreme;
        this.cena = cena;
        this.status = status;
    }

    public Set<Artikal> getPoruceni_Artikli() {
        return poruceni_Artikli;
    }

    public void setPoruceni_Artikli(Set<Artikal> poruceni_Artikli) {
        this.poruceni_Artikli = poruceni_Artikli;
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

    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac = kupac;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }
}
