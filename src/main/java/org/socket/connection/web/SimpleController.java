package org.socket.connection.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/simple")
public class SimpleController {

	private final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);

	@GetMapping
	public String get() {
		return "ok";
	}

	@PostMapping
	public Map<String, String[]> post(HttpServletRequest request) {
		LOGGER.info("this post");
		return request.getParameterMap();
	}

	@PutMapping
	public Map<String, String[]> put(HttpServletRequest request) {
		LOGGER.info("this put");
		return request.getParameterMap();
	}

	@DeleteMapping
	public Map<String, String[]> delete(HttpServletRequest request) {
		LOGGER.info("this delete");
		return request.getParameterMap();
	}

	@PostMapping(path = "/empty")
	public ResponseEntity<Void> emptyPost() {
		getEmptyPost();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private void getEmptyPost() {
		LOGGER.info("this emptyPost");
	}

	@GetMapping(path = "/400")
	public ResponseEntity<String> get400() {
		getEmptyPost();
		return new ResponseEntity<>("400", HttpStatus.BAD_REQUEST);
	}
}
