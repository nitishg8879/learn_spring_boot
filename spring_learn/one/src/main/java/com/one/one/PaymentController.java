package com.one.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/paymentapi")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getPaymentDetails() {
        return paymentService.getDetails();
    }

}
