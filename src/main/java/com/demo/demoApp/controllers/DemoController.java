package com.demo.demoApp.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    private RestTemplate rest;
	
	@GetMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
    public String index() {
		String message = "Hello From APP1 !!! ";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		String app2_msg = rest.getForObject("http://app2.eli-demo.com/app2", String.class);

        return message + "       \n" + app2_msg;
    }
    
}