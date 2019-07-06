package cn.evun.test.t3;

import cn.evun.test.t3.model.Product;
import cn.evun.test.t3.service.CustomerService;
import cn.evun.test.t3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product product(@PathVariable("id")Integer id){
        return productService.getProduct(id);
    }
}
