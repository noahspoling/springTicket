package com.noahspoling.springTicket;

import com.noahspoling.springTicket.lib.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTicketApplication.class, args);
	}
}
