package brahim.enset.banquecentraleservice.mappers;

import brahim.enset.agencebancaireservice.dtos.AgenceBancaireDTO;
import brahim.enset.agencebancaireservice.entities.AgenceBancaire;
import org.springframework.stereotype.Component;

@Component
public class AgenceBancaireMapper {
    public AgenceBancaireDTO fromAgenceBancaire(AgenceBancaire agence) {
        return AgenceBancaireDTO.builder()
                .id(agence.getId())
                .nom(agence.getNom())
                .ville(agence.getVille())
                .urlWebService(agence.getUrlWebService())
                .build();
    }

    public AgenceBancaire toAgenceBancaire(AgenceBancaireDTO agenceDTO) {
        return AgenceBancaire.builder()
                .id(agenceDTO.getId())
                .nom(agenceDTO.getNom())
                .ville(agenceDTO.getVille())
                .urlWebService(agenceDTO.getUrlWebService())
                .build();
    }
}