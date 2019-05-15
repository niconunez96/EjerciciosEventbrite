/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

import com.eventbrite.juegoadivinador.numero.*;

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
    
    private Numero numeroAAdivinar;
    private Numero numeroAAdivinar2;
    private Numero numeroAAdivinar3;
    
    public CantidadDeAciertosYRegularesTest() {
        
    }

    @Before
    public void init() {
       this.numeroAAdivinar=new Numero(Arrays.asList(1,2,3,4));
       this.numeroAAdivinar2=new Numero(Arrays.asList(1,1,1,1));
       this.numeroAAdivinar3=new Numero(Arrays.asList(4,3,3,3));
    }
    
    
    @Test
    public void cantidadDeAciertosIgualA0(){
        Numero numeroPrueba=new Numero(Arrays.asList(0,5,8,0));
        Assert.assertEquals(0,this.numeroAAdivinar.cuantosDigitosAcerte(numeroPrueba.getNumero()));
    }
      
    @Test
    public void cantidadDeAciertosEs2(){
        Numero numeroPrueba=new Numero(Arrays.asList(0,1,0,1));
        Assert.assertEquals(2,this.numeroAAdivinar2.cuantosDigitosAcerte(numeroPrueba.getNumero()));
    }
    
    @Test
    public void aciertaTodos(){
        Numero numeroPrueba=new Numero(Arrays.asList(1,2,3,4));
        Assert.assertEquals(4,this.numeroAAdivinar.cuantosDigitosAcerte(numeroPrueba.getNumero()));
    }
    
    @Test
    public void cantidadDeRegularesEs2(){
        Numero numeroPrueba=new Numero(Arrays.asList(9,8,2,1));
        Assert.assertEquals(2,this.numeroAAdivinar.cuantosDigitosSonRegulares(numeroPrueba.getNumero()));
    }
    
    @Test
    public void cantidadDeRegularesEs0(){
        Numero numeroPrueba=new Numero(Arrays.asList(3,8,3,3));
        Assert.assertEquals(1,this.numeroAAdivinar3.cuantosDigitosSonRegulares(numeroPrueba.getNumero()));
    }
    
    @After
    public void tearDown() {
    }

}