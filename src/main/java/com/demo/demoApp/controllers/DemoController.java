package com.demo.demoApp.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@GetMapping("/app1")
	@ResponseStatus(value = HttpStatus.OK)
    public String index() {


		String message = "Hello From APP1 !!! ";
 
		// try {
		// 	InetAddress ip = InetAddress.getLocalHost();
		// 	message += " From host: " + ip;
		// } catch (UnknownHostException e) {
		// 	e.printStackTrace();
		// }
	     
        //String hostIp = serviceDiscoveryService.getServiceLocationResolver().resolve(ServiceDiscoveryConstants.SERVICE_B);
		String app2_msg = rest.getForObject("http://app5.autosummary:8080/app2", String.class);
        

        return message + ">>>>>> " +  app2_msg + " <<<<<<<";
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
