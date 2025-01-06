package brahim.enset.commercantservice.services;

import brahim.enset.commercantservice.dtos.ChequeDTO;
import brahim.enset.commercantservice.dtos.CertificationRequestDTO;
import brahim.enset.commercantservice.entities.Cheque;
import brahim.enset.commercantservice.mappers.ChequeMapper;
import brahim.enset.commercantservice.repositories.ChequeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ChequeServiceImpl implements ChequeService {
    private final ChequeRepository chequeRepository;
    private final ChequeMapper chequeMapper;

    @Override
    public ChequeDTO saveCheque(ChequeDTO chequeDTO) {
        log.info("Saving new cheque");
        Cheque cheque = chequeMapper.toCheque(chequeDTO);
        cheque.setCertifie(false);
        Cheque savedCheque = chequeRepository.save(cheque);
        return chequeMapper.fromCheque(savedCheque);
    }

    @Override
    public ChequeDTO getCheque(Long id) {
        log.info("Fetching cheque with id: {}", id);
        Cheque cheque = chequeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cheque not found"));
        return chequeMapper.fromCheque(cheque);
    }

    @Override
    public List<ChequeDTO> listCheques() {
        log.info("Fetching all cheques");
        List<Cheque> cheques = chequeRepository.findAll();
        return cheques.stream()
                .map(chequeMapper::fromCheque)
                .collect(Collectors.toList());
    }

    @Override
    public ChequeDTO certifierCheque(CertificationRequestDTO requestDTO) {
        log.info("Certifying cheque: {}", requestDTO.getNumeroCheque());

        Cheque cheque = chequeRepository.findByNumeroCheque(requestDTO.getNumeroCheque())
                .orElseThrow(() -> new RuntimeException("Cheque not found"));

        if (cheque.getCertifie()) {
            throw new RuntimeException("Cheque already certified");
        }

        if (!cheque.getCodeBanque().equals(requestDTO.getCodeBanque()) ||
                !cheque.getNumeroCompte().equals(requestDTO.getNumeroCompte()) ||
                !cheque.getMontant().equals(requestDTO.getMontant())) {
            throw new RuntimeException("Cheque information mismatch");
        }

        cheque.setCertifie(true);
        Cheque updatedCheque = chequeRepository.save(cheque);

        return chequeMapper.fromCheque(updatedCheque);
    }
}