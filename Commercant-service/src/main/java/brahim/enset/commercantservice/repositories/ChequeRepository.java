package brahim.enset.commercantservice.repositories;

import brahim.enset.commercantservice.entities.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Long> {
    Optional<Cheque> findByNumeroCheque(String numeroCheque);
}