/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.numero;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        for(int i=0;i<numeroPrueba.size();i++){
            
            cantidadAciertos=this.digitoEsUnAcierto(i, numeroPrueba) ? ++cantidadAciertos:cantidadAciertos;
        }
        
        return cantidadAciertos;
    }
    
    public int cantidadRegulares(List<Integer> numeroPrueba){
        
        int cantidadRegulares=0;
        
        for(int i=0;i<numeroPrueba.size();i++){
            
            cantidadRegulares=this.digitoEsRegular(i, numeroPrueba) ? cantidadRegulares+1:cantidadRegulares;
        }
        return cantidadRegulares;
    }
        
    private boolean digitoEsUnAcierto(int index,List<Integer>nroPrueba){
       
        return nroPrueba.get(index)==this.numero.get(index);
    }
    
    private boolean digitoEsRegular(int indice,List<Integer> nroPrueba){
        
        return (this.numero.contains(nroPrueba.get(indice))
            && !(this.yaEstanCompletosLosAciertosConDigito(nroPrueba.get(indice),nroPrueba)))
            && !(this.digitoEsUnAcierto(indice, nroPrueba));
    }
    
    private boolean yaEstanCompletosLosAciertosConDigito(int digito,List<Integer> nroPrueba){
       
        return this.cantidadDeAciertosQueDeberiaTenerSegunUnDigito(digito) == this.cantidadDeAciertosQueTengoSegunUnDigito(digito, nroPrueba);
    }
    
    public int cantidadDeAciertosQueDeberiaTenerSegunUnDigito(int digito){
        return this.numero.stream()
                .filter(n->n==digito).collect(Collectors.toList()).size();
    }
    
    public int cantidadDeAciertosQueTengoSegunUnDigito(int digito,List<Integer> numero){
        
        int cantidad=0;
        for(int i=0;i<numero.size();i++){
            
            cantidad= numero.get(i)==digito && this.digitoEsUnAcierto(i, numero) ? cantidad+1:cantidad;
        }
        return cantidad;
    }
    
     public void modificarUnDigito(int indice){
        
        int numeroNuevo= (int) (Math.random()*10);
        this.numero.add(indice, numeroNuevo);
        this.numero.remove(indice-1);
       
    }

}