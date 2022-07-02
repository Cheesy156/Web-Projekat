package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;
import vezbe.demo.service.ArtikalService;
import vezbe.demo.service.KupacService;
import vezbe.demo.service.PorudzbineService;
import vezbe.demo.service.RestoranService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class PorudzbinaRestController {
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private PoruceniArtikliRepository poruceniArtikliRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private KupacService kupacService;

    @Autowired
    private ArtikalService artikalService;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @GetMapping("/api/kupac")
    public ResponseEntity<Set<KupacDto>> listaPorudzbina(HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Kupac)
            return new ResponseEntity("Not a kupac", HttpStatus.BAD_REQUEST);

        Kupac kupac = kupacService.findKupacById(korisnik.getId());

        Set<Porudzbina> porudzbine = kupac.getPorudzbine();

        if(porudzbine.isEmpty())
            return new ResponseEntity("Kupac nema porudzbina", HttpStatus.BAD_REQUEST);

        List<PorudzbinaDto> porudzbinaDtoList = new ArrayList<>();

        for (Porudzbina porudzbina : kupac.getPorudzbine()) {
            PorudzbinaDto porudzbinaDto = new PorudzbinaDto(porudzbina.getUniqueID(), porudzbina.getDatumPorudzbine());

            List<PorudzbinaKupcaDto> porudzbinaKupcaDto = new ArrayList<>();

            for (PoruceniArtikli poruceniArtikli : porudzbina.getPoruceni_Artikli())
                porudzbinaKupcaDto.add(new PorudzbinaKupcaDto(poruceniArtikli.getArtikal().getNaziv(), poruceniArtikli.getArtikal().getCena(), poruceniArtikli.getKolicina()));

            porudzbinaDto.setPorudzbinaKupca(porudzbinaKupcaDto);
            porudzbinaDtoList.add(porudzbinaDto);
        }

        return new ResponseEntity(porudzbinaDtoList, HttpStatus.OK);
    }

    @GetMapping("/api/dostavljac/porudzbine")
    public ResponseEntity<Set<DostavljacDto>> listaPorudzbinaNaCekanju(HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Dostavljac)
            return new ResponseEntity("Not a dostavljac", HttpStatus.BAD_REQUEST);

        Dostavljac dostavljac = dostavljacRepository.getById(korisnik.getId());

        List<PorudzbinaDto> porudzbinaDtoList = new ArrayList<>();

        for (Porudzbina porudzbina : dostavljac.getPorudzbine()) {
            if (porudzbina.getStatus() == Status.ceka_dostavljaca) {
                PorudzbinaDto porudzbinaDto = new PorudzbinaDto(porudzbina.getUniqueID(), porudzbina.getDatumPorudzbine());

                List<PorudzbinaKupcaDto> porudzbinaKupcaDto = new ArrayList<>();

                for (PoruceniArtikli poruceniArtikli : porudzbina.getPoruceni_Artikli())
                    porudzbinaKupcaDto.add(new PorudzbinaKupcaDto(poruceniArtikli.getArtikal().getNaziv(), poruceniArtikli.getArtikal().getCena(), poruceniArtikli.getKolicina()));

                porudzbinaDto.setPorudzbinaKupca(porudzbinaKupcaDto);
                porudzbinaDtoList.add(porudzbinaDto);
            }
        }

        return new ResponseEntity(porudzbinaDtoList, HttpStatus.OK);
    }

    @GetMapping("/api/menadzer/porudzbine")
    public ResponseEntity listaPorudzbinaRestoranu(HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Menadzer)
            return new ResponseEntity("Not a dostavljac", HttpStatus.BAD_REQUEST);

        Menadzer menadzer = menadzerRepository.getById(korisnik.getId());

        List<PorudzbinaDto> porudzbinaDtoList = new ArrayList<>();

        for (Porudzbina porudzbina : porudzbinaRepository.findAll()) {
            if (porudzbina.getRestoran() == menadzer.getRestoran()) {
                PorudzbinaDto porudzbinaDto = new PorudzbinaDto(porudzbina.getUniqueID(), porudzbina.getDatumPorudzbine());

                List<PorudzbinaKupcaDto> porudzbinaKupcaDto = new ArrayList<>();

                for (PoruceniArtikli poruceniArtikli : porudzbina.getPoruceni_Artikli())
                    porudzbinaKupcaDto.add(new PorudzbinaKupcaDto(poruceniArtikli.getArtikal().getNaziv(), poruceniArtikli.getArtikal().getCena(), poruceniArtikli.getKolicina()));

                porudzbinaDto.setPorudzbinaKupca(porudzbinaKupcaDto);
                porudzbinaDtoList.add(porudzbinaDto);
            }
        }

        return new ResponseEntity(porudzbinaDtoList, HttpStatus.OK);
    }


    @PostMapping("/api/kupac/{restoranid}/korpa/dodajukorpu")
    public ResponseEntity<String> dodajUKorpu(@PathVariable(name = "restoranid") Long restoranid, @RequestBody KorpaDto korpaDto, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Kupac)
            return new ResponseEntity("Not a kupac", HttpStatus.BAD_REQUEST);

        Restoran restoran = restoranService.findById(restoranid);

        if (restoran == null)
            return new ResponseEntity("Restoran nije pronadjen", HttpStatus.NOT_FOUND);

        if (restoran.getStatusRestorana() == StatusRestorana.ne_radi)
            return new ResponseEntity("Restoran closed", HttpStatus.FORBIDDEN);

        Artikal artikal = artikalService.getArtikalByNaziv(korpaDto.getNazivArtikla(), restoranid);

        if (artikal == null)
            return new ResponseEntity("Artikal ne postoji", HttpStatus.BAD_REQUEST);

        Kupac kupac = kupacRepository.getById(korisnik.getId());
        if(korpaDto.getKolicina() <= 0)
            return new ResponseEntity("Kolicina ne moze biti nula ili manja od nule", HttpStatus.BAD_REQUEST);

        PoruceniArtikli porudceni = new PoruceniArtikli();
        porudceni.setArtikal(artikal);
        porudceni.setKolicina(korpaDto.getKolicina());
        porudceni.setUkupnaCena(porudceni.getKolicina()*artikal.getCena());
        poruceniArtikliRepository.save(porudceni);

        //ako vec postoji narudzbina dodaj artikle
        for (Porudzbina porudzbina : porudzbinaRepository.findAll()) {
            if (porudzbina.getRestoran().getId() == restoran.getId())
                if (porudzbina.getStatus() == Status.u_korpi)
                    if (porudzbina.getKupac().getId() == kupac.getId()) {
                        porudceni.setPorudzbina(porudzbina);
                        poruceniArtikliRepository.save(porudceni);
                        return ResponseEntity.ok("Uspesno ubaceno u korpu");
                    }
        }

        //korpa ne postoji krejiraj je
        Porudzbina poruci = new Porudzbina();
        poruci.setPoruceni_Artikli(Set.of(porudceni));
        poruci.setDatumPorudzbine(LocalDateTime.now());
        poruci.setRestoran(restoran);
        poruci.setKupac(kupac);
        poruci.setCena(porudceni.getUkupnaCena());
        poruci.setStatus(Status.u_korpi);
        porudzbinaRepository.save(poruci);

        return ResponseEntity.ok("Uspesno ubaceno u korpu");
    }

}
