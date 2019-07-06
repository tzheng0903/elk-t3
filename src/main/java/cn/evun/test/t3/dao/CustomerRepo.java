package cn.evun.test.t3.dao;

import cn.evun.test.t3.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Integer> {
}
