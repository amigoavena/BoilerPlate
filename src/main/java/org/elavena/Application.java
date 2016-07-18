package org.elavena;

import java.util.Arrays;

import org.elavena.domain.ObjectTest;
import org.elavena.serial.SerialTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class Application {
	
	private static final Logger LOG = LogManager.getFormatterLogger(Application.class); 

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        LOG.debug("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	LOG.debug(beanName);
        }
    }
    
    public SerialTest serialTest(){
    	SerialTest main = new SerialTest();
		main.initialize();
		return main;
    }
    
    @Bean
    public ObjectTest objectTest(){
    	ObjectTest singleInstance = new ObjectTest();
    	return singleInstance;
    }
}