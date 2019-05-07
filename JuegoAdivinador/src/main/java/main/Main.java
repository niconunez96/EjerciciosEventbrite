/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.eventbrite.juegoadivinador.juego.*;

/**
 *
 * @author nicolas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bienvdenido al juego de adivinar el numero!!");
        Pensador nicolas=new Pensador();
        Adivinador tamara=new Adivinador();
        Juego juegoNuevo=new Juego(nicolas,tamara);
        juegoNuevo.empezarJuego();
    }
    
}
