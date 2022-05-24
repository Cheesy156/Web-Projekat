package vezbe.demo.dto;

import vezbe.demo.model.Admin;

public class AdminDto {
    private Long id;

    private String ime;

    private String prezime;

    public AdminDto() {
    }

    public AdminDto(Long id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public AdminDto(Admin admin) {
        this.id = admin.getId();
        this.ime = admin.getIme();
        this.prezime = admin.getPrezime();
    }
}
