/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;


import java.util.Arrays;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author nicolas
 */
public class CantidadDeAciertosYRegularesTest {
    
    private Numero numeroAAdivinar=new Numero();
    private Numero numeroAAdivinar2=new Numero();
    
    public CantidadDeAciertosYRegularesTest() {
        
    }

    @Before
    public void init() {
       numeroAAdivinar.setNumero(Arrays.asList(1,2,3,4));
       numeroAAdivinar2.setNumero(Arrays.asList(1,1,1,1));
    }
    
    
    @Test
    public void cantidadDeAciertosIgualA0(){
        Numero numeroPrueba=new Numero();
        numeroPrueba.setNumero(Arrays.asList(0,5,8,0));
        Assert.assertEquals(0,this.numeroAAdivinar.cantidadAciertos(numeroPrueba.getNumero()));
    }
    
    @Test
    public void aciertaTodos(){
        Numero numeroPrueba=new Numero();
        numeroPrueba.setNumero(Arrays.asList(1,2,3,4));
        Assert.assertEquals(4,this.numeroAAdivinar.cantidadAciertos(numeroPrueba.getNumero()));
    }
    
    @Test
    public void cantidadDeAciertosEs2(){
        Numero numeroPrueba=new Numero();
        numeroPrueba.setNumero(Arrays.asList(0,1,0,1));
        Assert.assertEquals(2,this.numeroAAdivinar2.cantidadAciertos(numeroPrueba.getNumero()));
    }
    
    @Test
    public void cantidadDeRegularesEs2(){
        Numero numeroPrueba=new Numero();
        numeroPrueba.setNumero(Arrays.asList(2,9,8,1));
        Assert.assertEquals(2,this.numeroAAdivinar.cantidadRegulares(numeroPrueba.getNumero()));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}