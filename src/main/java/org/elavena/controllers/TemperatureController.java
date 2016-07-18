package org.elavena.controllers;

import java.io.IOException;

import org.elavena.domain.ObjectTest;
import org.elavena.serial.SerialTest;
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
    
    private SerialTest serialTest;
    
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    
    @RequestMapping("/getTemp")
    public ObjectTest getTemperature(){
    	try {
			serialTest.getOutput().write("1|".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    @RequestMapping("/lightLed")
    public ObjectTest getColorId(@RequestParam Integer color){
    	try {
			serialTest.getOutput().write(new String(color+"|").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }

}