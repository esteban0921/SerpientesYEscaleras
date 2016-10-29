/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.*;
import presentacion.UI;

/**
 *
 * @author LENOVO
 */
public class Juego {

    private Tipo tipo;
    private Jugador jugadores[];
    private Dado dado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a[] = {2,6};
        int b[] = {6,8};
        Serpiente serpiente1 = new Serpiente(a,b);
        
        int aa[] = {0,1};
        int bb[] = {5,0};
        Serpiente serpiente2 = new Serpiente(aa,bb);
        
        Serpiente s1[] = {serpiente1, serpiente2};
        
        int c[] = {9,2};
        int d[] = {4,3};
        Escalera escalera1 = new Escalera(c,d);
        
        int cc[] = {4,9};
        int dd[] = {1,8};
        Escalera escalera2 = new Escalera(cc,dd);
        
        Escalera e1[] = {escalera1, escalera2};
        
        Casilla casillas[][] = new Casilla[10][10];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();  
            }
        }
        casillas[5][5].setSorpresa(true);
        casillas[2][2].setSorpresa(true);
        casillas[7][7].setSorpresa(true);
        casillas[6][1].setSorpresa(true);
        casillas[3][8].setSorpresa(true);
        
        Tablero tablero = new Tablero(casillas,e1,s1);
        
        Ficha fichaJugador1 = new Ficha("Perro","Roja");        
        Jugador jugador1 = new Jugador(1, "Cristian", fichaJugador1); 
        int[] posicionJugador1 = {9,5};
        jugador1.setPosicion(posicionJugador1);
        UI.imprimirTablero(tablero, jugador1.getPosicion());
    }

}
