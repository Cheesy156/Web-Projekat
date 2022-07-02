package vezbe.demo.dto;

public class RestoranNazivDto {
    public String naziv;

    public RestoranNazivDto() {
    }

    public RestoranNazivDto(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
