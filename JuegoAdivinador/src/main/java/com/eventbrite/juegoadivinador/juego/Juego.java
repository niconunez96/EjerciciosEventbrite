/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.juego;

import java.util.Scanner;

/**
 *
 * @author nicolas
 */
public abstract class Juego {
    
    protected Pensador pensador;
    protected Adivinador adivinador;
    protected boolean gameOver=false;
    
    public Juego(){
        this.adivinador=new Adivinador();
        this.pensador=new Pensador();
    }
    
    abstract public void empezarJuego();
    
    protected String leerHastaQueSeIngreseLaCantidadCorrectaDeDigitos() {

        String numeroIngresado;
        do {
            this.mostrarMensaje();
            numeroIngresado = this.leerTeclado();
        } while (this.longitudDeNumeroEsCorrecta(numeroIngresado));
        
        return numeroIngresado;
    }

    protected String leerTeclado() {
        Scanner teclado = new Scanner(System.in);
        return teclado.next();
    }
    
    protected boolean longitudDeNumeroEsCorrecta(String numeroIngresado){
        
        return (numeroIngresado.length() < this.pensador.longitudDelNumeroPensado()) || (numeroIngresado.length() > this.pensador.longitudDelNumeroPensado());
    }
    
    abstract protected void mostrarMensaje();
}
