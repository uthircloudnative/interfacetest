package com.explore.spring.interfacetest;

import com.explore.spring.interfacetest.model.Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InterfacetestApplicationTests {

	@Test
	void contextLoads() {
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void callFirstServiceTest(){

		Response actual = testRestTemplate.getForObject("/callfirstservice",Response.class);

		Response expected = new Response("Msg from FirstServiceImpl");
		assertThat(expected).isEqualTo(actual);
	}

	@Test
	void callSecondServiceTest(){
		Response actual = testRestTemplate.getForObject("/callsecondservice",Response.class);

		Response expected = new Response("Msg from SecondServiceImpl");
		assertThat(expected.getMsg()).isEqualTo(actual.getMsg());
	}

}
