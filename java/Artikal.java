package vezbe.demo.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serial;
import java.io.Serializable;

enum vrstaArtikla{jelo, pice;}
enum mera{grami, mililitri;}

public class Artikal implements Serializable {
    private String naziv;
    private double cena;
    private vrstaArtikla vrstaArtikla;
    private int kolicina;
    private mera mera;
    private String opis;

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Artikal(String naziv, double cena, vezbe.demo.model.vrstaArtikla vrstaArtikla, int kolicina, vezbe.demo.model.mera mera, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.vrstaArtikla = vrstaArtikla;
        this.kolicina = kolicina;
        this.mera = mera;
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public vezbe.demo.model.vrstaArtikla getVrstaArtikla() {
        return vrstaArtikla;
    }

    public void setVrstaArtikla(vezbe.demo.model.vrstaArtikla vrstaArtikla) {
        this.vrstaArtikla = vrstaArtikla;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public vezbe.demo.model.mera getMera() {
        return mera;
    }

    public void setMera(vezbe.demo.model.mera mera) {
        this.mera = mera;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Artikal{" +
                "naziv='" + naziv + '\'' +
                ", cena=" + cena +
                ", vrstaArtikla=" + vrstaArtikla +
                ", kolicina='" + kolicina + '\'' +
                ", mera=" + mera +
                ", opis='" + opis + '\'' +
                '}';
    }
}
