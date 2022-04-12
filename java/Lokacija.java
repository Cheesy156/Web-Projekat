package vezbe.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Lokacija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double GeografskaDuzina;
    private double GeografskaSirina;
    private String Adresa;

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;


    public Lokacija(double geografskaDuzina, double geografskaSirina, String adresa) {
        GeografskaDuzina = geografskaDuzina;
        GeografskaSirina = geografskaSirina;
        Adresa = adresa;
    }

    public Lokacija() {

    }

    public double getGeografskaDuzina() {
        return GeografskaDuzina;
    }

    public double getGeografskaSirina() {
        return GeografskaSirina;
    }

    public String getAdresa() {
        return Adresa;
    }
}
