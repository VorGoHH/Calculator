package com.example.calculator.controler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url(String endpoint) {
        return "http://localhost:" + port + "/calc" + endpoint;
    }

    @Test
    void add_ShouldReturn5() {
        Integer result = restTemplate.getForObject(url("/add?a=2&b=3"), Integer.class);
        assertEquals(5, result);
    }

    @Test
    void subtract_ShouldReturn1() {
        Integer result = restTemplate.getForObject(url("/subtract?a=3&b=2"), Integer.class);
        assertEquals(1, result);
    }

    @Test
    void multiply_ShouldReturn6() {
        Integer result = restTemplate.getForObject(url("/multiply?a=2&b=3"), Integer.class);
        assertEquals(6, result);
    }

    @Test
    void divide_ShouldReturnResult() {
        String result = restTemplate.getForObject(url("/divide?a=6&b=3"), String.class);
        assertEquals(" 2", result);
    }

    @Test
    void divide_ShouldReturnError_WhenDivideByZero() {
        String result = restTemplate.getForObject(url("/divide?a=6&b=0"), String.class);
        assertEquals("На нуль ділити не можна", result);
    }
}