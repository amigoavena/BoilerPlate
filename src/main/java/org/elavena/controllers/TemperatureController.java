package org.elavena.controllers;

import org.elavena.domain.ObjectTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {
	
   /* @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
        
    }*/
    
    @Autowired
    private ObjectTest storeObject;
    
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/getTemp")
    public ObjectTest getTemperature(){
    	return storeObject;
    }

}