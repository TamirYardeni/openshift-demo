package com.yardeni.coffeeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@SpringBootApplication
public class CoffeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeServiceApplication.class, args);
	}

}

@RestController
@RequestMapping("/coffees")
class CoffeeController {
	private final CoffeeService service;

	CoffeeController(CoffeeService service) {
		this.service = service;
	}

	@GetMapping
	public ArrayList<Coffee> all() {
		return service.getAllCoffees();
	}
}

@Service
class CoffeeService {
	public CoffeeService() {

	}

	ArrayList<Coffee> getAllCoffees() {
		ArrayList<Coffee> coffees = new ArrayList<>();
		coffees.add(new Coffee("1","yum"));
		return coffees;
	}
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Coffee {
	private String id;
	private String name;
}
