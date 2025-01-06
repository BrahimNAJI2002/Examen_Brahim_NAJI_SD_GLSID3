package brahim.enset.banquecentraleservice.services;

import brahim.enset.agencebancaireservice.dtos.AgenceBancaireDTO;
import brahim.enset.agencebancaireservice.entities.AgenceBancaire;
import brahim.enset.agencebancaireservice.mappers.AgenceBancaireMapper;
import brahim.enset.agencebancaireservice.repositories.AgenceBancaireRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AgenceBancaireServiceImpl implements AgenceBancaireService {
    private final AgenceBancaireRepository agenceBancaireRepository;
    private final AgenceBancaireMapper agenceBancaireMapper;

    @Override
    public AgenceBancaireDTO saveAgence(AgenceBancaireDTO agenceDTO) {
        log.info("Saving new agence bancaire");
        AgenceBancaire agence = agenceBancaireMapper.toAgenceBancaire(agenceDTO);
        AgenceBancaire savedAgence = agenceBancaireRepository.save(agence);
        return agenceBancaireMapper.fromAgenceBancaire(savedAgence);
    }

    @Override
    public AgenceBancaireDTO getAgence(Long id) {
        log.info("Fetching agence with id: {}", id);
        AgenceBancaire agence = agenceBancaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence not found"));
        return agenceBancaireMapper.fromAgenceBancaire(agence);
    }

    @Override
    public List<AgenceBancaireDTO> listAgences() {
        log.info("Fetching all agences");
        List<AgenceBancaire> agences = agenceBancaireRepository.findAll();
        return agences.stream()
                .map(agenceBancaireMapper::fromAgenceBancaire)
                .collect(Collectors.toList());
    }

    @Override
    public List<AgenceBancaireDTO> getAgencesByVille(String ville) {
        log.info("Fetching agences for ville: {}", ville);
        List<AgenceBancaire> agences = agenceBancaireRepository.findByVille(ville);
        return agences.stream()
                .map(agenceBancaireMapper::fromAgenceBancaire)
                .collect(Collectors.toList());
    }
}
