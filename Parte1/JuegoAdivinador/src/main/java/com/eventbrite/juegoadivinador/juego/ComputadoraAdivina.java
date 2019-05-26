/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.juego;

import com.eventbrite.juegoadivinador.jugadores.Adivinador;

/**
 *
 * @author nicolas
 */
public class ComputadoraAdivina extends Juego{
    
    private String cantAciertos;
    private String cantRegulares;
    private Adivinador adivinador;
    public ComputadoraAdivina(){
        
        this.adivinador=new Adivinador();
        this.cantAciertos="0";
        this.cantRegulares="0";
    }
    
    @Override
    public void empezarJuego(){
        
        while(!this.gameOver){
            adivinador.generarNumeroPrueba();
            adivinador.mostrarNumeroPrueba();
            
            this.leerAciertosYRegulares();
            adivinador.agregarRestriccion(Integer.parseInt(cantAciertos),Integer.parseInt(cantRegulares));
            
            this.gameOver=Integer.parseInt(cantAciertos)==4;
        }
        this.mostrarMensajeDeFinalizacion();
        
    }
    
    @Override
    protected void mostrarMensajeDeFinalizacion(){
        System.out.println("Gane!!!");
    }
    private void leerAciertosYRegulares(){
        System.out.println("Cuantos aciertos tuve?");
        this.cantAciertos=this.leerTeclado();
        System.out.println("Cuantas regulares tuve?");
        this.cantRegulares=this.leerTeclado();
    }
   
}
