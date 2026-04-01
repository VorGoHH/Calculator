package com.example.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void add_ShouldReturnSum() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    void subtract_ShouldReturnDifference() {
        assertEquals(1, calculatorService.subtract(3, 2));
    }

    @Test
    void multiply_ShouldReturnProduct() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    void divide_ShouldReturnResult() {
        assertEquals(" 2", calculatorService.divide(6, 3));
    }

    @Test
    void divide_ShouldReturnError_WhenDivideByZero() {
        assertEquals("На нуль ділити не можна", calculatorService.divide(6, 0));
    }
}