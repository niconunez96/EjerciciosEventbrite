/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.numero;

import java.util.ArrayList;
import java.util.List;

public class Numero {

    private List<Integer> numero = null;

    public Numero() {
        numero = new ArrayList<Integer>();
    }
    
    public void setNumero(List<Integer> numero){
        this.numero=numero;
    }
    
    public List<Integer> getNumero(){
        return this.numero;
    }
    
    public int longitudNumero(){
        return this.numero.size();
    }
    
    public void agregarNumero(int numero) {

        this.numero.add(numero);
    }
    
    public int cantidadAciertos(List<Integer> numeroPrueba){
        
        int cantidadAciertos=0;
        for(int i=0;i<this.numero.size();i++){
            cantidadAciertos=(this.numero.get(i)==numeroPrueba.get(i)) ? cantidadAciertos+1:cantidadAciertos;
        }
        
        return cantidadAciertos;
    }
    
    public int cantidadRegulares(List<Integer> numeroPrueba){
        
        int cantidadRegulares=0;
        for(int i=0;i<this.numero.size();i++){
            
            cantidadRegulares= 
                   (this.numero.contains(numeroPrueba.get(i)) && this.numero.get(i)!=numeroPrueba.get(i)) ? cantidadRegulares+1:cantidadRegulares;
        }
        return cantidadRegulares;
    }

}