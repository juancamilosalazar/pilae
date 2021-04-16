package com.example.multimodule;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.multimodule.repository.service.MyService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EquipoControladorTest {

	@Autowired
	private MyService myService;

	@Test
	public void contextLoads() {
		assertThat(myService.message()).isNotNull();
	}

}
