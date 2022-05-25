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

    public void setGeografskaDuzina(double geografskaDuzina) {
        GeografskaDuzina = geografskaDuzina;
    }

    public double getGeografskaSirina() {
        return GeografskaSirina;
    }

    public void setGeografskaSirina(double geografskaSirina) {
        GeografskaSirina = geografskaSirina;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }
}
