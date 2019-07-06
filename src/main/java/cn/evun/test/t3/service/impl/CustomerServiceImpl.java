package cn.evun.test.t3.service.impl;

import cn.evun.test.t3.dao.CustomerRepo;
import cn.evun.test.t3.model.Customer;
import cn.evun.test.t3.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CustomerServiceImpl implements CustomerService {
    public static final Log logger = LogFactory.getLog(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void addBatch() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for(int i = 0;i<20;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i<10000;i++){
                        Customer customer = new Customer();
                        customer.setAddress("xiamen");
                        customer.setAge(11);
                        customer.setIdentity_no("23001123" + System.currentTimeMillis());
                        customer.setName("tzheng" + i);
                        customerRepo.save(customer);
                    }
                }
            });
        }

    }

    @Override
    public Customer getCustomer(Integer id) {
        Customer customer = customerRepo.findById(id).get();
        logger.info(String.format("查询id为%d的客户信息。。。。。。。。。。。",id));
        return customer;
    }
}
