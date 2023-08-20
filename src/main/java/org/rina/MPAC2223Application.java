package org.rina;

import org.rina.service.AuthenticationService;
import org.rina.dto.request.RegisterRequest;
import org.rina.model.User;
import org.rina.dao.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Optional;

import static org.rina.enums.Role.*;

@SpringBootApplication
public class MPAC2223Application {

	public static void main(String[] args) {
		SpringApplication.run(MPAC2223Application.class, args);
	}


	@Bean
	public CommandLineRunner initTestDatabase(AuthenticationService authService,
											  UserRepository userRepository) {

		return args -> {
			//Auth Data
			Optional<User> user = userRepository.findByUsername("user");
			if(user.isEmpty()){
				var admin = RegisterRequest.builder().username("user").password("password").role(ADMIN).build();
				authService.register(admin).getAccessToken();
			}
		};
	}

}
