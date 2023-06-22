// package com.yash.blogapi;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class BlogApiApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(BlogApiApplication.class, args);
// 	}

// }

package com.vidit.blogapi;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vidit.blogapi.config.AppConstants;
import com.vidit.blogapi.entities.Role;
import com.vidit.blogapi.repositories.RoleRepo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Spring Boot Blog App REST API's",
		description = "Spring Boot Blog App REST API's Documentation",
		version = "v1.0",
		contact = @Contact(
			name = "Vidit Dixit",
			email = "",
			url = ""
		),
		license = @License(
			name = "Apache 2.0",
			url = ""
		)
	),

	externalDocs = @ExternalDocumentation(
		description = "Sprig Boot Blog App Rest API Documentation",
		url = ""

	)
)
public class BlogApiApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("xyz"));

		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
