package vezbe.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Admin extends Korisnik implements Serializable {

    public Admin() {
    }
}
