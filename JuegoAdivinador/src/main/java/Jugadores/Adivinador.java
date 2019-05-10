/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugadores;

import com.eventbrite.juegoadivinador.numero.*;

/**
 *
 * @author nicolas
 */
public class Adivinador {

    private int cantidadAciertos = 0;
    private int cantidadAciertosAntigua = 0;

    public Adivinador() {

    }

    public void intentarAdivinar(Numero numeroPrueba, Pensador pensador) {

        pensador.adivinar(numeroPrueba);
    }

    public void adivinarNumeroDelPensador(Pensador pensador){
    
        Numero numeroPosta=this.descifrarNumero(pensador);
        System.out.println("El numero que pensaste es "+numeroPosta);
    }
    
    public Numero descifrarNumero(Pensador pensador) {

        Numero numeroPosta = new Numero();
        Numero numeroPrueba = NumeroFactory.getFabricaNumeros().generarNumeroAleatorio(pensador.longitudDelNumeroPensado());
        numeroPosta.setNumero(numeroPrueba.getNumero());

        this.intentarAdivinar(numeroPrueba, pensador);

        this.cantidadAciertos = pensador.getCantidadAciertos();

        for (int i = 1; i <= pensador.longitudDelNumeroPensado(); i++) {

            if (pensador.numeroFueAdivinado()) {
                break;
            }

            this.descifrarDigito(pensador, numeroPrueba, i);

            if (this.cantidadAciertosAntigua > pensador.getCantidadAciertos()) 
            {
                numeroPrueba.setNumero(numeroPosta.getNumero());
                pensador.adivinar(numeroPrueba);
            }
            else 
            {
                numeroPosta.setNumero(numeroPrueba.getNumero());
                this.cantidadAciertos = pensador.getCantidadAciertos();
            }
        }
        return numeroPosta;

    }

    public void descifrarDigito(Pensador pensador, Numero numeroPrueba, int indice) {

        while (this.cantidadAciertos >= pensador.getCantidadAciertos() && this.cantidadAciertosAntigua <= pensador.getCantidadAciertos()) {

            this.cantidadAciertosAntigua = pensador.getCantidadAciertos();
            numeroPrueba.modificarUnDigito(indice);
            System.out.println("Tu numero es " + numeroPrueba.toString() + "?");
            this.intentarAdivinar(numeroPrueba, pensador);
            pensador.mostrarCantidadAciertosYRegulares();
        }
    }

}
