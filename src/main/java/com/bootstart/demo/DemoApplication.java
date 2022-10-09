package com.bootstart.demo;

import com.bootstart.demo.controllers.HomeController;
import com.bootstart.demo.model.User;
import com.bootstart.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import javax.transaction.Transactional;
import java.io.File;

@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) throws NullPointerException{
		System.out.println("Web Start");
		System.out.println(HomeController.dir);
		new File(HomeController.dir).mkdirs();
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		UserRepository userRepo = context.getBean(UserRepository.class);
//		User user = new User();
//		user.setName("robin");
//		user.setEmail("email@gmial.com");
//		user.setAge(22);
//		user.setPassword("12345679");

		//userRepo.findById(1);
		//User user = userRepo.findByEmail("email@gmail.com");
//		System.out.println(userRepo.findById(1));
	}
}
