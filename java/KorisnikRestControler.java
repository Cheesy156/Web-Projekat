package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.model.Korisnik;
import vezbe.demo.service.KorisnikService;

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
}
