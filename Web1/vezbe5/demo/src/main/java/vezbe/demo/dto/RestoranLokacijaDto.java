package vezbe.demo.dto;

public class RestoranLokacijaDto {
    private String adresa;

    public RestoranLokacijaDto() {
    }

    public RestoranLokacijaDto(String adresa) {
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
