package brahim.enset.banquecentraleservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgenceBancaireDTO {
    private Long id;
    private String nom;
    private String ville;
    private String urlWebService;
}
