/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

import com.eventbrite.juegoadivinador.numero.NumeroFactory;
import com.eventbrite.juegoadivinador.numero.Numero;
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
    public void cantidadDeDigitosIgualA4ConGeneracionAleatoria(){
        
        Assert.assertEquals(4,fabricaNumero.generarNumeroAAdivinar(4).getNumero().size());
    }
    
    @Test
    public void cantidadDeDigitosIgualA8ConGeneracionAleatoria(){
       
        Assert.assertEquals(8,fabricaNumero.generarNumeroAAdivinar(8).getNumero().size());
    }
    
    @Test
    public void cantidadDeDigitosIgualA4ConStringIngresado(){
        
        Assert.assertEquals(4,fabricaNumero.convertirStringANumero("4567").longitudNumero());
    }
    
    @Test
    public void cantidadDeDigitosIgualA8ConStringIngresado(){
       
        Assert.assertEquals(8,fabricaNumero.convertirStringANumero("12345678").longitudNumero());
    }
    
    @Test
    public void generaDigitosEntre0Y9(){
        
      Numero numeroGenerado=fabricaNumero.generarNumeroAAdivinar(10);  
      Assert.assertTrue(numeroGenerado.getNumero().stream()
              .allMatch(n->n>=0 && n<=9));
    }
    
    @After
    public void tearDown() {
    }
}
