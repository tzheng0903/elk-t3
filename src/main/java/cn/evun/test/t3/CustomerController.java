package cn.evun.test.t3;

import cn.evun.test.t3.model.Customer;
import cn.evun.test.t3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer customer(@PathVariable("id")Integer id){
        return customerService.getCustomer(id);
    }
}
