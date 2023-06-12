package com.demo.demoApp.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.demo.demoApp.discovery.common.service.ServiceDiscoveryServiceImpl;
//import com.demo.demoApp.discovery.common.util.ServiceDiscoveryConstants;

@RestController
public class DemoController {

    @Autowired
    //private ServiceDiscoveryServiceImpl serviceDiscoveryService;
    private RestTemplate rest;
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	

	@GetMapping("/actuator/health")
	public ResponseEntity<String> healthCheck() {
	  // Perform any necessary health checks here
	  
		return ResponseEntity.ok("App1 is healthy");

	}

	@GetMapping("/app1")
	@ResponseStatus(value = HttpStatus.OK)
    public String index() {


		String message = "Hello From APP1 !!! ";
 
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	     
        
		//String app2_msg = rest.getForObject("http://app3.autosummary:8080/", String.class);
		String app2_msg = performRetryRequest();
        

        return message + ">>>>>> " +  app2_msg + " <<<<<<<";
    }

	private String performRetryRequest() {
		int maxRetries = 3;
		int retries = 0;
		String app2_msg = null;
	
		while (retries < maxRetries) {
			try {
				app2_msg = rest.getForObject("http://app3.autosummary:8080/", String.class);
				break; // If the request succeeds, exit the loop
			} catch (Exception ex) {
					retries++;
			}
		}
	
		// Check if the request was successful or handle the retries being exhausted
		if (app2_msg != null) {
			// Request succeeded, do further processing
			return app2_msg;
		} else {
			// Retries exhausted, handle the failure
			return "Failed to get response after " + maxRetries + " retries.";
		}
	}
	
    @GetMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
    public String index2() {
		String message = "Hello From root APP1 !!! ";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

        return message;
    }
    
}
