package brahim.enset.banquecentraleservice.repositories;

import brahim.enset.agencebancaireservice.entities.AgenceBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenceBancaireRepository extends JpaRepository<AgenceBancaire, Long> {
    List<AgenceBancaire> findByVille(String ville);
    Optional<AgenceBancaire> findByNom(String nom);
}
