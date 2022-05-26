package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Artikal;
import vezbe.demo.repository.ArtikalRepository;

@Service
public class ArtikalService {
    @Autowired
    private ArtikalRepository artikalRepository;

    public void save(Artikal artikal) {
        artikalRepository.save(artikal);
    }

    public void delete(Artikal artikal){
        artikalRepository.delete(artikal);
    }
}
