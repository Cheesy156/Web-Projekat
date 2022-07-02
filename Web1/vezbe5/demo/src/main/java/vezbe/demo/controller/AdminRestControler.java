package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.service.DostavljacService;
import vezbe.demo.service.KorisnikService;
import vezbe.demo.service.MenadzerService;
import vezbe.demo.service.RestoranService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminRestControler {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private DostavljacService dostavljacService;

    @Autowired
    private RestoranService restoranService;

    @GetMapping("api/admin/korisnici")
    public ResponseEntity<List<KorisnikDto>> allUsers(HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Admin)
            return new ResponseEntity("Not a admin", HttpStatus.BAD_REQUEST);

        List<Korisnik> korisnikList = korisnikService.findAll();

        List<KorisnikDto> korisniciDto = new ArrayList<>();

        for (Korisnik k : korisnikList) {
            KorisnikDto korisnikDto = new KorisnikDto(k);
            korisniciDto.add(korisnikDto);
        }

        return ResponseEntity.ok(korisniciDto);
    }

    @PostMapping("api/admin/create/menadzer")
    public ResponseEntity<String> createMenadzer(@RequestBody AdminDto menadzer, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Admin)
            return new ResponseEntity("Not a admin", HttpStatus.BAD_REQUEST);

        if(menadzer.getUloga() != Uloga.Menadzer)
            return new ResponseEntity("Uloga koju kreirate mora biti menadzer", HttpStatus.BAD_REQUEST);

        if (menadzerService.saveCrate(menadzer))
            return ResponseEntity.ok("Menadzer uspesno kreiran");
        return new ResponseEntity("Menadzer pod tim usernamemom vec postoji", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("api/admin/create/dostavljac")
    public ResponseEntity<String> addDostavljac(@RequestBody AdminDto dostavljac, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Admin)
            return new ResponseEntity("Not a admin", HttpStatus.BAD_REQUEST);

        if(dostavljac.getUloga() != Uloga.Dostavljac)
            return new ResponseEntity("Uloga koju kreirate mora biti dostavljac", HttpStatus.BAD_REQUEST);

        if (dostavljacService.saveCreate(dostavljac))
            return ResponseEntity.ok("Dostavljac uspesno kreiran");
        return new ResponseEntity("Dostavljac pod tim usernamemom vec postoji", HttpStatus.BAD_REQUEST);
    }

    /* ne znam sto nece
    @PostMapping("api/admin/create/restoran")
    public ResponseEntity<String> addRestoran(@RequestBody AdminRestoranDto restoranDto, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Admin)
            return new ResponseEntity("Not a admin", HttpStatus.BAD_REQUEST);

        if(restoranService.saveCreate(restoranDto))
            return ResponseEntity.ok("Uspesno kreiran restoran");


        return new ResponseEntity("Vec postoji restoran sa slicnim podacima", HttpStatus.BAD_REQUEST);
    }
     */

    @PutMapping("api/admin/dodeliMenadzera")
    public ResponseEntity<String> dodeliRestoran(@RequestBody DodeliResotranMenadzeruDto dodeliResotranMenadzeruDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Admin)
            return new ResponseEntity("Not a admin", HttpStatus.BAD_REQUEST);

        if(menadzerService.dodeliMuRestoranViseee(dodeliResotranMenadzeruDto.getIdRestorana(), dodeliResotranMenadzeruDto.getIdRestorana()))
            return ResponseEntity.ok("Uspesno dodeljen menadzer restoranu");
        return new ResponseEntity("Restoran vec ima menadzera ili menadzer vec ima restoran ili su id restorana i menadzera netacni", HttpStatus.BAD_REQUEST);
    }
}