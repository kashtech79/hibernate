package com.kash;

import com.kash.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

    private Logger logger;

    {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Autowired
    PersonJdbcDao dao;


    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 10001 -> {}", dao.findById(10001));
        logger.info("Deleting id 10002 -> {}", dao.deleteById(10002));
    }
}
