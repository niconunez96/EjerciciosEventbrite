/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.juego;

import com.eventbrite.juegoadivinador.numero.Numero;
import com.eventbrite.juegoadivinador.numero.NumeroFactory;
import java.util.Scanner;

/**
 *
 * @author nicolas
 */
public class JugadorAdivina extends Juego {
    
    public JugadorAdivina(int cantidadDigitosConLosQueVoyAJugar) {
        this.adivinador=new Adivinador();
        this.pensador=new Pensador();
        this.pensador.pensarNumero(cantidadDigitosConLosQueVoyAJugar);
    }

    @Override
    public void empezarJuego() {

        pensador.mostrarNumero();
        while (!gameOver) {

            String numeroIngresado = this.leerHastaQueSeIngreseLaCantidadCorrectaDeDigitos();
            Numero numeroAProbar=NumeroFactory.getFabricaNumeros().convertirStringANumero(numeroIngresado);
            this.gameOver = adivinador.intentarAdivinar(numeroAProbar, pensador);
            this.pensador.mostrarCantidadAciertosYRegulares();

        }
        System.out.println("Ganaste!");
    }

    @Override
    protected void mostrarMensaje(){
        System.out.println("Ingrese un numero de "+this.pensador.longitudDelNumeroPensado() +" digitos para adivinar el numero generado por el pensador:");
    }
    
}
