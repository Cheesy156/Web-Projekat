package vezbe.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
public class DatabaseConfiguration {
    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private TipKupcaRepository tipKupcaRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Bean
    public boolean instantiate(){
        //korisnici
        Korisnik korisnik1 = new Korisnik("Username1", "Xd", "Ime1", "Prezime1", "Muski", new Date(125, Calendar.JULY, 14), Uloga.Kupac);
        Korisnik korisnik2 = new Korisnik("Username2", "Xd", "Ime2", "Prezime2", "Muski", new Date(12, Calendar.JUNE, 20), Uloga.Kupac);
        Korisnik korisnik3 = new Korisnik("Username3", "Xd", "Ime3", "Prezime3", "Zenski", new Date(325, Calendar.JANUARY, 5), Uloga.Menadzer);
        Korisnik korisnik4 = new Korisnik("Username4", "Xd", "Ime4", "Prezime4", "Zenski", new Date(15, Calendar.FEBRUARY, 6), Uloga.Dostavljac);
        Korisnik korisnik5 = new Korisnik("Username5", "fawfaw", "Admin", "Prezime5", "Muski", new Date(15, Calendar.JULY, 23), Uloga.Admin);

        korisnikRepository.saveAll(List.of(korisnik1, korisnik2, korisnik3, korisnik4, korisnik5));

        //lokacije
        Lokacija lokacija1 = new Lokacija(12.2, 32.1, "Negde1");
        Lokacija lokacija2 = new Lokacija(13.5, 54.3, "Negde2");
        Lokacija lokacija3 = new Lokacija(231.2, 78.2, "Negde3");

        lokacijaRepository.saveAll(List.of(lokacija1, lokacija2, lokacija3));

        //artikli
        Artikal artikal1 = new Artikal("Nazi1", 120, VrstaArtikla.jelo, 100, Mera.grami, "jelo1");
        Artikal artikal2 = new Artikal("Nazi3", 1210, VrstaArtikla.pice, 100, Mera.miligrami, "pice");

        artikalRepository.saveAll(List.of(artikal1,artikal2));

        //restoran
        Restoran restoran1 = new Restoran("Restoran1", "Italijanski");
        Restoran restoran2 = new Restoran("Restoran2", "spanski");

        restoran1.setLokacija(Collections.singleton(lokacija1)); //ne znam
        restoran2.setLokacija(Collections.singleton(lokacija2));
        restoran2.setLokacija(Collections.singleton(lokacija3));

        restoran1.setArtikli(Collections.singleton(artikal1));
        restoran1.setArtikli(Collections.singleton(artikal2));

        restoranRepository.saveAll(List.of(restoran1, restoran2));

        //admini
        Admin admin2 = new Admin();
        adminRepository.save(admin2);

        //porudzbina
        Porudzbina porudzbina1 = new Porudzbina(LocalDateTime.now(), 1203.23, Status.dostavljena);
        Porudzbina porudzbina2 = new Porudzbina(LocalDateTime.now(), 1204.23, Status.dostavljena);
        porudzbina1.setKupac(korisnik1.getIme());
        porudzbina2.setKupac(korisnik2.getIme());

        porudzbinaRepository.save(porudzbina1);
        porudzbinaRepository.save(porudzbina2);

        //dostavljac
        Dostavljac dostavljac = new Dostavljac(korisnik4.getKorisnickoIme(), korisnik4.getLozinka(),korisnik4.getIme(), korisnik4.getPrezime(), korisnik4.getPol(), korisnik4.getDatum_rodjenja(), korisnik4.getUloga());
        dostavljac.setPorudzbine(Collections.singleton(porudzbina1)); // ne znam
        dostavljac.setPorudzbine(Collections.singleton(porudzbina2));

        dostavljacRepository.save(dostavljac);
        return true;
    }
}