package brahim.enset.customer_service.queries.repositories;

import brahim.enset.customer_service.queries.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}