package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.RegisterDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Uloga;
import vezbe.demo.repository.KorisnikRepository;
import vezbe.demo.service.RegisterService;

import java.util.List;

@RestController
public class RegisterRestController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("api/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if (registerDto.getUsername().isEmpty() || registerDto.getPassword().isEmpty() || registerDto.getIme() == null || registerDto.getPrezime() == null || registerDto.getPol() == null)
            return new ResponseEntity("Invalid data", HttpStatus.BAD_REQUEST);

        Korisnik korisnik = registerService.Register(registerDto.CommunicateKorisnik(), Uloga.Kupac);

        if (korisnik == null)
            return new ResponseEntity("Username taken", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("Registration Completed Successfully");
    }

}
