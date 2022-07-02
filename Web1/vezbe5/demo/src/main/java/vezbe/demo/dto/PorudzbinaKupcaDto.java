package vezbe.demo.dto;

public class PorudzbinaKupcaDto {
    private String naziv;

    private double cenaPorudzbine;

    private int kolicina;

    public PorudzbinaKupcaDto(String naziv, double cenaPorudzbine, int kolicina) {
        this.naziv = naziv;
        this.cenaPorudzbine = cenaPorudzbine;
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCenaPorudzbine() {
        return cenaPorudzbine;
    }

    public void setCenaPorudzbine(double cenaPorudzbine) {
        this.cenaPorudzbine = cenaPorudzbine;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
}
