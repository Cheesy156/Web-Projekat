package vezbe.demo.model;

public class Komentar {
    private Kupac kupac;
    private Restoran restoran;
    private String tekst;
    private int ocena; // od 1 do 5
    private Porudzbina porudzbina;

    public Komentar(Kupac kupac, Restoran restoran, String tekst, int ocena, Porudzbina porudzbina) {
        this.kupac = kupac;
        this.restoran = restoran;
        this.tekst = tekst;
        this.ocena = ocena;
        this.porudzbina = porudzbina;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public String getTekst() {
        return tekst;
    }

    public int getOcena() {
        return ocena;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }
}
