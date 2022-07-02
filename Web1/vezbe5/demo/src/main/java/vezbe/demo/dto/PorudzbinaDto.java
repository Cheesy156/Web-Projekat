package vezbe.demo.dto;

import vezbe.demo.model.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PorudzbinaDto {
    private UUID uniqueID;

    private LocalDateTime datumPorudzbine;

    private List<PorudzbinaKupcaDto> porudzbinaKupca;

    public PorudzbinaDto() {
    }

    public PorudzbinaDto(UUID uniqueID, LocalDateTime datumPorudzbine) {
        this.uniqueID = uniqueID;
        this.datumPorudzbine = datumPorudzbine;
    }

    public UUID getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
    }

    public LocalDateTime getDatumPorudzbine() {
        return datumPorudzbine;
    }

    public void setDatumPorudzbine(LocalDateTime datumPorudzbine) {
        this.datumPorudzbine = datumPorudzbine;
    }

    public List<PorudzbinaKupcaDto> getPorudzbinaKupca() {
        return porudzbinaKupca;
    }

    public void setPorudzbinaKupca(List<PorudzbinaKupcaDto> porudzbinaKupca) {
        this.porudzbinaKupca = porudzbinaKupca;
    }
}
