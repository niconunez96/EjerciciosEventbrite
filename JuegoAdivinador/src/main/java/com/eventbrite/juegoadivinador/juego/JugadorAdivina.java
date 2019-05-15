/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.juego;

import com.eventbrite.juegoadivinador.jugadores.Pensador;
import com.eventbrite.juegoadivinador.numero.Numero;
import com.eventbrite.juegoadivinador.numero.NumeroFactory;

/**
 *
 * @author nicolas
 */
public class JugadorAdivina extends Juego {
    
    private Pensador pensador;
    
    public JugadorAdivina(int cantidadDigitosConLosQueVoyAJugar) {
        this.pensador=new Pensador();
        this.pensador.pensarNumero(cantidadDigitosConLosQueVoyAJugar);
    }

    @Override
    public void empezarJuego() {

        pensador.mostrarNumero();
        while (!gameOver) {

            String numeroIngresado = this.leerHastaQueSeIngreseLaCantidadCorrectaDeDigitos();
            Numero numeroAProbar=NumeroFactory.getFabricaNumeros().convertirStringANumero(numeroIngresado);
            pensador.adivinar(numeroAProbar);
            this.gameOver = pensador.numeroFueAdivinado();
            this.pensador.mostrarCantidadAciertosYRegulares();

        }
        this.mostrarMensaje();
    }
    
    private void mostrarMensaje(){
        System.out.println("Ingrese un numero de "+this.pensador.longitudDelNumeroPensado() +" digitos para adivinar el numero generado por el pensador:");
    }
    
    @Override
    protected void mostrarMensajeDeFinalizacion(){
        System.out.println("El numero que ingresaste es el que habia pensado, ganaste!!");
    }
    
    private String leerHastaQueSeIngreseLaCantidadCorrectaDeDigitos() {

        String numeroIngresado;
        do {
            this.mostrarMensaje();
            numeroIngresado = this.leerTeclado();
        } while (this.longitudDeNumeroEsCorrecta(numeroIngresado));
        
        return numeroIngresado;
    }
    
    protected boolean longitudDeNumeroEsCorrecta(String numeroIngresado){
        
        return (numeroIngresado.length() < this.pensador.longitudDelNumeroPensado()) || (numeroIngresado.length() > this.pensador.longitudDelNumeroPensado());
    }
    
}
