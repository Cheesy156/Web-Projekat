package vezbe.demo.dto;

import vezbe.demo.model.Menadzer;
import vezbe.demo.model.Restoran;

public class MenadzerDto {
    private Long id;

    private String ime;

    private String prezime;

    private Restoran restoran;

    public MenadzerDto(){
    }

    public MenadzerDto(Long id, String ime, String prezime, Restoran restoran) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.restoran = restoran;
    }

    public MenadzerDto(Menadzer menadzer){
        this.id = menadzer.getId();
        this.ime = menadzer.getKorisnickoIme();
        this.prezime = menadzer.getPrezime();
        this.restoran = menadzer.getRestoran();
    }
}
