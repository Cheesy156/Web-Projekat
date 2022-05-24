package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.LoginDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.service.KorisnikService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class KorisnikBasicController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping ("/")
    public String home() { return  "redirect:/login-form"; }

    @GetMapping("/login-form")
    public String login(Model model){
        LoginDto loginDto = new LoginDto();
        model.addAttribute("login", loginDto);
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session){
        if (loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty())
            return "redirect:/login-form";

        Korisnik korisnik = korisnikService.login(loginDto.getUsername(), loginDto.getPassword());
        if (korisnik == null)
            return "redirect:/login-form";

        session.setAttribute("korisnik", korisnik);
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    public String welcome(){ return "index.html";}

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login-form";
    }

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
