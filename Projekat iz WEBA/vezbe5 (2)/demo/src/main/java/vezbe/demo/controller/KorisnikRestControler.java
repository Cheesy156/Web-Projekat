package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.LoginDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.service.KorisnikService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class KorisnikRestControler {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/api/")
    public String welcome() { return  "Hello from api!"; }

    @GetMapping("/api/korisnici")
    public List<Korisnik> getKorisnici(){
        List<Korisnik> korisnikList = korisnikService.findAll();

        return korisnikList;
    }

    @GetMapping("/api/korisnici/{id}")
    public Korisnik getKorisnik(@PathVariable(name = "id") Long id){
        Korisnik korisnik = korisnikService.findOne(id);
        return korisnik;
    }

    @PostMapping("/api/save-korisnik")
    public String saveKorisnik(@RequestBody Korisnik korisnik) {
        this.korisnikService.save(korisnik);
        return "Korisnik sacuvan";
    }

    @PostMapping ("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session) {
        if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty())
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getUsername(), loginDto.getPassword());
        if (loggedKorisnik == null)
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Successfully logged in!");
    }

    @PostMapping("/api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);
    }
}
