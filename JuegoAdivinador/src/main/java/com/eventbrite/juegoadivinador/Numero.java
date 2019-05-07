/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador;

import java.util.ArrayList;
import java.util.List;

public class Numero {

    private List numero = null;

    public Numero() {
        numero = new ArrayList<>();
    }
    
    public void setNumero(List numero){
        this.numero=numero;
    }
    
    public void agregarNumero(int numero) {

        this.numero.add(numero);
    }
    
    public List getNumero(){
        return this.numero;
    }
    
    public int cantidadAciertos(List numeroPrueba){
        
        int cantidadAciertos=0;
        for(int i=0;i<this.numero.size();i++){
            cantidadAciertos=(this.numero.get(i)==numeroPrueba.get(i)) ? cantidadAciertos+1:cantidadAciertos;
        }
        return cantidadAciertos;
    }
    
    public int cantidadRegulares(List numeroPrueba){
        
        int cantidadRegulares=0;
        for(int i=0;i<this.numero.size();i++){
            
            cantidadRegulares= 
                   (this.numero.contains(numeroPrueba.get(i)) && this.numero.get(i)!=numeroPrueba.get(i)) ? cantidadRegulares+1:cantidadRegulares;
        }
        return cantidadRegulares;
    }

}