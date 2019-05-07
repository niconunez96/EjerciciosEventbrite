/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.juego;

import com.eventbrite.juegoadivinador.numero.*;

/**
 *
 * @author nicolas
 */
public class Adivinador {
    
    public Adivinador(){
        
    }
    
    public boolean intentarAdivinar(String numeroIngresado, Pensador pensador){
        
        Numero numeroPrueba=NumeroFactory.getFabricaNumeros().convertirStringANumero(numeroIngresado);
        
        return pensador.adivinar(numeroPrueba);
    }
}
