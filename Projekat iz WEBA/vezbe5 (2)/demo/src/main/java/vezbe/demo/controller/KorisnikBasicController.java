package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vezbe.demo.model.Korisnik;
import vezbe.demo.service.KorisnikService;

import java.util.List;

@Controller
public class KorisnikBasicController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping ("/")
    public String welcome() { return  "login.html"; }

    @GetMapping ("/korisnici")
    public String getKorisnici(Model model){
        List<Korisnik> korisnikList = korisnikService.findAll();

        model.addAttribute("korisnici", korisnikList);
        return "korisnici.html";
    }

    @GetMapping ("/korisnici/{id}")
    public String getKorisnik(@PathVariable(name = "id") Long id, Model model){
        Korisnik korisnik = korisnikService.findOne(id);

        model.addAttribute("korisnik", korisnik);
        return  "korisnik.html";
    }

    @GetMapping ("/add-korisnik")
    public String addKorisnik(Model model) {
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "add-korisnik.html";
    }

    @PostMapping ("/save-korisnik")
    public String saveKorisnik(@ModelAttribute Korisnik korisnik) {
        this.korisnikService.save(korisnik);
        return "redirect:/korisnici";
    }
}
