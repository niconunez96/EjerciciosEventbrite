/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.juego;

import com.eventbrite.juegoadivinador.numero.Numero;
import com.eventbrite.juegoadivinador.numero.NumeroFactory;

/**
 *
 * @author nicolas
 */
public class ComputadoraAdivina extends Juego{
    
    public ComputadoraAdivina(){
        super();
    }
    
    @Override
    public void empezarJuego(){
        
        this.mostrarMensaje();
        Numero numeroPensado=NumeroFactory.getFabricaNumeros().convertirStringANumero(this.leerTeclado());
        this.pensador.setNumero(numeroPensado);
        this.pensador.mostrarNumero();
        this.adivinador.adivinarNumeroDelPensador(pensador);
        
    }
    
    @Override
    public void mostrarMensaje(){
        System.out.println("Ingrese el numero que esta pensando (tranquilo yo no puedo ver ese numero :))");
    }
   
}
