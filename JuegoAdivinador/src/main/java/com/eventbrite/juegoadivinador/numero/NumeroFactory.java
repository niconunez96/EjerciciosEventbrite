/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.numero;

/**
 *
 * @author nicolas
 */
public class NumeroFactory {
    
    private static NumeroFactory fabricaNumeros = null;

    private NumeroFactory() {

    }

    public static NumeroFactory getFabricaNumeros() {

        if (fabricaNumeros == null) {
            fabricaNumeros = new NumeroFactory();
        }
        return fabricaNumeros;
    }

    public Numero generarNumeroAAdivinar(int cantidadDigitos) {

        Numero numeroAAdivinar = new Numero();

        for (int i = 1; i <= cantidadDigitos; i++) {

            Integer numero = (int) (Math.random() * 9);
            numeroAAdivinar.agregarNumero(numero);
        }
        return numeroAAdivinar;
    }

    public Numero convertirStringANumero(String numeroIngresado) {

        Numero numero = new Numero();
        for (int i = 0; i < numeroIngresado.length(); i++) {

            numero.agregarNumero((numeroIngresado.charAt(i))-48);
        }
        return numero;
    }
}
