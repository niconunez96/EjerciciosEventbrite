/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.jugadores;

import com.eventbrite.juegoadivinador.numero.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class Adivinador {

    private List<Restriccion> restriccionesACumplir;
    private Numero nroPrueba;
    
    public Adivinador() {
        
        this.restriccionesACumplir=new ArrayList<Restriccion>();
        this.nroPrueba=new Numero(Arrays.asList(0,0,0,0));
    }

    public void agregarRestriccion(int cantAciertos,int cantRegulares){
    
        this.restriccionesACumplir.add(new Restriccion(cantAciertos,cantRegulares,this.nroPrueba));
    }
    
    public void generarNumeroPrueba(){
        
        while(!restriccionesACumplir.stream().allMatch(restr->restr.cumpleRestriccion(nroPrueba))){
            
            this.nroPrueba.incrementar();
        }  
    }
    
    public void mostrarNumeroPrueba(){
        System.out.println("Tu numero es "+this.nroPrueba.toString()+"?");
    }

}
