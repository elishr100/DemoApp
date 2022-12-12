package com.demo.demoApp.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //@Autowired
    //private RestTemplate rest;
	
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
		
		//String app2_msg = rest.getForObject("http://app2.eli-demo.com/app2", String.class);
        String app2_msg = "test";

        return message + "       \n" + app2_msg;
    }

    @GetMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
    public String index2() {
		String message = "Hello From APP1 !!! ";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

        return message;
    }
    
}
