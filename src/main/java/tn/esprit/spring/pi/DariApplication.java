package tn.esprit.spring.pi;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.spring.pi.controller.FileUploadController;

@SpringBootApplication
public class DariApplication {

	public static void main(String[] args) throws Exception {
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(DariApplication.class, args);

	}
}