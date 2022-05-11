package essienmicro.customer.Services;


import essienmicro.customer.Model.Customer;
import essienmicro.customer.Model.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: 5/11/2022 check if email is valid
        // TODO: 5/11/2022 check if email is not taken
        // TODO: 5/11/2022 store customer in db

    }
}
