/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.jugadores;

import com.eventbrite.juegoadivinador.numero.Numero;

/**
 *
 * @author nicolas
 */
public class Restriccion {
 
    private int cantidadAciertosACumplir;
    private int cantidadRegularesACumplir;
    private Numero numero;
    
    public Restriccion(int cantAciertos,int cantRegulares,Numero n){
        
        this.cantidadAciertosACumplir=cantAciertos;
        this.cantidadRegularesACumplir=cantRegulares;
        this.numero=new Numero(n.getNumero());
    }
    
    public boolean cumpleRestriccion(Numero nro){
        
        return this.cantidadAciertosACumplir==this.numero.cuantosDigitosAcerte(nro.getNumero())
                && this.cantidadRegularesACumplir==this.numero.cuantosDigitosSonRegulares(nro.getNumero());
        
    }
    
    
    
}
