package brahim.enset.commercantservice.mappers;

import brahim.enset.commercantservice.dtos.ChequeDTO;
import brahim.enset.commercantservice.entities.Cheque;
import org.springframework.stereotype.Component;

@Component
public class ChequeMapper {
    public ChequeDTO fromCheque(Cheque cheque) {
        return ChequeDTO.builder()
                .id(cheque.getId())
                .numeroCheque(cheque.getNumeroCheque())
                .codeBanque(cheque.getCodeBanque())
                .numeroCompte(cheque.getNumeroCompte())
                .nomClient(cheque.getNomClient())
                .montant(cheque.getMontant())
                .certifie(cheque.getCertifie())
                .build();
    }

    public Cheque toCheque(ChequeDTO chequeDTO) {
        return Cheque.builder()
                .id(chequeDTO.getId())
                .numeroCheque(chequeDTO.getNumeroCheque())
                .codeBanque(chequeDTO.getCodeBanque())
                .numeroCompte(chequeDTO.getNumeroCompte())
                .nomClient(chequeDTO.getNomClient())
                .montant(chequeDTO.getMontant())
                .certifie(chequeDTO.getCertifie())
                .build();
    }
}