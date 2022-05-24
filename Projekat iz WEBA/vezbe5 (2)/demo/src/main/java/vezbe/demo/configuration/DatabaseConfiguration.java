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

        Artikal pastrmka = new Artikal("Pastrmka sa krompir salatom", 649, VrstaArtikla.jelo, 8, Mera.grami, "Pastrmka sveze pecana sa Jadranskog mora");
        artikalRepository.save(pastrmka);
        Artikal pizza = new Artikal("Pica", 150, VrstaArtikla.jelo, 3, Mera.grami, "Mala capricciosa 30cm");
        artikalRepository.save(pizza);
        Artikal pasta = new Artikal("Pasta carbonare", 360, VrstaArtikla.jelo, 2, Mera.grami ,"Pasta carbonare pravljena kao iz Italije");
        artikalRepository.save(pasta);

        Dostavljac dostavljacSale = new Dostavljac("salecarina", "123456789", "Aleksandar", "Maric", "MUSKI", LocalDate.of(2010, 10, 10), Uloga.Dostavljac);
        dostavljacRepository.save(dostavljacSale);
        Dostavljac dostavljacMarija = new Dostavljac("marijapetrovic", "marijamarija", "Marija", "Petrovic", "Zenski", LocalDate.of(1998, 10, 14), Uloga.Dostavljac);
        dostavljacRepository.save(dostavljacMarija);
        Dostavljac dostavljacIvana = new Dostavljac("ivanajovanovic", "ivanavolimarka", "Ivana", "Jovanovic", "Zenski", LocalDate.of(1995, 12, 03),Uloga.Dostavljac);
        dostavljacRepository.save(dostavljacIvana);

        TipKupca tipKupca = new TipKupca("zlatni", 0.3, 33); //Lupila sam koji su podaci za tip kupca, to treba smisliti lepo

        Kupac kupacSara = new Kupac("sarasavic", "sarasara", "Sara" , "Savic", "Zenski", LocalDate.of(1999, 12 , 10), Uloga.Dostavljac, 11);
        kupacRepository.save(kupacSara);
        Kupac kupacJovan = new Kupac("jovanmaric", "jasamkralj", "Jovan" , "Maric", "Zenski", LocalDate.of(1989, 11 , 05), Uloga.Dostavljac, 12);
        kupacRepository.save(kupacJovan);
        Kupac kupacAnja = new Kupac("anjamilosevic", "anjamanjam", "Anja" , "Milosevic", "Zenski", LocalDate.of(1978, 05 , 10),Uloga.Admin, 28);
        kupacRepository.save(kupacAnja);

        Lokacija lokacijaSrpskaSicilija = new Lokacija(60 , 22, "Veselina Maslese 54A");
        lokacijaRepository.save(lokacijaSrpskaSicilija);
        Lokacija lokacijaMorskiRaj = new Lokacija(31 , 1, "Kace Dejanovic 42");
        lokacijaRepository.save(lokacijaMorskiRaj);

        Set<Artikal> jelovnikSrpskaSicilija = new HashSet<>();
        jelovnikSrpskaSicilija.add(pizza);
        jelovnikSrpskaSicilija.add(pasta);
        Set<Artikal> jelovnikMorskiRaj = new HashSet<>();
        jelovnikMorskiRaj.add(pastrmka);

        Restoran restoranSrpskaSicilija = new Restoran();
        restoranSrpskaSicilija.setNaziv("Srpska Sicilija");
        restoranSrpskaSicilija.setTipRestorana("italijanski");
        restoranSrpskaSicilija.setLokacija(lokacijaSrpskaSicilija);
        restoranSrpskaSicilija.setArtikli(jelovnikSrpskaSicilija);
        restoranRepository.save(restoranSrpskaSicilija);

        Restoran restoranMorskiRaj = new Restoran("Morski raj", "mediteranski", jelovnikMorskiRaj, lokacijaMorskiRaj);
        restoranRepository.save(restoranMorskiRaj);

        Menadzer menadzerAna = new Menadzer("anaparovic", "anabanana", "Ana", "Parovic", "zenski", LocalDate.of(2001, 12, 13), Uloga.Menadzer, restoranSrpskaSicilija);
        menadzerRepository.save(menadzerAna);
        Menadzer menadzerLuka = new Menadzer("lukastajic", "lukaluka", "Luka", "Stajic", "Muski", LocalDate.of(2001, 07, 07), Uloga.Menadzer, restoranMorskiRaj);
        menadzerRepository.save(menadzerLuka);

        Komentar komentar = new Komentar();
        komentar.setKupac(kupacSara);
        komentar.setRestoran(restoranMorskiRaj);
        komentar.setTekst("Prelepa hrana, prelepa usluga, uzivam da dolazim sa porodicom");
        komentar.setOcena(5);
        komentarRepository.save(komentar);

        Porudzbina porudzbina = new Porudzbina(LocalDateTime.now(), 21, Status.u_pripremi);
        porudzbina.setPoruceni_Artikli(jelovnikSrpskaSicilija);
        porudzbina.setKupac(kupacJovan);
        porudzbina.setRestoran(restoranSrpskaSicilija);
        porudzbinaRepository.save(porudzbina);

        return true;
    }
}