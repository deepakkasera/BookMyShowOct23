package com.scaler.bookmyshowoct23;

import com.scaler.bookmyshowoct23.models.BaseModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowOct23Application {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowOct23Application.class, args);
    }

}
