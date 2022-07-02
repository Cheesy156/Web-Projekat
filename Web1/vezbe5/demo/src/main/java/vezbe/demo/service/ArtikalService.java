package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.ArtikalDto;
import vezbe.demo.model.Artikal;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Menadzer;
import vezbe.demo.model.Restoran;
import vezbe.demo.repository.ArtikalRepository;
import vezbe.demo.repository.MenadzerRepository;
import vezbe.demo.repository.RestoranRepository;

import java.util.List;
import java.util.Set;

@Service
public class ArtikalService {
    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    public void save(Artikal artikal) {
        artikalRepository.save(artikal);
    }

    public boolean saveArtikal(ArtikalDto artikalDto, String menadzerUsername){
        List<Artikal> artikali = artikalRepository.findAll();

        for(Artikal artikal : artikali){
            if(artikal.getNaziv().equals(artikalDto.getNaziv()))
                return false;
        }

        Artikal a = new Artikal(artikalDto.getNaziv(), artikalDto.getCena(), artikalDto.getVrstaArtikla());

        Menadzer menadzer = menadzerRepository.findByUsername(menadzerUsername);

        artikalRepository.save(a);

        menadzer.getRestoran().getArtikli().add(a);
        restoranRepository.save(menadzer.getRestoran());

        return true;
    }

    public Artikal getArtikalByNaziv(String naziv, Long idRestorana){
        Restoran restoran = restoranRepository.getById(idRestorana);
        Set<Artikal> artikali = restoran.getArtikli();

        for(Artikal a : artikali){
            if(a.getNaziv().equals(naziv))
                return a;
        }
        return null;
    }

    public void delete(Artikal artikal){
        artikalRepository.delete(artikal);
    }
}
