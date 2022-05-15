package essienmicro.customer.Controller;


import essienmicro.customer.Model.CustomerRegistrationRequest;
import essienmicro.customer.Services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@Slf4j
@EnableAutoConfiguration
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
       System.out.println("Hello World");
    }

   @GetMapping
    public String demo(){
        return "this is weird";
    }
}
