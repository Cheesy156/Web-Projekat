package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.AdminDto;
import vezbe.demo.dto.MenadzerDto;
import vezbe.demo.model.Menadzer;
import vezbe.demo.model.Restoran;
import vezbe.demo.repository.MenadzerRepository;
import vezbe.demo.repository.RestoranRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MenadzerService {
    @Autowired
    MenadzerRepository menadzerRepository;

    @Autowired
    RestoranRepository restoranRepository;

    public Menadzer findByUsername(String username) {
        return menadzerRepository.findByUsername(username);
    }
    public Menadzer save(Menadzer menadzer) {
        return menadzerRepository.save(menadzer);
    }

    public Boolean saveCrate(AdminDto menadzer) {
        List<Menadzer> menadzeri = menadzerRepository.findAll();

        for(Menadzer m : menadzeri)
            if(m.getUsername().equals(menadzer.getUsername()))
                return false;

        Menadzer menadzer1 = new Menadzer(menadzer.getUsername(), menadzer.getLozinka(), menadzer.getIme(), menadzer.getPrezime(), menadzer.getPol(), menadzer.getDatum_rodjenja(), menadzer.getUloga());
        menadzerRepository.save(menadzer1);
        return true;
    }

    public Boolean dodeliMuRestoranViseee(Long restoranId, Long menadzerId) {
        List<Menadzer> menadzeri = menadzerRepository.findAll();
        List<Restoran> restorani = restoranRepository.findAll();

        for(Menadzer m : menadzeri)
            if (m.getId().equals(menadzerId)) {
                if (m.getRestoran().getId() != null)
                    return false;

                for (Restoran r : restorani)
                    if (r.getId().equals(restoranId)) {
                        if (r.getMenadzer() != null)
                            return false;

                        m.setRestoran(r);
                        menadzerRepository.save(m);
                        return true;
                    }
            }

        return false;
    }
}
