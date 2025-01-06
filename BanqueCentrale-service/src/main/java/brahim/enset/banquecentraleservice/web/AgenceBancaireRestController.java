package brahim.enset.banquecentraleservice.web;

import brahim.enset.agencebancaireservice.dtos.AgenceBancaireDTO;
import brahim.enset.agencebancaireservice.services.AgenceBancaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@AllArgsConstructor
public class AgenceBancaireRestController {
    private AgenceBancaireService agenceBancaireService;

    @PostMapping
    public AgenceBancaireDTO saveAgence(@RequestBody AgenceBancaireDTO agenceDTO) {
        return agenceBancaireService.saveAgence(agenceDTO);
    }

    @GetMapping("/{id}")
    public AgenceBancaireDTO getAgence(@PathVariable Long id) {
        return agenceBancaireService.getAgence(id);
    }

    @GetMapping
    public List<AgenceBancaireDTO> listAgences() {
        return agenceBancaireService.listAgences();
    }

    @GetMapping("/ville/{ville}")
    public List<AgenceBancaireDTO> getAgencesByVille(@PathVariable String ville) {
        return agenceBancaireService.getAgencesByVille(ville);
    }
}
