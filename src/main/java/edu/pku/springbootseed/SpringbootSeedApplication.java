package edu.pku.springbootseed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceTransactionManagerAutoConfiguration.class,
        DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@MapperScan(value = {"edu.pku.springbootseed.**.dao*"})
public class SpringbootSeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSeedApplication.class, args);
    }

}
