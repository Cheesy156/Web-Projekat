package vezbe.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.time.LocalDate;
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

        Artikal cezar_salata = new Artikal("Cezar salata", 320, VrstaArtikla.jelo, 250, Mera.grami, "Cezar licno napravio salatu");
        artikalRepository.save(cezar_salata);
        Artikal bolonjeze = new Artikal("Bolonjeze", 260, VrstaArtikla.pice, 300, Mera.miligrami, "Neke tamo bolonjeze sta znam");
        artikalRepository.save(bolonjeze);
        Artikal becka = new Artikal("Becka", 50000, VrstaArtikla.jelo, 12000, Mera.grami ,"opis");
        artikalRepository.save(becka);

        Dostavljac glovo = new Dostavljac("zutiglovo", "glovo", "Glovo", "Juzvic", "Muski", LocalDate.of(1999, 3, 22), Uloga.Dostavljac);
        dostavljacRepository.save(glovo);
        Dostavljac mrd = new Dostavljac("donesiv2", "donesi", "MR", "D", "Muski", LocalDate.of(2002, 11, 14), Uloga.Dostavljac);
        dostavljacRepository.save(mrd);
        Dostavljac donesi = new Dostavljac("donesi", "odnesi", "NZM", "NZM-PREZIMENOVIC", "Zenski", LocalDate.of(19960, 1, 3),Uloga.Dostavljac);
        dostavljacRepository.save(donesi);

        TipKupca gold = new TipKupca("gold", 0.5, 100);
        TipKupca silver = new TipKupca("silver", 0.35, 50);
        TipKupca bronze = new TipKupca("bronze", 0.02, 20);

        Kupac voja = new Kupac("ime123", "sifra123", "Voja" , "Zivkovic", "Muski", LocalDate.of(2002, 2 , 28), Uloga.Kupac, 84);
        kupacRepository.save(voja);
        Kupac jana = new Kupac("sramota", "jesi", "Jana" , "Tvojic", "Zenski", LocalDate.of(2002, 2 , 21), Uloga.Kupac, 1);
        kupacRepository.save(jana);
        Kupac mina = new Kupac("minatvojic", "lol", "Mina" , "Tvojic", "Zenski", LocalDate.of(1999, 9 , 11),Uloga.Kupac, 100);
        kupacRepository.save(mina);
        Kupac kristina = new Kupac("krtina", "krtina", "Kristina" , "Stevanovic", "Zenski", LocalDate.of(1961, 7 , 14),Uloga.Kupac, 150);
        kupacRepository.save(kristina);
        Kupac tina = new Kupac("tina00", "001218", "Tina" , "Andrijanovic", "Zenski", LocalDate.of(2000, 12 , 18),Uloga.Kupac, 0);
        kupacRepository.save(tina);

        Lokacija bahus = new Lokacija(44 , 21, "Kralja Aleksandra I Karadjordjevica 75");
        lokacijaRepository.save(bahus);
        Lokacija hajd = new Lokacija(45 , 23, "Veliki Park 21");
        lokacijaRepository.save(hajd);

        Set<Artikal> bahusJelovnik = new HashSet<>();
        artikalRepository.saveAll(bahusJelovnik);
        bahusJelovnik.add(cezar_salata);
        artikalRepository.saveAll(bahusJelovnik);

        Set<Artikal> hajdJelovnik = new HashSet<>();
        artikalRepository.saveAll(hajdJelovnik);
        hajdJelovnik.add(becka);
        hajdJelovnik.add(bolonjeze);
        artikalRepository.saveAll(hajdJelovnik);


        Restoran restoranBahus = new Restoran();
        restoranBahus.setNaziv("Bahus");
        restoranBahus.setTipRestorana("srpski");
        restoranBahus.setLokacija(bahus);
        restoranBahus.setArtikli(bahusJelovnik);
        restoranBahus.setStatusRestorana(StatusRestorana.radi);
        restoranRepository.save(restoranBahus);

        Restoran restoranHajd = new Restoran("Hajd", "italijanski", hajdJelovnik, hajd, StatusRestorana.ne_radi);
        restoranRepository.save(restoranHajd);

        Menadzer dusan = new Menadzer("pinki", "1234", "Dusan", "Pekic", "Muski", LocalDate.of(1998, 1, 3), Uloga.Menadzer, restoranBahus);
        menadzerRepository.save(dusan);
        Menadzer dusan1 = new Menadzer("pinki1", "1234", "Dusan1", "Pekic1", "Muski", LocalDate.of(1998, 1, 3), Uloga.Menadzer);
        menadzerRepository.save(dusan1);

        Komentar komentar = new Komentar();
        komentar.setKupac(tina);
        komentar.setRestoran(restoranBahus);
        komentar.setTekst("Sta je ovo");
        komentar.setOcena(1);
        komentarRepository.save(komentar);

        Porudzbina porudzbina = new Porudzbina(LocalDateTime.now(), 0, Status.ceka_dostavljaca);
        PoruceniArtikli poruceniArtikli = new PoruceniArtikli(porudzbina, becka, 3, becka.getCena()*3);
        PoruceniArtikli poruceniArtikli2 = new PoruceniArtikli(porudzbina, cezar_salata, 1, cezar_salata.getCena()*1);
        porudzbina.setPoruceni_Artikli(Set.of(poruceniArtikli, poruceniArtikli2));
        porudzbina.setKupac(jana);
        porudzbina.setRestoran(restoranBahus);
        porudzbina.setDostavljac(mrd);
        porudzbina.setDatumPorudzbine(LocalDateTime.now());
        porudzbina.setCena(poruceniArtikli.getUkupnaCena()+poruceniArtikli.getUkupnaCena());
        porudzbinaRepository.save(porudzbina);

        Korisnik admin = new Korisnik("admin", "admin", "ABC", "ABC", "Muski", LocalDate.of(1990, 1, 2), Uloga.Admin);
        korisnikRepository.save(admin);
        return true;
    }
}