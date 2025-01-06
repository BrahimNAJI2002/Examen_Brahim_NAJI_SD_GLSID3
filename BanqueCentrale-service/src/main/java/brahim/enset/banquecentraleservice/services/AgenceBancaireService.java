package brahim.enset.banquecentraleservice.services;


import brahim.enset.banquecentraleservice.dtos.AgenceBancaireDTO;

import java.util.List;

public interface AgenceBancaireService {
    AgenceBancaireDTO saveAgence(AgenceBancaireDTO agenceDTO);
    AgenceBancaireDTO getAgence(Long id);
    List<AgenceBancaireDTO> listAgences();
    List<AgenceBancaireDTO> getAgencesByVille(String ville);
}