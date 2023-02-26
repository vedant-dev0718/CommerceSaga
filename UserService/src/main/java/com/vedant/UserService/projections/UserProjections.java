package com.vedant.UserService.projections;

import com.vedant.CommonService.model.CardDetails;
import com.vedant.CommonService.model.User;
import com.vedant.CommonService.queries.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjections {

    @QueryHandler
    public User getUserPaymentDetails(GetUserPaymentDetailsQuery query) {

        CardDetails cardDetails =
                CardDetails.builder()
                        .name("vedant tiwari")
                        .validUntilYear(2022)
                        .validUntilMonth(01)
                        .cardNumber("123456789")
                        .cvv(111)
                        .build();

        return User.builder()
                .userId(query.getUserId())
                .firstName("vedant")
                .lastName("tiwari")
                .cardDetails(cardDetails)
                .build();
    }
}
