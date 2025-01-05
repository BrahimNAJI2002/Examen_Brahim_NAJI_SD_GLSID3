package brahim.enset.customer_service.commands.commands;

import lombok.Getter;

public class CreateCustomerCommand extends BaseCommand<String>{
    @Getter private String  name;
    @Getter private String email;
    public CreateCustomerCommand(String id, String name, String email) {
        super(id);
        this.name= name;
        this.email= email;
    }
}
