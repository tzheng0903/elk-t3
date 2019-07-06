package cn.evun.test.t3.dao;

import cn.evun.test.t3.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,Integer> {
}
