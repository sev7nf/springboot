package com.example.demo02;

import com.example.demo02.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02ApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(HelloController.class.getResource(""));
		System.out.println(HelloController.class.getResource("/"));
		System.out.println(HelloController.class.getClassLoader().getResource(""));
		System.out.println(HelloController.class.getClassLoader().getResource("/"));
	}

}
