package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2  //启动swagger注解
@MapperScan(basePackages = {"com.example.demo02.dao"})  // 可以扫描多个包，不必再用@mapper注解
public class Application {

	public static void main(String[] args) {
//		System.out.println(HelloController.class.getResource(""));
//		System.out.println(HelloController.class.getResource("/"));
//		System.out.println(HelloController.class.getClassLoader().getResource(""));
//		System.out.println(HelloController.class.getClassLoader().getResource("/"));
//		System.out.println("test");
		SpringApplication.run(Application.class, args);
	}
}
