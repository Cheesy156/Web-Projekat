package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.service.*;
import vezbe.demo.repository.RestoranRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
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

        @GetMapping("/api/restoran/all")
        public ResponseEntity<List<RestoranDto>> restoraniAll(HttpSession session){
            List<Restoran> restorani = restoranService.findAll();

            if(restorani.isEmpty())
                return new ResponseEntity("Ne postoji nijedan restoran!", HttpStatus.BAD_REQUEST);

            List<RestoranDto> restoraniDto = new ArrayList<>();
            for(Restoran r : restorani) {
                RestoranDto restoranDto = new RestoranDto(r);
                restoraniDto.add(restoranDto);
            }

            return ResponseEntity.ok(restoraniDto);
        }

        @PostMapping("api/restoran/pretraga/naziv")
        public ResponseEntity<List<RestoranDto>> pretragaNaziv(@RequestBody RestoranNazivDto nazivDto){
            List<Restoran> restorani = restoranService.findByNaziv(nazivDto.getNaziv());

            if(restorani.isEmpty()){
                return new ResponseEntity("Ne postoji nijedan restoran pod tim imenom", HttpStatus.BAD_REQUEST);
            }

            List<RestoranDto> restoraniDto = new ArrayList<>();
            for(Restoran restoran : restorani) {
                RestoranDto restoranDtoPrikaz = new RestoranDto(restoran);
                restoraniDto.add(restoranDtoPrikaz);
            }

            return ResponseEntity.ok(restoraniDto);
        }

        @PostMapping("api/restoran/pretraga/tip")
        public ResponseEntity<List<RestoranDto>> pretragaTip(@RequestBody RestoranTipDto tipDto){
            List<Restoran> restorani = restoranService.findByTip(tipDto.getTipRestorana());

            if(restorani.isEmpty()){
                return new ResponseEntity("Ne postoji nijedan restoran tog tipa", HttpStatus.BAD_REQUEST);
            }

            List<RestoranDto> restoraniDto = new ArrayList<>();
            for(Restoran restoran : restorani){
                RestoranDto restoranDto = new RestoranDto(restoran);
                restoraniDto.add(restoranDto);
            }

            return ResponseEntity.ok(restoraniDto);
        }

        @PostMapping("api/restoran/pretraga/lokacija")
        public ResponseEntity<List<RestoranDto>> pretragaAdresa(@RequestBody RestoranLokacijaDto lokacija){
            List<Restoran> restorani = restoranService.findByLokacija(lokacija.getAdresa());
            if(restorani.isEmpty()){
                return new ResponseEntity("Ne postoji nijedan restoran na toj lokaciji", HttpStatus.BAD_REQUEST);
            }

            List<RestoranDto> restoraniDto = new ArrayList<>();
            for(Restoran restoran : restorani){
                RestoranDto restoranDto = new RestoranDto(restoran);
                restoraniDto.add(restoranDto);
            }

            return ResponseEntity.ok(restoraniDto);
        }

        @GetMapping("/api/restoran/info/{id}")
        public ResponseEntity ispisiRestoran(@PathVariable(name = "id") Long id) {
            List<Restoran> restorani = restoranRepository.findAll();

            for (Restoran restoran : restorani)
                if (restoran.getId().equals(id))
                    return ResponseEntity.ok(restoran);

            return new ResponseEntity("Ne postoji nijedan restoran sa tim id-jem", HttpStatus.BAD_REQUEST);
        }

        @PostMapping("/api/restoran/addArtikle")
        public ResponseEntity<String> addArtikal(@RequestBody ArtikalDto artikalDto, HttpSession session) {
            Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

            if (korisnik == null)
                return new ResponseEntity<>("Please log in", HttpStatus.NOT_FOUND);
            if (korisnik.getUloga() != Uloga.Menadzer)
                return new ResponseEntity<>("Not a manager", HttpStatus.BAD_REQUEST);

            if (artikalService.saveArtikal(artikalDto, korisnik.getUsername()))
                return ResponseEntity.ok("Artikal uspesno dodat");
            return new ResponseEntity("Artikal nije uspesno dodat",HttpStatus.BAD_REQUEST);
        }

        /*
        @DeleteMapping("/api/restoran/deleteArtikal/{id}")
        public ResponseEntity<String> deleteArtikal(@PathVariable(name = "id") Long id, HttpSession session){
            Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

            if (korisnik == null)
                return new ResponseEntity<>("Please log in", HttpStatus.NOT_FOUND);
            if (korisnik.getUloga() != Uloga.Menadzer)
                return new ResponseEntity<>("Not a manager", HttpStatus.BAD_REQUEST);

            if (artikalService.deleteArtikal(korisnik.getUsername()))

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
