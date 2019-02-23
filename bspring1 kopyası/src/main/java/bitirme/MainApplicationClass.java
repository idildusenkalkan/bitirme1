package bitirme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MainApplicationClass {

    public static void main (String[] args){
        SpringApplication.run(MainApplicationClass.class, args);
    }
}
