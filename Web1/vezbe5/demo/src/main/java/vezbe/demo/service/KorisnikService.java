package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Service;
import vezbe.demo.model.*;
import vezbe.demo.repository.DostavljacRepository;
import vezbe.demo.repository.KorisnikRepository;
import vezbe.demo.repository.KupacRepository;
import vezbe.demo.repository.MenadzerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent())
            return foundKorisnik.get();

        return null;
    }

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public Korisnik save(Korisnik korisnik, Uloga uloga){
        if (uloga.equals(Uloga.Kupac)) {
            kupacRepository.save((Kupac) korisnik);
        }

        if (uloga.equals(Uloga.Menadzer)) {
            menadzerRepository.save((Menadzer) korisnik);
        }

        if (uloga.equals(Uloga.Dostavljac)) {
            dostavljacRepository.save((Dostavljac) korisnik);
        }

        return korisnikRepository.save(korisnik);
    }

    public Korisnik login(String username, String password) {
        Korisnik korisnik = korisnikRepository.getByUsername(username);
        if (korisnik == null)
            return null;

        if (!korisnik.getLozinka().equals(password)) //napraviti proveru za pogresnu sifru ?? idk kako (da ne pise da ne postoji nego da je losa sifra)
            return null;

        return korisnik;
    }
}
