package com.one.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    MyUser myUser;

    String getPaymentDetails() {
        myUser.setFirstName("Jane");
        return "Payment details";
    }
}
