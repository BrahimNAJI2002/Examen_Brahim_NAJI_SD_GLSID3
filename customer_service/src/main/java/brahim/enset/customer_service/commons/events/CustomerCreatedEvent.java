package brahim.enset.customer_service.commons.events;

import lombok.Getter;

public class CustomerCreatedEvent extends BaseEvent<String>{
    @Getter
    private String name;
    @Getter private String email;
    public CustomerCreatedEvent(String id, String name, String email) {
        super(id);
        this.name= name;
        this.email= email;
    }
}
