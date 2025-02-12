package com.example.patientmange;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.patientmange.mapper")//扫描mapper包
public class PatientMangeApplication {
	public static void main(String[] args) {
		SpringApplication.run(PatientMangeApplication.class, args);
	}
}
