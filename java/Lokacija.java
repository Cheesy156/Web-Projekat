package vezbe.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Lokacija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double GeografskaDuzina;
    private double GeografskaSirina;
    private String Adresa;

    public Lokacija(double geografskaDuzina, double geografskaSirina, String adresa) {
        GeografskaDuzina = geografskaDuzina;
        GeografskaSirina = geografskaSirina;
        Adresa = adresa;
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
