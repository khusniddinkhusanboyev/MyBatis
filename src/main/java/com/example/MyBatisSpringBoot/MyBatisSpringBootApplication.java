package com.example.MyBatisSpringBoot;


import com.example.MyBatisSpringBoot.model.Employee;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MappedTypes(Employee.class)
@MapperScan("com.example.MyBatisSpringBoot.mapper")
@SpringBootApplication
public class MyBatisSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisSpringBootApplication.class, args);

	}

}
