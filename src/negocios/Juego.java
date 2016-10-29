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

    public Juego(Tipo tipo, Jugador[] jugadores, Dado dado) {
        this.tipo = tipo;
        this.jugadores = jugadores;
        this.dado = dado;
    }

    public static Tipo crearTipo1() {
        int a[] = {2, 6};
        int b[] = {6, 8};
        Serpiente serpiente1 = new Serpiente(a, b);

        int aa[] = {0, 1};
        int bb[] = {5, 0};
        Serpiente serpiente2 = new Serpiente(aa, bb);

        Serpiente s1[] = {serpiente1, serpiente2};

        int c[] = {9, 2};
        int d[] = {4, 3};
        Escalera escalera1 = new Escalera(c, d);

        int cc[] = {4, 9};
        int dd[] = {1, 8};
        Escalera escalera2 = new Escalera(cc, dd);

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

        Tablero tablero = new Tablero(casillas, e1, s1);

        Tipo tipo1 = new Tipo(100, tablero, false, 5, e1.length, s1.length, false);
        return tipo1;
    }

    public static Jugador crearJugador(int id, String nombre, String color) {
        Ficha fichaJugador = new Ficha(color);
        Jugador jugador = new Jugador(id, nombre, fichaJugador);
        return jugador;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tipo tipo1 = crearTipo1();
        Jugador jugador1 = crearJugador(1, "Cristian", "rojo");
        Jugador jugador2 = crearJugador(2, "Brian", "azul");
        Jugador jugador3 = crearJugador(3, "Jhon", "verde");
        Jugador jugador4 = crearJugador(4, "Brayan", "amarillo");
        Jugador jugadores[] = {jugador1, jugador2, jugador3, jugador4};
        Dado dado = new Dado("rojo");
        
        Juego juego = new Juego(tipo1,jugadores,dado);

        int[] posicionJugador1 = {9, 3};
        jugador1.setPosicion(posicionJugador1);
        int[] posicionJugador2 = {2, 3};
        jugador2.setPosicion(posicionJugador2);
        int[] posicionJugador3 = {8, 3};
        jugador3.setPosicion(posicionJugador3);
        int[] posicionJugador4 = {6, 3};
        jugador4.setPosicion(posicionJugador4);

        UI.imprimirTablero(tipo1.getTablero(), jugadores);
    }

}
