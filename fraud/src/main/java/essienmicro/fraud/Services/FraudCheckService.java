package essienmicro.fraud.Services;


import essienmicro.fraud.Dao.FraudCheckHistoryRepository;
import essienmicro.fraud.Model.FraudCheckHistory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    @Autowired
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        //TODO you could use a 3rd party system to check if
        // customer is a fraudster or not by checking their emails, Phone number etc
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return false;
    }

}
