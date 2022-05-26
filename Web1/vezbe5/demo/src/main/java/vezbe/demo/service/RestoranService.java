package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Restoran;
import vezbe.demo.model.Uloga;
import vezbe.demo.repository.RestoranRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestoranService {
    @Autowired
    private RestoranRepository restoranRepository;

    public Restoran save(Restoran restoran) {return restoranRepository.save(restoran); }

    public ResponseEntity<List<RestoranDto>> getRestorani() {
        List<Restoran> restorani = restoranRepository.findAll();
        List<RestoranDto> restoranDtos = new ArrayList<>();

        for(Restoran restoran : restorani) {
            restoranDtos.add(new RestoranDto(restoran.getNaziv(), restoran.getTipRestorana(), restoran.getLokacija()));
        }

        return ResponseEntity.ok(restoranDtos);
    }
}
