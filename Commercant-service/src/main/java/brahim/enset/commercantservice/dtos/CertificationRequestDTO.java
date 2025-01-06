package brahim.enset.commercantservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificationRequestDTO {
    private String numeroCheque;
    private String codeBanque;
    private String numeroCompte;
    private Double montant;
}