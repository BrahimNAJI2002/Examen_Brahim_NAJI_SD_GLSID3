package brahim.enset.commercantservice.services;

import brahim.enset.commercantservice.dtos.CertificationRequestDTO;
import brahim.enset.commercantservice.dtos.ChequeDTO;

import java.util.List;

public interface ChequeService {
    ChequeDTO saveCheque(ChequeDTO chequeDTO);
    ChequeDTO getCheque(Long id);
    List<ChequeDTO> listCheques();
    ChequeDTO certifierCheque(CertificationRequestDTO requestDTO);
}