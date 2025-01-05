package brahim.enset.customer_service.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetCustomerByIdQueryDTO {
    private  String id;
}
