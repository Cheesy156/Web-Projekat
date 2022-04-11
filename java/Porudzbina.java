package vezbe.demo.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

enum status{obrada, u_pripremi, ceka_dostavljaca, u_transportu, dostavljena, otkazana;}

public class Porudzbina implements Serializable {
    private String uniqueID = UUID.randomUUID().toString();
    private Set<Artikal> poruceni_Artikli;
    private Restoran restoran;

    LocalDateTime vreme = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String vreme_formatirano = vreme.format(format);

    private double cena;
    private String kupac; // korisnicko ime

    private status status;

    @ManyToOne
    @JoinColumn(name = "dostavljac_id")
    private Dostavljac dostavljac;

    public Porudzbina(String uniqueID, Set<Artikal> poruceni_Artikli, Restoran restoran, double cena, String kupac, vezbe.demo.model.status status) {
        this.uniqueID = uniqueID;
        this.poruceni_Artikli = poruceni_Artikli;
        this.restoran = restoran;
        this.cena = cena;
        this.kupac = kupac;
        this.status = status;
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
