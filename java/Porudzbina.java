package vezbe.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;

enum status{obrada, u_pripremi, ceka_dostavljaca, u_transportu, dostavljena, otkazana;}

@Entity
public class Porudzbina implements Serializable {
    @Id
    private String uniqueID = UUID.randomUUID().toString();

    @OneToMany(mappedBy = "porudzbina", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Artikal> poruceni_Artikli;

    @OneToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    private Date vreme;

    private double cena;
    private String kupac; // korisnicko ime

    private status status;

    @ManyToOne
    @JoinColumn(name = "dostavljac_id")
    private Dostavljac dostavljac;

    @OneToOne
    @JoinColumn(name = "komentar_id")
    private Komentar komentar;

    public Porudzbina(String uniqueID, Set<Artikal> poruceni_Artikli, Restoran restoran, double cena, String kupac, vezbe.demo.model.status status, Dostavljac dostavljac) {
        this.uniqueID = uniqueID;
        this.poruceni_Artikli = poruceni_Artikli;
        this.restoran = restoran;
        this.cena = cena;
        this.kupac = kupac;
        this.status = status;
    }

    public Porudzbina() {
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
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

    public vezbe.demo.model.status getStatus() {
        return status;
    }

    public void setStatus(vezbe.demo.model.status status) {
        this.status = status;
    }
}
