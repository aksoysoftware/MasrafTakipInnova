package com.innova.masraftakip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MasrafTakipInnovaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasrafTakipInnovaApplication.class, args);
    }
}
