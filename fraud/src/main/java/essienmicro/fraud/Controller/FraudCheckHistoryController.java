package essienmicro.fraud.Controller;


import essienmicro.fraud.Model.FraudCheckResponse;
import essienmicro.fraud.Services.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud-check")
@AllArgsConstructor
@Slf4j
@EnableAutoConfiguration
public class FraudCheckHistoryController {

    @Autowired
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.
                isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

    @GetMapping
    public String demo(){
        return "this is a Fraudster";
    }


}
