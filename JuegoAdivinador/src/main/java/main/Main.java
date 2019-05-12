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
        Juego juegoNuevo=null;
        int opcion=0;
        System.out.println("Bienvenido al juego de adivinar el numero!! por favor seleccione el modo de juego");
        System.out.println("1. La computadora piensa el numero y vos tenes que intentar adivinarlo!");
        System.out.println("2. Vos pensas el numero y la computadora lo adivina!");
        
        do{
            
            opcion=teclado.nextInt();
            
        }while(opcion!=1 && opcion!=2);
        
        if(opcion==1){
            System.out.println("Hola! ¿cuantos digitos debe tener el numero que tengo que pensar?");
            int cantidadDigitos=Integer.parseInt(teclado.next());
            juegoNuevo=new JugadorAdivina(cantidadDigitos);
        }
        else{
            juegoNuevo=new ComputadoraAdivina();
        }
        
        juegoNuevo.empezarJuego();
        
    }
    
}
