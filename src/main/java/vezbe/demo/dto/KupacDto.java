package vezbe.demo.dto;

import vezbe.demo.model.Komentar;
import vezbe.demo.model.Kupac;
import vezbe.demo.model.Porudzbina;
import vezbe.demo.model.TipKupca;

import java.util.HashSet;
import java.util.Set;

public class KupacDto {
    private Long id;

    private String ime;

    private String prezime;

    private Set<Porudzbina> porudzbine = new HashSet<>();

    private int broj_bodova;

    private TipKupca tip;

    private Set<Komentar> komentari = new HashSet<>();

    public KupacDto(){
    }

    public KupacDto(Long id, String ime, String prezime, Set<Porudzbina> porudzbine, int broj_bodova, TipKupca tip, Set<Komentar> komentari) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.porudzbine = porudzbine;
        this.broj_bodova = broj_bodova;
        this.tip = tip;
        this.komentari = komentari;
    }

    public KupacDto(Kupac kupac){
        this.id = kupac.getId();
        this.ime = kupac.getUsername();
        this.prezime = kupac.getPrezime();
        this.porudzbine = kupac.getPorudzbine();
        this.broj_bodova = kupac.getBroj_skupljenih_bodova();
        this.tip = kupac.getTip();
        this.komentari = kupac.getKomentari();
    }
}
