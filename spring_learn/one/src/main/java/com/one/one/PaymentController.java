package com.one.one;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentapi")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    // @RequestMapping(value = "/details", method = RequestMethod.GET)
    @GetMapping(value = "/details")
    public ResponseEntity<?> getPaymentDetails() {
        return ResponseEntity.ok(paymentService.getPaymentDetails());
    }

}
