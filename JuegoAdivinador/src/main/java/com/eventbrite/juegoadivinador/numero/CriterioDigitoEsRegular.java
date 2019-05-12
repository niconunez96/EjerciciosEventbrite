 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.numero;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicolas
 */
public class CriterioDigitoEsRegular implements Criterio {
    
    public CriterioDigitoEsRegular(){
        
    }
    
    @Override
    public boolean cumpleCriterio(int indice,List<Integer> digitosPosta,List<Integer> digitosPrueba){
        
        return (digitosPosta.contains(digitosPrueba.get(indice))
            && !(this.yaEstanCompletosLosAciertosConDigito(digitosPrueba.get(indice),digitosPosta,digitosPrueba)))
            && !this.digitosSonIguales(digitosPosta.get(indice),digitosPrueba.get(indice));
    }
    
    private boolean yaEstanCompletosLosAciertosConDigito(int digito,List<Integer> digitosPosta,List<Integer> digitosPrueba){
       
        return this.cantidadDeAciertosQueDeberiaTenerSegunUnDigito(digito,digitosPosta) 
                == this.cantidadDeAciertosQueTengoConDigito(digito, digitosPosta, digitosPrueba);
    }
    
    private int cantidadDeAciertosQueTengoConDigito(int digito,List<Integer> digitosPosta,List<Integer> digitosPrueba){
        
        int cantidad=0;
        for(int i=0;i<digitosPrueba.size();i++){
            
            cantidad= this.digitosSonIguales(digitosPrueba.get(i),digito) && this.digitosSonIguales(digitosPosta.get(i),digitosPrueba.get(i)) ? cantidad+1:cantidad;
        }
        return cantidad;
    }
    
    private int cantidadDeAciertosQueDeberiaTenerSegunUnDigito(int digito,List<Integer> digitosPosta){
        return digitosPosta.stream()
                .filter(n->n==digito).collect(Collectors.toList()).size();
    }
    
    private boolean digitosSonIguales(int digito1,int digito2){
        return digito1==digito2;
    }
}
