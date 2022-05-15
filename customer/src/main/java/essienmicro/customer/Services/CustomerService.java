package essienmicro.customer.Services;


import essienmicro.customer.Dao.CustomerRepository;
import essienmicro.customer.Model.Customer;
import essienmicro.customer.Model.CustomerRegistrationRequest;
import essienmicro.customer.Model.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: 5/11/2022 check if email is valid

        // TODO: 5/11/2022 check if email is not taken

        // TODO: 5/11/2022 store customer in db. Use SaveAndFlush to preserve data integrity
        customerRepository.saveAndFlush(customer);

        //TODO check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8083/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Customer is a fraudster");
        }



        //TODO: Send notification

    }
}
