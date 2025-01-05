package brahim.enset.customer_service.queries.services;

import brahim.enset.customer_service.commons.dtos.GetAllCustomersQueryDTO;
import brahim.enset.customer_service.commons.dtos.GetCustomerByIdQueryDTO;
import brahim.enset.customer_service.queries.entities.Customer;
import brahim.enset.customer_service.queries.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {
    public CustomerRepository customerRepository;

    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQueryDTO query){
        return customerRepository.findAll();
    }
    @QueryHandler
    public Customer customerList(GetCustomerByIdQueryDTO query){
        return customerRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Customer not fount"));
    }
}