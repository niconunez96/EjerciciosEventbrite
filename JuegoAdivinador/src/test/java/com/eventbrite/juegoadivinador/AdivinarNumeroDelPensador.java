/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

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
public class AdivinarNumeroDelPensador {

    private Pensador pensador=new Pensador();
    private Numero numeroPensado=new Numero();

    public AdivinarNumeroDelPensador() {
    }

    @Before
    public void init() {
     this.numeroPensado.setNumero(Arrays.asList(5,8,9,2));
     this.pensador.setNumero(numeroPensado);
    }

    @Test
    public void seAdivinaElNroDelPensador() {
        Numero numero = new Numero();
        numero.setNumero(Arrays.asList(5, 8, 9, 2));
        Assert.assertTrue(pensador.adivinar(numero));
    }
    
    @Test
    public void noSeAdivinaElNroDelPensador() {
        Numero numero = new Numero();
        numero.setNumero(Arrays.asList(5, 9, 8, 2));
        Assert.assertFalse(pensador.adivinar(numero));
    }

    @After
    public void tearDown() {
    }

}
