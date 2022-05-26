package vezbe.demo.service;

import vezbe.demo.model.Kupac;
import vezbe.demo.model.Porudzbina;
import vezbe.demo.model.Status;

public class PorudzbineService {
    //nalazi po statusu classic
    public Porudzbina findByStatus(Kupac kupac, Status status) {
        for(Porudzbina p : kupac.getPorudzbine()) {
            if(p.getStatus() == status) {
                return p;
            }
        }
        return new Porudzbina();
    }
}
