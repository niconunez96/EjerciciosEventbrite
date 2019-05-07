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
public class Juego {
    
    private Pensador pensador;
    private Adivinador adivinador;
    private boolean gameOver = false;

    public Juego(Pensador pensador, Adivinador adivinador) {
        this.pensador = pensador;
        this.adivinador = adivinador;
    }

    public void empezarJuego() {

        pensador.mostrarNumero();
        while (!gameOver) {

            String numeroIngresado = this.leerHastaQueSeIngreseLaCantidadCorrectaDeDigitos();
            this.gameOver = adivinador.intentarAdivinar(numeroIngresado, pensador);

        }
        System.out.println("Ganaste!");
    }

    private String leerHastaQueSeIngreseLaCantidadCorrectaDeDigitos() {

        String numeroIngresado;
        do {
            System.out.println("Ingrese un numero de 4 digitos para adivinar el numero generado por el pensador:");
            numeroIngresado = this.leerTeclado();
        } while (numeroIngresado.length() < 4 || numeroIngresado.length() > 4);
        return numeroIngresado;
    }

    private String leerTeclado() {
        Scanner teclado = new Scanner(System.in);
        return teclado.next();
    }
}
