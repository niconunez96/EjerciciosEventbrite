/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

import com.eventbrite.juegoadivinador.numero.*;
import java.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author nicolas
 */
public class EvaluarSiUnNumeroEsRegularOAciertoTest {
    
    private Criterio criterioRegular= new CriterioDigitoEsRegular();
    private Criterio criterioAcierto= new CriterioDigitoEsAcierto();
    
    private Numero numeroPosta=null;
    private Numero numeroPrueba=null;
    public EvaluarSiUnNumeroEsRegularOAciertoTest() {
    }
    
    @Before
    public void init() {
        this.numeroPosta=new Numero(Arrays.asList(5,5,1,0));
        this.numeroPrueba=new Numero(Arrays.asList(0,5,1,1));
    }
    
    @Test
    public void digito1EsRegular(){
        
        Assert.assertTrue(criterioRegular.cumpleCriterio(0, this.numeroPosta.getNumero(), this.numeroPrueba.getNumero()));
    }
    
    @Test
    public void digito4NoEsRegular(){
        Assert.assertFalse(criterioRegular.cumpleCriterio(3,this.numeroPosta.getNumero(),this.numeroPrueba.getNumero()));
    }
    
    @Test
    public void digito2EsAcierto(){
        Assert.assertTrue(criterioAcierto.cumpleCriterio(1, numeroPosta.getNumero(), numeroPrueba.getNumero()));
    }
    
    @Test
    public void digito4NoEsAcierto(){
        Assert.assertFalse(criterioAcierto.cumpleCriterio(3, numeroPosta.getNumero(), numeroPrueba.getNumero()));
    }
    @After
    public void tearDown() {
    }

    
}
