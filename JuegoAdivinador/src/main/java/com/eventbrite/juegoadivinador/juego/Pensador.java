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
    private int cantidadAciertos=0;
    private int cantidadRegulares=0;
    
    public Pensador(){
        this.numeroAAdivinar=new Numero();
    }
    
    public void pensarNumero(int longitud){
        this.numeroAAdivinar=NumeroFactory.getFabricaNumeros().generarNumeroAAdivinar(longitud);
    }
    
    /* Solo para testear*/
    public void setNumero(Numero numero){
        
        this.numeroAAdivinar=numero;
    }
    
     public int getCantidadAciertos(){
        return this.cantidadAciertos;
    }
    
    public int getCantidadRegulares(){
        return this.cantidadRegulares;
    }
    
    public void mostrarNumero(){
        System.out.println("*******");
        this.numeroAAdivinar.getNumero().forEach(n->System.out.print(n));
        System.out.println("\n*******");
    }
    
    public void mostrarCantidadAciertosYRegulares(){
        
        System.out.println("Cantidad de aciertos: "+this.cantidadAciertos+"\nCantidad de regulares: "+this.cantidadRegulares);
    }
    
    public int longitudDelNumeroPensado(){
        return this.numeroAAdivinar.longitudNumero();
    }
    
    public boolean adivinar(Numero numeroPrueba){
        
        this.cantidadAciertos=this.numeroAAdivinar.cantidadAciertos(numeroPrueba.getNumero());
        this.cantidadRegulares=this.numeroAAdivinar.cantidadRegulares(numeroPrueba.getNumero());
       
        return this.cantidadAciertos==this.longitudDelNumeroPensado();
       
    }
}
