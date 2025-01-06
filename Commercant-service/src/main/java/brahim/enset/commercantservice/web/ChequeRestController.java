package brahim.enset.commercantservice.web;

import brahim.enset.commercantservice.dtos.CertificationRequestDTO;
import brahim.enset.commercantservice.dtos.ChequeDTO;
import brahim.enset.commercantservice.services.ChequeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cheques")
@AllArgsConstructor
public class ChequeRestController {
    private ChequeService chequeService;

    @PostMapping
    public ChequeDTO saveCheque(@RequestBody ChequeDTO chequeDTO) {
        return chequeService.saveCheque(chequeDTO);
    }

    @GetMapping("/{id}")
    public ChequeDTO getCheque(@PathVariable Long id) {
        return chequeService.getCheque(id);
    }

    @GetMapping
    public List<ChequeDTO> listCheques() {
        return chequeService.listCheques();
    }

    @PostMapping("/certifier")
    public ChequeDTO certifierCheque(@RequestBody CertificationRequestDTO requestDTO) {
        return chequeService.certifierCheque(requestDTO);
    }
}