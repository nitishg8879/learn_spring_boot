package com.one.one;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentapi")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @InitBinder
    protected void initBinder(DataBinder binder) {
        binder.registerCustomEditor(String.class, "firstName", new FirstNamePropertyEditor());
    }

    // @RequestMapping(value = "/details", method = RequestMethod.GET)
    @GetMapping(value = "/details")
    public ResponseEntity<?> getPaymentDetails() {
        return ResponseEntity.ok(paymentService.getPaymentDetails());
    }

    @GetMapping("/fetchUsers")
    public String fetchUsers(@RequestParam(value = "firstName", required = true) String firstNameX,
            @RequestParam(value = "lastName", required = false) String lastNameX) {
        return "Hello " + firstNameX + " " + lastNameX;
    }


    @GetMapping("/user/{id}")
    public String userById(@PathVariable String id) {
        return "User id is " + id;
    }
    

}


class FirstNamePropertyEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.trim().toLowerCase());
    }
}
