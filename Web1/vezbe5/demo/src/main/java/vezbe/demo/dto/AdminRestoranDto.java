package vezbe.demo.dto;

import vezbe.demo.model.StatusRestorana;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AdminRestoranDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String naziv;

    private String tipRestorana;

    private String adresa;

    private StatusRestorana statusRestorana;

    public AdminRestoranDto() {
    }

    public AdminRestoranDto(String naziv, String tipRestorana, String adresa, StatusRestorana statusRestorana) {
        this.naziv = naziv;
        this.tipRestorana = tipRestorana;
        this.adresa = adresa;
        this.statusRestorana = statusRestorana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTipRestorana() {
        return tipRestorana;
    }

    public void setTipRestorana(String tipRestorana) {
        this.tipRestorana = tipRestorana;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public StatusRestorana getStatusRestorana() {
        return statusRestorana;
    }

    public void setStatusRestorana(StatusRestorana statusRestorana) {
        this.statusRestorana = statusRestorana;
    }
}
