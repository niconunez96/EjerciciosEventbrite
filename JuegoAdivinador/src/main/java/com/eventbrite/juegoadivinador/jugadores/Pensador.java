/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.jugadores;

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
    
    /* Solo para testear*/
    public void setNumero(Numero numero){
        
        this.numeroAAdivinar=numero;
    }
    
    public void pensarNumero(int longitud){
        this.numeroAAdivinar=NumeroFactory.getFabricaNumeros().generarNumeroAleatorio(longitud);
    }
    
    public int longitudDelNumeroPensado(){
        return this.numeroAAdivinar.longitudNumero();
    }
    
    public void adivinar(Numero numeroPrueba){
        
        this.cantidadAciertos=this.numeroAAdivinar.cuantosDigitosAcerte(numeroPrueba.getNumero());
        this.cantidadRegulares=this.numeroAAdivinar.cuantosDigitosSonRegulares(numeroPrueba.getNumero());
    }
    
    public boolean numeroFueAdivinado(){
        
        return this.cantidadAciertos==this.longitudDelNumeroPensado();
       
    }
    
    public void mostrarNumero(){
        System.out.println("*******");
        System.out.println(this.numeroAAdivinar.toString());
        System.out.println("*******");
    }
    
    public void mostrarCantidadAciertosYRegulares(){
        System.out.println("Cantidad de aciertos: "+this.cantidadAciertos+"\nCantidad de regulares: "+this.cantidadRegulares);
    }
    
    
}
