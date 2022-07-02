package vezbe.demo.service;

import org.attoparser.prettyhtml.PrettyHtmlMarkupHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.AdminRestoranDto;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.*;
import vezbe.demo.repository.LokacijaRepository;
import vezbe.demo.repository.RestoranRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestoranService {
    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    public List<Restoran> findAll(){
        return restoranRepository.findAll();
    }

    public Restoran findById(Long id) {
        Optional<Restoran> restoran = restoranRepository.findById(id);

        if (restoran.isPresent()) {
            return restoran.get();
        }

        return null;
    }

    public Restoran save(Restoran restoran) {
        return restoranRepository.save(restoran);
    }

    public List<Restoran> findByNaziv(String naziv){
        List<Restoran> lista = findAll();
        List<Restoran> listaByNaziv = new ArrayList<>();

        for(Restoran restoran : lista) {
            if(restoran.getNaziv().equals(naziv))
            {
                listaByNaziv.add(restoran);
            }
        }

        return listaByNaziv;
    }

    public List<Restoran> findByTip(String tip){
        List<Restoran> lista = restoranRepository.findAll();
        List<Restoran> listaByTip = new ArrayList<>();

        for(Restoran restoran : lista){
            if(restoran.getTipRestorana().equals(tip))
            {
                listaByTip.add(restoran);
            }
        }

        return listaByTip;
    }

    //probao sam sa celom lokacijom ali nisam uspeo :/ tako da samo preko adrese
    public List<Restoran> findByLokacija(String adresa){
        List<Restoran> lista = restoranRepository.findAll();
        List<Restoran> listaByLokacija = new ArrayList<>();

        for(Restoran restoran : lista){
            if(restoran.getLokacija().getAdresa().equals(adresa)){
                listaByLokacija.add(restoran);
            }
        }
        return listaByLokacija;
    }

    public boolean proveraLokacije(AdminRestoranDto restoranDto, Restoran restoran) {
        List<Restoran> restorani = restoranRepository.findAll();

        for (Restoran r : restorani)
            if (r.getLokacija().getAdresa().equals(restoranDto.getAdresa())) {
                restoran.setLokacija(r.getLokacija());
                return true;
            }

        Lokacija lokacija = new Lokacija();
        lokacija.setAdresa(restoranDto.getAdresa());
        lokacijaRepository.save(lokacija);
        restoran.setLokacija(lokacija);
        restoranRepository.save(restoran);

        return true;
    }

    public boolean saveCreate(AdminRestoranDto restoranDto) {
        List<Restoran> restorani = restoranRepository.findAll();

        for (Restoran r : restorani)
            if (r.getNaziv().equals(restoranDto.getNaziv()))
                return false;

        Restoran restoran = new Restoran();
        restoran.setStatusRestorana(restoranDto.getStatusRestorana());
        restoran.setTipRestorana(restoranDto.getTipRestorana());
        restoran.setNaziv(restoranDto.getNaziv());

        proveraLokacije(restoranDto, restoran);
        return true;
    }
}
