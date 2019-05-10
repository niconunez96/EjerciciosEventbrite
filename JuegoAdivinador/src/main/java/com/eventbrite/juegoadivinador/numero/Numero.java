/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.numero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Numero {

    private List<Integer> digitos = null;

    public Numero() {
        digitos = new ArrayList<Integer>();
    }
    
    public void setNumero(List<Integer> numero){
        this.digitos=new ArrayList<Integer>(numero);
    }
    
    public List<Integer> getNumero(){
        return this.digitos;
    }
    
    public int longitudNumero(){
        return this.digitos.size();
    }
    
    @Override 
    public String toString(){
        
        return this.digitos.stream().map(n->n.toString()).reduce("",(a,b)->a+b);
    }
    
    public void agregarDigito(int numero) {

        this.digitos.add(numero);
    }
    
    public int cuantosDigitosAcerte(List<Integer> numeroPrueba){
        
        int cantidadAciertos=0;
        for(int i=0;i<numeroPrueba.size();i++){
            
            cantidadAciertos=this.digitoEsUnAcierto(i, numeroPrueba.get(i)) ? ++cantidadAciertos:cantidadAciertos;
        }
        
        return cantidadAciertos;
    }
    
    public int cuantosDigitosSonRegulares(List<Integer> numeroPrueba){
        
        int cantidadRegulares=0;
        
        for(int i=0;i<numeroPrueba.size();i++){
            
            cantidadRegulares=this.digitoEsRegular(i, numeroPrueba) ? cantidadRegulares+1:cantidadRegulares;
        }
        
        return cantidadRegulares;
    }
        
    private boolean digitoEsUnAcierto(int index,int digito){
       
        return digito==this.digitos.get(index);
    }
    
    private boolean digitoEsRegular(int indice,List<Integer> nroPrueba){
        
        return (this.digitos.contains(nroPrueba.get(indice))
            && !(this.yaEstanCompletosLosAciertosConDigito(nroPrueba.get(indice),nroPrueba)))
            && !(this.digitoEsUnAcierto(indice, nroPrueba.get(indice)));
    }
    
    private boolean yaEstanCompletosLosAciertosConDigito(int digito,List<Integer> nroPrueba){
       
        return this.cantidadDeAciertosQueDeberiaTenerSegunUnDigito(digito) 
                == this.cantidadDeAciertosQueTengoConDigito(digito, nroPrueba);
    }
    
    public int cantidadDeAciertosQueDeberiaTenerSegunUnDigito(int digito){
        return this.digitos.stream()
                .filter(n->n==digito).collect(Collectors.toList()).size();
    }
    
    public int cantidadDeAciertosQueTengoConDigito(int digito,List<Integer> numero){
        
        int cantidad=0;
        for(int i=0;i<numero.size();i++){
            
            cantidad= numero.get(i)==digito && this.digitoEsUnAcierto(i, numero.get(i)) ? cantidad+1:cantidad;
        }
        return cantidad;
    }
    
     public void modificarUnDigito(int indice){
        
        int numeroNuevo= (int) (Math.random()*10);
        this.digitos.add(indice, numeroNuevo);
        this.digitos.remove(indice-1);
       
    }

}