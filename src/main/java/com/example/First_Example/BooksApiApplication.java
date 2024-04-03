package com.example.First_Example;


import lombok.extern.java.Log;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class BooksApiApplication implements CommandLineRunner {

    //    private final ColourPrinter colourPrinter;
//    private final PizzaConfig pizzaConfig;
    private final DataSource dataSource;

    public BooksApiApplication(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(BooksApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
 
    }
}
