package brahim.enset.commercantservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChequeDTO {
    private Long id;
    private String numeroCheque;
    private String codeBanque;
    private String numeroCompte;
    private String nomClient;
    private Double montant;
    private Boolean certifie;
}
