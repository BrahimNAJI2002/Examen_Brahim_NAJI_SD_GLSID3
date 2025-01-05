package brahim.enset.customer_service.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CustomerRequestDTO {
    private String name;
    private String email;
}
