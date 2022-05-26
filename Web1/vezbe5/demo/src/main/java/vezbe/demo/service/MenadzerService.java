package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Menadzer;
import vezbe.demo.repository.MenadzerRepository;

@Service
public class MenadzerService {
    @Autowired
    MenadzerRepository menadzerRepository;

    public Menadzer findByUsername(String username) {
        return menadzerRepository.findByUsername(username);
    }
    public Menadzer save(Menadzer menadzer) {
        return menadzerRepository.save(menadzer);
    }
}
