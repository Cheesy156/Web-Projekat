package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.service.PorudzbineService;

@RestController
public class PorudzbinaRestController {

    /*
    @GetMapping("/api/korpa/info")
    public ResponseEntity<KorpaDto> pregledKorpe(HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if (korisnik == null)
            return new ResponseEntity("Please log in", HttpStatus.NOT_FOUND);
        if (korisnik.getUloga() != Uloga.Kupac)
            return new ResponseEntity("Korisnik nije kupac", HttpStatus.BAD_REQUEST);

        Kupac kupac = (Kupac) korisnik;
        return ResponseEntity.ok();
    }

    @PostMapping("/api/korpa/add")
    */
}
