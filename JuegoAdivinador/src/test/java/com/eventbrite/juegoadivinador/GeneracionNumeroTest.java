/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author nicolas
 */
public class GeneracionNumeroTest {
    
    private NumeroFactory fabricaNumero;
    
    public GeneracionNumeroTest() {   
    }
        
    @Before
    public void init() {
          this.fabricaNumero=NumeroFactory.getFabricaNumeros();
    }
    
    @Test
    public void cantidadDeDigitosIgualA4(){
        
        Assert.assertEquals(4,fabricaNumero.generarNumeroAAdivinar(4).getNumero().size());
    }
    
    @Test
    public void cantidadDeDigitosIgualA8(){
       
        Assert.assertEquals(8,fabricaNumero.generarNumeroAAdivinar(8).getNumero().size());
    }
    
    @Test
    public void generaDigitosEntre0Y9(){
        
      Numero numeroGenerado=fabricaNumero.generarNumeroAAdivinar(4);  
      Assert.assertTrue(numeroGenerado.getNumero().stream()
              .allMatch(n->(Integer.parseInt(n.toString())>=0 && Integer.parseInt(n.toString())<=9)));
    }
    
    @After
    public void tearDown() {
    }
}
