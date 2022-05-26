package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Uloga;
import vezbe.demo.repository.KorisnikRepository;

import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik Register(Korisnik korisnik, Uloga uloga) {
        if (taken(korisnik.getUsername(), korisnikRepository.findAll()))
            return null;

        if(uloga.equals(Uloga.Kupac))
            return korisnikRepository.save(korisnik);
        return null;
    }

    private boolean taken(String username, List<Korisnik> korisnikList){
        for(Korisnik korisnik: korisnikRepository.findAll())
            if (korisnik.getUsername().equals(username))
                return true;
        return false;
    }
}
