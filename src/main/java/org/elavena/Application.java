package org.elavena;

import java.util.Arrays;

import org.elavena.domain.ObjectTest;
import org.elavena.serial.SerialTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
    
    /*@Bean
    public SerialTest serialTest(){
    	SerialTest main = new SerialTest();
		main.initialize();
		return main;
    }
    */
    @Bean
    public ObjectTest objectTest(){
    	ObjectTest singleInstance = new ObjectTest();
    	return singleInstance;
    }
}