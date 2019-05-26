/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventbrite.juegoadivinador.numero;

import java.util.List;

/**
 *
 * @author nicolas
 */
public class CriterioDigitoEsAcierto implements Criterio{
    
    
    public CriterioDigitoEsAcierto(){
        
    }
    
    @Override
    public boolean cumpleCriterio(int index,List<Integer> digitosPosta,List<Integer> digitosPrueba){
        
        return digitosPosta.get(index)==digitosPrueba.get(index);
    }
}
