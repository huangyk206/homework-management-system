package scau.huangyk.homeworkmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("scau.huangyk.homeworkmanagementsystem.mapper*")
public class HomeworkManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkManagementSystemApplication.class, args);
    }


}

