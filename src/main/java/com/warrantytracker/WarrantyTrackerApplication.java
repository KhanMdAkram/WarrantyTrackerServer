
package com.warrantytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WarrantyTrackerApplication {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
    	SpringApplication.run(WarrantyTrackerApplication.class, args);
    	
        System.out.println(new WarrantyTrackerApplication().getGreeting());
    }
}
