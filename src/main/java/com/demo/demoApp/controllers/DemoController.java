package com.demo.demoApp.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.SRVRecord;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

@RestController
public class DemoController {

    @Autowired
    private RestTemplate rest;
	
	@GetMapping("/app1")
	@ResponseStatus(value = HttpStatus.OK)
    public String index() {
		String message = "Hello From APP1 !!! ";
        String hostname="";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
        try {
            Record[] records = new Lookup("app2.autoSummary", Type.SRV).run();

            for (Record record : records) {
                 SRVRecord srv = (SRVRecord) record;

            String target = srv.getTarget().toString().replaceFirst("\\.$", "");
            int port = srv.getPort();

            hostname = target + ":" + port;
            System.out.println(hostname);
          }
          } catch (TextParseException e) {
             e.printStackTrace();
          }

		String app2_msg = rest.getForObject("http://" + hostname + "/app2", String.class);
        //String app2_msg = "test";

        return message + "                                             " + app2_msg;
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
