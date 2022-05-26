package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Lokacija;
import vezbe.demo.repository.LokacijaRepository;

@Service
public class LokacijaService {
    @Autowired
    LokacijaRepository lokacijaRepository;
    public Lokacija save(Lokacija lokacija) {
        return lokacijaRepository.save(lokacija);
    }
}
