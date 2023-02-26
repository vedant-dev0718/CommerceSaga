package com.vedant.UserService.controller;

import com.vedant.CommonService.model.User;
import com.vedant.CommonService.queries.GetUserPaymentDetailsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    public UserController() {
    }

    private transient QueryGateway queryGateway;

    @GetMapping("{userId}")
    public User getUserPaymentDetails(@PathVariable String userId){
        GetUserPaymentDetailsQuery getUserPaymentDetailsQuery
                = new GetUserPaymentDetailsQuery(userId);

        return queryGateway.query(getUserPaymentDetailsQuery,
                ResponseTypes.instanceOf(User.class)).join();
    }

}
