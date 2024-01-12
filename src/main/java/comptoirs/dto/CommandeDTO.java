package comptoirs.dto;

import java.util.List;

import lombok.Data;

@Data // Lombok, getters... https://projectlombok.org/features/Data
public class CommandeDTO {
    private Integer numero;
    private ClientDTO client;
    private List<LigneDTO> lignes;
}
