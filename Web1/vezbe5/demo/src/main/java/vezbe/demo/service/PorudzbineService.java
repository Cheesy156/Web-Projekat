package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import vezbe.demo.model.*;
import vezbe.demo.repository.KupacRepository;
import vezbe.demo.repository.RestoranRepository;

import java.util.List;

public class PorudzbineService {
    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    //nalazi po statusu classic
    public Porudzbina findByStatus(Kupac kupac, Status status) {
        for(Porudzbina p : kupac.getPorudzbine()) {
            if(p.getStatus() == status) {
                return p;
            }
        }
        return new Porudzbina();
    }
    /*
    public boolean addArtikalUKorpu(Artikal artikal, Long idKupac, int kolicina, Long idRestoran){
        Kupac kupac = kupacRepository.getById(idKupac);
        if(kolicina < 1)
            return false;
        Restoran r = restoranRepository.getById(idRestoran);

        //Provera da li je poruceno iz nekog drugog restorana
        List<PoruceniArtikli> aktivnaKopa = (idKupac);
        for(Korpa k : aktivnaKopa){
            if(k.getRestoran().getId() != idRestoran)
                return false;
        }
        Korpa k = new Korpa(artikal, kolicina, kolicina*artikal.getCena(), kupac, r);
        korpaRepository.save(k);
        return true;
    }
     */
}
