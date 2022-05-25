package vezbe.demo.model;

import javax.persistence.*;
import java.beans.FeatureDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TipKupca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private double popust;
    private int trazeni_bodovi;

    @OneToMany (mappedBy = "tip", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //kupac
    private Set<Kupac> kupci = new HashSet<>();

    public TipKupca() {

    }

    public TipKupca(String ime1, double popust, int trazeni_bodovi) {
        this.ime = ime1;
        this.popust = popust;
        this.trazeni_bodovi = trazeni_bodovi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public int getTrazeni_bodovi() {
        return trazeni_bodovi;
    }

    public void setTrazeni_bodovi(int trazeni_bodovi) {
        this.trazeni_bodovi = trazeni_bodovi;
    }

    public Set<Kupac> getKupci() {
        return kupci;
    }

    public void setKupci(Set<Kupac> kupci) {
        this.kupci = kupci;
    }
}
