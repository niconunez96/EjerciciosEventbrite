/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.numero;

import java.util.ArrayList;
import java.util.List;

public class Numero {

    private List<Integer> digitos = null;

    public Numero() {
        digitos = new ArrayList<Integer>();
    }

    public Numero(List<Integer> numero) {
        this.digitos = new ArrayList<Integer>(numero);
    }
    
    public void setNumero(List<Integer> numero) {
        this.digitos = new ArrayList<Integer>(numero);
    }

    public List<Integer> getNumero() {
        return this.digitos;
    }

    public int longitudNumero() {
        return this.digitos.size();
    }

    @Override
    public String toString() {

        return this.digitos.stream().map(n -> n.toString()).reduce("", (a, b) -> a + b);
    }

    public void agregarDigito(int numero) {

        this.digitos.add(numero);
    }

    public int cuantosDigitosAcerte(List<Integer> numeroPrueba) {

        Criterio criterioDigitoEsAcierto = new CriterioDigitoEsAcierto();

        return this.cantidadSegunCriterio(criterioDigitoEsAcierto, numeroPrueba);
    }

    public int cuantosDigitosSonRegulares(List<Integer> numeroPrueba) {

        Criterio criterioDigitoEsRegular = new CriterioDigitoEsRegular();
        return this.cantidadSegunCriterio(criterioDigitoEsRegular, numeroPrueba);
    }

    public int cantidadSegunCriterio(Criterio criterio, List<Integer> numeroPrueba) {

        int cantidad = 0;

        for (int i = 0; i < numeroPrueba.size(); i++) {

            cantidad = criterio.cumpleCriterio(i, this.digitos, numeroPrueba) ? ++cantidad : cantidad;
        }

        return cantidad;
    }

    public void incrementar(){
        
        int numeroInt=Integer.parseInt(this.toString());
        numeroInt++;
        String numeroString=Integer.toString(numeroInt);
        switch(numeroString.length()){
            case 1: numeroString="000"+numeroString;
            break;
            case 2: numeroString="00"+numeroString;
            break;
            case 3: numeroString="0"+numeroString;
        }
        this.digitos.removeIf(n->true);
        for (int i = 0; i < numeroString.length(); i++) {

            this.agregarDigito((numeroString.charAt(i))-48);
        }
    }

}
