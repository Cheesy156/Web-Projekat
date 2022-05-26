package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.ArtikalDto;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.*;
import vezbe.demo.service.*;
import vezbe.demo.repository.RestoranRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RestoranRestController {
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private LokacijaService lokacijaService;

    @Autowired
    private ArtikalService artikalService;

    @GetMapping("/api/restorani/all")
    public ResponseEntity<List<RestoranDto>> restoraniAll(){
        return restoranService.getRestorani();
    }

    @GetMapping("/api/restorani/pretrazi")
    public ResponseEntity<List<RestoranDto>> searchBy(@RequestBody RestoranDto restoranDto, HttpSession session){
        //Naziv, tip, lokacija(adresa ili geografska sirina i duzina)
        if (restoranDto.getNaziv().isEmpty() && restoranDto.getAdresa().isEmpty() && restoranDto.getTipRestorana().isEmpty()  /*&& ((restoranDto.getGeografskaDuzina() == null) && (restoranDto.getGeografskaSirina() == null))*/)
            return new ResponseEntity("No search information given", HttpStatus.BAD_REQUEST);

        List<RestoranDto> restoranDtos = new ArrayList<>();

        /*
        if (!restoranDto.getNaziv().isEmpty()) {
            restoranDtos.add());
        }

        if (!restoranDto.getTipRestorana().isEmpty()) {
            restoranDtos.add();
        }

        if (!restoranDto.getAdresa().isEmpty()) {
            restoranDtos.add();
        }
        /*
        if ((restoranDto.getGeografskaSirina() != null) && (restoranDto.getGeografskaSirina() != null)) {
            restoranDtos.add();
        }
        */

        //ukolni duplikate

        return ResponseEntity.ok(restoranDtos);
    }

    @PostMapping("/api/menadzer/restoran/dodaj-artikle")
    public ResponseEntity<String> addArtikal(@RequestBody ArtikalDto artikalDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Menadzer)
            return new ResponseEntity<>("Not a manager", HttpStatus.BAD_REQUEST);

        //ovde je negde greska iskreno ne znam zasto nece nema smisla
        Artikal artikal = new Artikal(artikalDto.getNaziv(), artikalDto.getCena(), artikalDto.getVrstaArtikla(), artikalDto.getKolicina(), artikalDto.getMera(), artikalDto.getOpis());
        artikalService.save(artikal);

        Menadzer menadzer = (Menadzer) korisnik;

        if (menadzer.getRestoran() == null)
            return new ResponseEntity<>("Menadzer nema restoran", HttpStatus.NOT_FOUND);

        Restoran restoran = menadzer.getRestoran();

        restoran.getArtikli().add(artikal);
        restoranService.save(restoran);

        return ResponseEntity.ok("Artikal sacuvan");
    }

    //greska negde idk
    @DeleteMapping("/api/menadzer/restoran/delete-artikal/{id}")
    public ResponseEntity<String> deleteArtikal(@PathVariable(name = "id") Long id, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Menadzer)
            return new ResponseEntity<>("Not a manager", HttpStatus.BAD_REQUEST);

        Menadzer menadzer = (Menadzer) korisnik;

        if (menadzer.getRestoran() == null)
            return new ResponseEntity<>("Menadzer nema restoran", HttpStatus.NOT_FOUND);

        Restoran restoran = menadzer.getRestoran();

        for (Artikal artikal : restoran.getArtikli()) {
            if (artikal.getId().equals(id)) {
                restoran.getArtikli().remove(artikal);
                artikalService.delete(artikal);
                restoranRepository.save(restoran);
                return ResponseEntity.ok("Artikal obrisan");
            }
        }

        return new ResponseEntity<>("Artikal ne postoji u tom restoranu", HttpStatus.NOT_FOUND);
    }

    /* ovo se plasim i da probam
    @PutMapping("/api/menadzer/restoran/izmeni-artikle")
    public ResponseEntity<String> changeArtikal(@PathVariable(name = "id") Long id, @RequestBody ArtikalDto artikalDto, HttpSession session){

    }
    */


    @PostMapping("/api/admin/create/restoran")
    public ResponseEntity<String> createRestoran(@RequestBody RestoranDto restoranDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);

        if (korisnik.getUloga() != Uloga.Admin)
            return new ResponseEntity("Not an admin", HttpStatus.BAD_REQUEST);

        if (menadzerService.findByUsername(restoranDto.getMenadzer()) == null)
            return new ResponseEntity("Menadzer does not exist", HttpStatus.BAD_REQUEST);

        if (menadzerService.findByUsername(restoranDto.getMenadzer()).getRestoran() != null)
            return new ResponseEntity("Menadzer vec ima restoran", HttpStatus.BAD_REQUEST);

        Lokacija lokacija = new Lokacija(restoranDto.getGeografskaDuzina(), restoranDto.getGeografskaSirina(), restoranDto.getAdresa());
        lokacijaService.save(lokacija);

        Restoran restoran = new Restoran(restoranDto.getNaziv(), restoranDto.getTipRestorana(), lokacija);
        restoranService.save(restoran);

        Menadzer menadzer = menadzerService.findByUsername(restoranDto.getMenadzer());
        menadzer.setRestoran(restoran);
        menadzerService.save(menadzer);

        return ResponseEntity.ok("Restoran kreiran");
    }
}
