/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.juego;

import com.eventbrite.juegoadivinador.numero.*;

/**
 *
 * @author nicolas
 */
public class Adivinador {
    
    private Numero nroOro;
    
    public Adivinador(){
        
    }
    
    public void setNumero(Numero numero){
        this.nroOro=numero;
    }
    
    public boolean intentarAdivinar(Numero numeroPrueba, Pensador pensador){
        
        this.nroOro=numeroPrueba;
        return pensador.adivinar(this.nroOro);
    }
    
    public void adivinarNumero(Pensador pensador){
        
        int cantidadAciertos;
        int cantidadAciertosAntigua=0;
        int cantidadIteraciones=0;
        
        this.nroOro=NumeroFactory.getFabricaNumeros().generarNumeroAAdivinar(pensador.longitudDelNumeroPensado());
        this.intentarAdivinar(this.nroOro, pensador);
        cantidadAciertos=pensador.getCantidadAciertos();
        
        for(int i=1;i<=pensador.longitudDelNumeroPensado();i++){
            
            if(cantidadAciertos==pensador.longitudDelNumeroPensado())
                break;
            System.out.println(pensador.getCantidadAciertos());
            while(cantidadAciertos>=pensador.getCantidadAciertos() && cantidadAciertosAntigua<=pensador.getCantidadAciertos()){
                
                cantidadAciertosAntigua=pensador.getCantidadAciertos();
                this.nroOro.modificarUnDigito(i);
                this.intentarAdivinar(this.nroOro, pensador);
                pensador.mostrarCantidadAciertosYRegulares();
                ++cantidadIteraciones;
            }
            
            if(cantidadAciertosAntigua>pensador.getCantidadAciertos()){ 
                --i;
                cantidadAciertos=cantidadAciertosAntigua;
                cantidadAciertosAntigua=0;
            }
            System.out.println("Listo nro "+i);
            cantidadAciertos=pensador.getCantidadAciertos();
        }
        
        System.out.println("El numero que pensaste es: "+this.nroOro.getNumero().toString());
        System.out.println("Cantidad de iteraciones: "+cantidadIteraciones);
    }
}
