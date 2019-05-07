/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.eventbrite.juegoadivinador.juego.*;
import java.util.Scanner;

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
        Scanner teclado=new Scanner(System.in);
        Juego juegoNuevo=new Juego();
        System.out.println("Bienvdenido al juego de adivinar el numero!!, ¿cuantos digitos debe tener el numero que voy a pensar?");
        int cantidadDigitos=Integer.parseInt(teclado.next());
        juegoNuevo.empezarJuego(cantidadDigitos);
    }
    
}
