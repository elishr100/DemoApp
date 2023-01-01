package com.demo.demoApp.controllers;

import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.servicediscovery.AWSServiceDiscovery;
import com.amazonaws.services.servicediscovery.AWSServiceDiscoveryClientBuilder;
import com.amazonaws.services.servicediscovery.model.DiscoverInstancesRequest;
import com.amazonaws.services.servicediscovery.model.DiscoverInstancesResult;

@RestController
public class DemoController {

    //@Autowired
    //private RestTemplate rest;
	
	@GetMapping("/app1")
	@ResponseStatus(value = HttpStatus.OK)
    public String index() throws URISyntaxException {
		String message = "Hello From APP1 !!! ";

		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	

        AWSServiceDiscovery client = AWSServiceDiscoveryClientBuilder
            .standard()
            .withRegion(System.getenv("us-east-1"))
            .withCredentials(null)
            .build();
        

        // DiscoverInstancesRequest request = new DiscoverInstancesRequest();
        // request.setNamespaceName("autoSummary");
        // request.setServiceName("app3");
        
        // DiscoverInstancesResult result=client.discoverInstances(request);
        
        //hostname = "http://566fa43a634c427aa3ad1998c4646028.app2.autosummary:49155/app2";  
		//String app2_msg = rest.getForObject(uri, String.class);
        

        return message + "                                             >>>>     ";
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
