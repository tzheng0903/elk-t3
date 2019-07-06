package cn.evun.test.t3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackages = "cn.evun.test.t3.dao")
public class T3Application {

    public static void main(String[] args) {
        SpringApplication.run(T3Application.class, args);
    }


    @GetMapping("/test")
    public String test(){
        return "test hello";
    }

}
