/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

import com.eventbrite.juegoadivinador.jugadores.Pensador;
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
public class AdivinarNumeroDelPensadorTest {

    private Pensador pensador=new Pensador();
    private Numero numeroPensado;

    public AdivinarNumeroDelPensadorTest() {
    }

    @Before
    public void init() {
     this.numeroPensado=new Numero(Arrays.asList(5,8,9,2));
     this.pensador.setNumero(numeroPensado);
    }

    @Test
    public void seAdivinaElNroDelPensador() {
        Numero numero = new Numero(Arrays.asList(5, 8, 9, 2));
       
        pensador.adivinar(numero);
        Assert.assertTrue(pensador.numeroFueAdivinado());
    }
    
    @Test
    public void noSeAdivinaElNroDelPensador() {
        Numero numero = new Numero(Arrays.asList(5, 9, 8, 2));
        pensador.adivinar(numero);
        Assert.assertFalse(pensador.numeroFueAdivinado());
    }

    @After
    public void tearDown() {
    }

}
