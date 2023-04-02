package com.demo.demoApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.demoApp.controllers.DemoController;

@SpringBootTest
class DemoApplicationTests {

	
	@Test
	void testString() {
		String message = "Hello From root APP1 !!! ";
		try {
			InetAddress ip = InetAddress.getLocalHost();
			message += " From host: " + ip;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		DemoController demoApp = new DemoController();
		assertEquals(message, demoApp.index2());

	}

}