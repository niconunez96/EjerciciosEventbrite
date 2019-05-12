/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.jugadores;

import com.eventbrite.juegoadivinador.numero.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicolas
 */
public class Adivinador {

    private int cantidadAciertos = 0;
    private int cantidadAciertosAntigua = 0;
    private static int cantidadIteraciones=0;
    private List<Numero> numerosQueYaPregunte=new ArrayList<Numero>();
    
    public Adivinador() {
        
        this.numerosQueYaPregunte=new ArrayList<Numero>();
    }

    public void intentarAdivinar(Numero numeroPrueba, Pensador pensador) {

        pensador.adivinar(numeroPrueba);
    }

    public void adivinarNumeroDelPensador(Pensador pensador){
    
        Numero numeroPosta=this.descifrarNumero(pensador);
        System.out.println("El numero que pensaste es "+numeroPosta);
        System.out.println("Cantidad de preguntas: "+cantidadIteraciones);
    }
    
    public Numero descifrarNumero(Pensador pensador) {

        Numero numeroPosta = new Numero();
        Numero numeroPrueba = NumeroFactory.getFabricaNumeros().generarNumeroAleatorio(pensador.longitudDelNumeroPensado());
        
        
        numeroPosta.setNumero(numeroPrueba.getNumero());
        this.intentarAdivinar(numeroPrueba, pensador);
        this.numerosQueYaPregunte.add(new Numero(numeroPrueba.getNumero()));
        this.cantidadAciertos = pensador.getCantidadAciertos();

        for (int i = 1; i <= pensador.longitudDelNumeroPensado() && !pensador.numeroFueAdivinado(); i++) {

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
            numeroPrueba.modificarUnDigito(indice,this.numerosQueYaPregunte.stream().map(n->n.getNumero()).collect(Collectors.toList()));
            
            System.out.println("Tu numero es " + numeroPrueba.toString() + "?");
            
            this.intentarAdivinar(numeroPrueba, pensador);
            this.numerosQueYaPregunte.add(new Numero(numeroPrueba.getNumero()));
            cantidadIteraciones++;
            pensador.mostrarCantidadAciertosYRegulares();
        }
        
        this.numerosQueYaPregunte.removeIf(n->true);
    }

}
