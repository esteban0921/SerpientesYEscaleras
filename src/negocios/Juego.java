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

    public static Tipo crearTipo1() { //10*10
        int casillaInicioS1[] = {2, 6};
        int casillaFinalS1[] = {6, 8};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int casillaInicioS2[] = {0, 1};
        int casillaFinalS2[] = {5, 0};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        Serpiente serpientes[] = {serpiente1, serpiente2};

        int casillaInicioE1[] = {9, 2};
        int casillaFinalE1[] = {4, 3};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {4, 9};
        int casillaFinalE2[] = {1, 8};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        Escalera escaleras[] = {escalera1, escalera2};

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

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo1 = new Tipo(100, tablero, false, 5, escaleras.length, serpientes.length, false);
        return tipo1;
    }
    
    public static Tipo crearTipo2() { //8*8
        int casillaInicioS1[] = {0, 1};
        int casillaFinalS1[] = {2, 3};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int casillaInicioS2[] = {4, 3};
        int casillaFinalS2[] = {6, 5};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        Serpiente serpientes[] = {serpiente1, serpiente2};

        int casillaInicioE1[] = {7, 1};
        int casillaFinalE1[] = {4, 0};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {4, 6};
        int casillaFinalE2[] = {0, 7};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        Escalera escaleras[] = {escalera1, escalera2};

        Casilla casillas[][] = new Casilla[8][8];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[1][1].setSorpresa(true);
        casillas[2][5].setSorpresa(true);
        casillas[3][3].setSorpresa(true);
        casillas[5][5].setSorpresa(true);
        casillas[7][3].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo2 = new Tipo(64, tablero, false, 5, escaleras.length, serpientes.length, false);
        return tipo2;
    }
    
    public static Tipo crearTipo3() { //12*12
        int[] casillaInicioS1 = {0, 2};
        int[] casillaFinalS1 = {4, 0};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int[] casillaInicioS2 = {7, 11};
        int casillaFinalS2[] = {11, 8};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);
        
        int[] casillaInicioS3 = {4, 5};
        int casillaFinalS3[] = {9, 7};
        Serpiente serpiente3 = new Serpiente(casillaInicioS3, casillaFinalS3);

        Serpiente serpientes[] = {serpiente1, serpiente2, serpiente3};

        int casillaInicioE1[] = {11, 3};
        int casillaFinalE1[] = {7, 4};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {6, 8};
        int casillaFinalE2[] = {1, 5};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        int casillaInicioE3[] = {3, 11};
        int casillaFinalE3[] = {0, 10};
        Escalera escalera3 = new Escalera(casillaInicioE3, casillaFinalE3);
        
        Escalera escaleras[] = {escalera1, escalera2, escalera3};

        Casilla casillas[][] = new Casilla[12][12];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[2][2].setSorpresa(true);
        casillas[3][8].setSorpresa(true);
        casillas[7][2].setSorpresa(true);
        casillas[8][8].setSorpresa(true);
        casillas[11][5].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo3 = new Tipo(144, tablero, false, 5, escaleras.length, serpientes.length, false);
        return tipo3;
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
        Jugador jugador1 = crearJugador(1, "Cristian", "roja");
        Jugador jugador2 = crearJugador(2, "Brian", "azul");
        Jugador jugador3 = crearJugador(3, "Jhon", "verde");
        Jugador jugador4 = crearJugador(4, "Brayan", "amarillo");
        Jugador jugadores[] = {jugador1, jugador2};
        Dado dado = new Dado("rojo");
        
        Juego juego = new Juego(tipo1,jugadores,dado);

        int[] posicionJugador1 = {9, -1};
        jugador1.setPosicion(posicionJugador1);
        int[] posicionJugador2 = {9, -1};
        jugador2.setPosicion(posicionJugador2);
        int[] posicionJugador3 = {8, 3};
        jugador3.setPosicion(posicionJugador3);
        int[] posicionJugador4 = {6, 3};
        jugador4.setPosicion(posicionJugador4);
        
        Movimiento.moverFicha(tipo1.getTablero().getCasillas(), jugador1, dado);
        Movimiento.comprobarEscalera(tipo1.getTablero().getEscaleras(), jugador1);
        Movimiento.comprobarSerpiente(tipo1.getTablero().getSerpientes(), jugador1);
        Movimiento.comprobarSorpresa(tipo1.getTablero().getCasillas(), jugador1);
        Movimiento.esGanador(jugador1);

        UI.imprimirTablero(tipo1.getTablero(), jugadores);
        
        Movimiento.moverFicha(tipo1.getTablero().getCasillas(), jugador2, dado);
        Movimiento.comprobarEscalera(tipo1.getTablero().getEscaleras(), jugador2);
        Movimiento.comprobarSerpiente(tipo1.getTablero().getSerpientes(), jugador2);
        Movimiento.comprobarSorpresa(tipo1.getTablero().getCasillas(), jugador2);
        Movimiento.esGanador(jugador2);
        
        UI.imprimirTablero(tipo1.getTablero(), jugadores);
        
        Movimiento.moverFicha(tipo1.getTablero().getCasillas(), jugador1, dado);
        Movimiento.comprobarEscalera(tipo1.getTablero().getEscaleras(), jugador1);
        Movimiento.comprobarSerpiente(tipo1.getTablero().getSerpientes(), jugador1);
        Movimiento.comprobarSorpresa(tipo1.getTablero().getCasillas(), jugador1);
        Movimiento.esGanador(jugador1);
        
        UI.imprimirTablero(tipo1.getTablero(), jugadores);
        
        Movimiento.moverFicha(tipo1.getTablero().getCasillas(), jugador2, dado);
        Movimiento.comprobarEscalera(tipo1.getTablero().getEscaleras(), jugador2);
        Movimiento.comprobarSerpiente(tipo1.getTablero().getSerpientes(), jugador2);
        Movimiento.comprobarSorpresa(tipo1.getTablero().getCasillas(), jugador2);
        Movimiento.esGanador(jugador2);
        
        UI.imprimirTablero(tipo1.getTablero(), jugadores);
    }

}
