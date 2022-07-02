package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.AdminDto;
import vezbe.demo.model.Dostavljac;
import vezbe.demo.repository.DostavljacRepository;

import javax.persistence.Access;
import java.util.List;

@Service
public class DostavljacService {
    @Autowired
    private DostavljacRepository dostavljacRepository;

    public boolean saveCreate(AdminDto dostavljac) {
        List<Dostavljac> dostavljaci = dostavljacRepository.findAll();

        for(Dostavljac d : dostavljaci)
            if(d.getUsername().equals(dostavljac.getUsername()))
                return false;

        Dostavljac dostavljac1 = new Dostavljac(dostavljac.getUsername(), dostavljac.getLozinka(), dostavljac.getIme(), dostavljac.getPrezime(), dostavljac.getPol(), dostavljac.getDatum_rodjenja(), dostavljac.getUloga());
        dostavljacRepository.save(dostavljac1);
        return true;
    }
}
