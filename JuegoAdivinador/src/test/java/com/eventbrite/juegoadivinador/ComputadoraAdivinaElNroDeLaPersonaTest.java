/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

import com.eventbrite.juegoadivinador.juego.Adivinador;
import com.eventbrite.juegoadivinador.juego.Pensador;
import com.eventbrite.juegoadivinador.numero.Numero;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author nicolas
 */
public class ComputadoraAdivinaElNroDeLaPersonaTest {
    
    Pensador persona=new Pensador();
    Adivinador computadora=new Adivinador();
    Numero numeroPensado=new Numero();
    
    public ComputadoraAdivinaElNroDeLaPersonaTest() {
    }
    
    @Before
    public void init() {
        numeroPensado.setNumero(Arrays.asList(8,1,3,6));
        persona.setNumero(this.numeroPensado);
    }
    
    @Test
    public void computadoraDescifraElDigito3(){
        
        Numero numeroPrueba=new Numero();
        numeroPrueba.setNumero(Arrays.asList(4,0,1,0));
        
        computadora.descifrarDigito(this.persona, numeroPrueba, 3);
        
        Assert.assertEquals(this.numeroPensado.getNumero().get(2),numeroPrueba.getNumero().get(2) );
    }
    
    @Test
    public void computadoraDescifraElDigito1(){
        
        Numero numeroPrueba=new Numero();
        numeroPrueba.setNumero(Arrays.asList(9,4,2,0));
        
        computadora.descifrarDigito(this.persona, numeroPrueba, 1);
        
        Assert.assertEquals(this.numeroPensado.getNumero().get(0),numeroPrueba.getNumero().get(0) );
    }
    
    @Test
    public void computadoraAdivinaElNumero(){
    
        Assert.assertEquals(computadora.descifrarNumero(persona).toString(),this.numeroPensado.toString());
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
