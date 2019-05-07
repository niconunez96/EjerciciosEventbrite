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
public class Pensador {
    
    private Numero numeroAAdivinar;
    
    public Pensador(){
        this.numeroAAdivinar=NumeroFactory.getFabricaNumeros().generarNumeroAAdivinar(4);
    }
    
    /* Solo para testear*/
    public void setNumero(Numero numero){
        
        this.numeroAAdivinar=numero;
    }
    
    public void mostrarNumero(){
        System.out.println("*******");
        this.numeroAAdivinar.getNumero().forEach(n->System.out.print(n));
        System.out.println("\n*******");
    }
    
    public boolean adivinar(Numero numeroPrueba){
        
        int aciertos=this.numeroAAdivinar.cantidadAciertos(numeroPrueba.getNumero());
        int regulares=this.numeroAAdivinar.cantidadRegulares(numeroPrueba.getNumero());
        
        System.out.println("Cantidad aciertos: "+ aciertos+"\nCantidad regulares: "+regulares);
        
        return aciertos==4;
       
    }
}
