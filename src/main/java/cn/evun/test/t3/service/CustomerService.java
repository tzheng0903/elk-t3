package cn.evun.test.t3.service;

import cn.evun.test.t3.model.Customer;

public interface CustomerService {
    void addBatch();
    Customer getCustomer(Integer id);
}
