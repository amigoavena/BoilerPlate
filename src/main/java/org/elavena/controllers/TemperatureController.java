package org.elavena.controllers;

import java.io.IOException;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elavena.domain.IOTObject;
import org.elavena.domain.ObjectTest;
import org.elavena.serial.SerialTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TemperatureController {

	private static final Logger log = LogManager.getLogger(TemperatureController.class);

	/*
	 * @RequestMapping("/") public String index() { return
	 * "Greetings from Spring Boot!";
	 * 
	 * }
	 */

	private SerialTest serialTest;

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/getTemp")
	public ObjectTest getTemperature() {
		try {
			serialTest.getOutput().write("1|".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/lightChange")
	public IOTObject changeStatus(@RequestParam Boolean turnOn) {
		RestTemplate restTemplate = new RestTemplate();
		String requestURL = "http://192.168.0.17/";
		if(turnOn){
			requestURL = requestURL+"?pin=ON";
		} else {
			requestURL = requestURL+"?pin=OFF";
		}
		IOTObject led = restTemplate.getForObject(requestURL, IOTObject.class);
		log.info(ReflectionToStringBuilder.toString(led.toString()));
		return led;
	}
	
	@RequestMapping("/lightStatus")
	public IOTObject getStatus() {
		RestTemplate restTemplate = new RestTemplate();
		IOTObject led = restTemplate.getForObject("http://192.168.0.17/", IOTObject.class);
		log.info(ReflectionToStringBuilder.toString(led.toString()));
		return led;
	}

}