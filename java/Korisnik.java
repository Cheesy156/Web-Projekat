import java.time.LocalDataTime;
import java.time.format.DataTimeFormatter;

enum Uloga = {Admin,Menadzer,Dostavljac,Kupac};

public class Korisnik {

    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String pol;
    LocalDateTime datumrodjenja = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String datum_formatirano = datumrodjenja.format(format);
    private Uloga uloga;


}
