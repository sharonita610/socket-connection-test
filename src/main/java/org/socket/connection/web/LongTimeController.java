package org.socket.connection.web;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/long")
public class LongTimeController {

	@GetMapping
	public String get() throws InterruptedException {
		Thread.sleep(5000);
		return "Ok";
	}

	@PostMapping
	public Map<String, String[]> post(HttpServletRequest request) throws InterruptedException {
		Thread.sleep(5000);
		return request.getParameterMap();
	}
}
