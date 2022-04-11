package vezbe.demo.configuration;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.util.*;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;
    @Bean
    public boolean instantiate(){
        Korisnik korisnik1 = new Korisnik("Username1", "Xd", "Ime1", "Prezime1", "Muski", new Date(125, Calendar.JULY, 14), Uloga.Kupac);
        Korisnik korisnik2 = new Korisnik("Username2", "Xd", "Ime2", "Prezime2", "Muski", new Date(12, Calendar.JUNE, 20), Uloga.Kupac);
        Korisnik korisnik3 = new Korisnik("Username3", "Xd", "Ime3", "Prezime3", "Zenski", new Date(325, Calendar.JANUARY, 5), Uloga.Menadzer);
        Korisnik korisnik4 = new Korisnik("Username4", "Xd", "Ime4", "Prezime4", "Zenski", new Date(15, Calendar.FEBRUARY, 6), Uloga.Dostavljac);

        korisnikRepository.saveAll(List.of(korisnik1, korisnik2, korisnik3, korisnik4));

        Lokacija lokacija1 = new Lokacija(12.2, 32.1, "Negde1");
        Lokacija lokacija2 = new Lokacija(13.5, 54.3, "Negde2");
        Lokacija lokacija3 = new Lokacija(231.2, 78.2, "Negde3");

        lokacijaRepository.saveAll(List.of(lokacija1, lokacija2, lokacija3));

        Restoran restoran1 = new Restoran("Restoran1", "Italijanski", lokacija1);
        Restoran restoran2 = new Restoran("Restoran2", "Spanski", lokacija2);
        Restoran restoran3 = new Restoran("Restroan3", "Kineski", lokacija3);
        Restoran restoran4 = new Restoran("Restoran4", "Indijski", lokacija1);

        restoranRepository.saveAll(List.of(restoran1, restoran2, restoran3, restoran4));

        Menadzer menadzer = new Menadzer(korisnik1.getKorisnickoIme(), korisnik1.getLozinka(), korisnik1.getIme(), korisnik1.getPrezime(), korisnik1.getPol(), korisnik1.getDatum_rodjenja(), korisnik1.getUloga(), restoran1);

        menadzerRepository.save(menadzer);

        return true;
    }
}