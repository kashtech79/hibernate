//package com.kash;
//
//import com.kash.entity.Person;
//import com.kash.jdbc.PersonJdbcDao;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.Date;
//
////@SpringBootApplication
//public class JdbcApplication implements CommandLineRunner {
//
//    private Logger logger;
//
//    {
//        logger = LoggerFactory.getLogger(this.getClass());
//    }
//
//    @Autowired
//    PersonJdbcDao dao;
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(JdbcApplication.class, args);
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        logger.info("All users -> {}",
//                dao.findAll());
//
//        logger.info("User id 10001 -> {}",
//                dao.findById(10001));
//
//        logger.info("Deleting id 10002 -> {}",
//                dao.deleteById(10002));
//
//        logger.info("Inserting 10004 -> {}",
//                dao.insert(new Person(10004, "Abdullah", "Jura", new Date())));
//
//        logger.info("Inserting 10003 -> {}",
//                dao.update(new Person(10003, "Saeed", "Karachi", new Date())));
//    }
//}


package com.kash;

import com.kash.entity.Person;
import com.kash.jdbc.PersonJdbcDao;
import com.kash.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

    private Logger logger;

    {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("User id 10001 -> {}",
                repository.findById(10001));


//    logger.info("All users -> {}",
//                dao.findAll());
//
//        logger.info("Deleting id 10002 -> {}",
//                dao.deleteById(10002));

        logger.info("Inserting 10004 -> {}",
                repository.insert(new Person( "Abdullah", "Jura", new Date())));

        logger.info("Inserting 10003 -> {}",
                repository.update(new Person(10003, "Saeed", "Karachi", new Date())));
    }
}
