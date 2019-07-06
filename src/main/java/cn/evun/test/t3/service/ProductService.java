package cn.evun.test.t3.service;

import cn.evun.test.t3.model.Product;

public interface ProductService {
    void addBatch();
    Product getProduct(Integer id);
}
