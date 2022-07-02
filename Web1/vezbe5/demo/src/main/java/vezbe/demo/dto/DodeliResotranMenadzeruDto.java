package vezbe.demo.dto;

public class DodeliResotranMenadzeruDto {
    private Long idRestorana;

    private Long idMenadzera;

    public DodeliResotranMenadzeruDto(Long idRestorana, Long idMenadzera) {
        this.idRestorana = idRestorana;
        this.idMenadzera = idMenadzera;
    }

    public DodeliResotranMenadzeruDto() {
    }

    public Long getIdRestorana() {
        return idRestorana;
    }

    public void setIdRestorana(Long idRestorana) {
        this.idRestorana = idRestorana;
    }

    public Long getIdMenadzera() {
        return idMenadzera;
    }

    public void setIdMenadzera(Long idMenadzera) {
        this.idMenadzera = idMenadzera;
    }
}

