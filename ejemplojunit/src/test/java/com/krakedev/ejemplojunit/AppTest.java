package com.krakedev.ejemplojunit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void testSumar() {
    	Calculadora c=new Calculadora();
    	int resultado = c.suma(5, 10);
    	assertTrue(resultado==15);
    }
    
    @Test
    public void testRestar() {
    	Calculadora c=new Calculadora();
    	int resultado = c.restar(25, 5);
    	assertTrue(resultado==20);
    }

}
