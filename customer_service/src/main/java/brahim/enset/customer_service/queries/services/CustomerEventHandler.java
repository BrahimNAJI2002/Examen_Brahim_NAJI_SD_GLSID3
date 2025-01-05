package brahim.enset.customer_service.queries.services;

import brahim.enset.customer_service.commons.events.CustomerCreatedEvent;
import brahim.enset.customer_service.queries.entities.Customer;
import brahim.enset.customer_service.queries.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandler {
    private CustomerRepository customerRepository;
    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("************************");
        log.info("CustomerCreatedEvent received");
        Customer customer=new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customerRepository.save(customer);
    }

}