package cn.evun.test.t3.service.impl;

import cn.evun.test.t3.dao.ProductRepo;
import cn.evun.test.t3.model.Customer;
import cn.evun.test.t3.model.Product;
import cn.evun.test.t3.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProductServiceImpl implements ProductService {

    public static final Log logger = LogFactory.getLog(ProductServiceImpl.class);

    public static final List<String> brands = new ArrayList();
    public static final List<Double> prices = new ArrayList();

    @Override
    public Product getProduct(Integer id) {
        Product product = productRepo.findById(id).get();
        logger.info(String.format("查询id为%d的产品信息。。。。。。。。。。。",id));
        return product;
    }

    static {
        brands.add("audi");
        brands.add("beyond");
        brands.add("geely");
        brands.add("baoma");
        brands.add("basj");
        brands.add("benze");
        brands.add("benli");
        prices.add(100001d);
        prices.add(100002d);
        prices.add(100003d);
        prices.add(100004d);
        prices.add(100005d);
        prices.add(100006d);
        prices.add(100007d);
    }

    @Autowired
    private ProductRepo productRepo;
    @Override
    public void addBatch() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for(int i = 0;i<20;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i<10000;i++){
                        Product product = new Product();
                        long time = System.currentTimeMillis();
                        int index = (int)(time%7);
                        product.setBrand(brands.get(index));
                        product.setName(brands.get(index)+"name"+time);
                        product.setPrice(prices.get(index));
                        productRepo.save(product);
                    }
                }
            });
        }
    }
}
