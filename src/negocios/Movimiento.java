/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.*;
import javax.swing.JOptionPane;
import presentacion.UI;
import presentacion.UIGrafica;

/**
 *
 * @author LENOVO
 */
public class Movimiento {

    public static boolean esGanador(Jugador jugador) {
        if ((jugador.getPosicion()[0] == 0) && (jugador.getPosicion()[1] == 0)) {
            UI.mensaje(1, jugador.getNombre());
            return true;
        } else {
            return false;
        }
    }

    public static void comprobarCaminoYMover(Camino[] camino, Jugador jugador) {
        for (int i = 0; i < camino.length; i++) {
            if ((camino[i].getCasillaInicio()[0] == jugador.getPosicion()[0]) && (camino[i].getCasillaInicio()[1] == jugador.getPosicion()[1])) {
                jugador.setPosicion(camino[i].getCasillaFinal());
                if ((camino[i].getCasillaInicio()[0]) > (camino[i].getCasillaFinal()[0])) {
                    UI.mensaje(6, "escalera");
                } else {
                    UI.mensaje(6, "serpiente");
                }
            }
        }
    }

    public static int comprobarSorpresa(Casilla[][] casilla, Jugador jugador) { //Si cayó al metodo, llevar al metodo obtener sorpresa
        int caso = 0; // {tipo, avance fila, avance columna}
        int n = 0;
        int mover[] = new int[2];
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla.length; j++) {
                if ((casilla[i][j].isSorpresa() == true) && (jugador.getPosicion()[0] == i) && (jugador.getPosicion()[1] == j)) {
                    caso = casilla[i][j].generarSorpresa();
                    mover[0] = i;
                    switch (caso) {
                        case 1: //Avanza 1
                            UI.mensaje(2, "1");
                            if (i % 2 == 0) { // Su avance de casilla es el retroceso de la columna de la matriz
                                jugador.setSentido(-1);
                                mover[1] = j - 1;
                                n = -1;
                                UIGrafica.cambiarDirecciones(-n, 0, 0);
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                    UIGrafica.cambiarDirecciones(((-n - mover[1]) - 1), mover[1], 1);
                                }
                            } else {
                                jugador.setSentido(1);
                                mover[1] = j + 1;
                                n = 1;
                                UIGrafica.cambiarDirecciones(0, n, 0);
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                    UIGrafica.cambiarDirecciones((casilla.length - mover[1]) - 1, n - (casilla.length - mover[1]), 1);
                                }
                            }
                            break;
                        case 2: //Avanza 2
                            UI.mensaje(2, "2");
                            if (i % 2 == 0) { // Su avance de casilla es el retroceso de la columna de la matriz
                                jugador.setSentido(-1);
                                mover[1] = j - 2;
                                n = -2;
                                UIGrafica.cambiarDirecciones(-n, 0, 0);
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                    UIGrafica.cambiarDirecciones(((-n - mover[1]) - 1), mover[1], 1);
                                }
                            } else {
                                jugador.setSentido(1);
                                mover[1] = j + 2;
                                n = 2;
                                UIGrafica.cambiarDirecciones(0, n, 0);
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                    UIGrafica.cambiarDirecciones((casilla.length - mover[1]) - 1, n - (casilla.length - mover[1]), 1);
                                }
                            }
                            break;
                        case 3: //Retrocede 1
                            UI.mensaje(2, "3");
                            if (i % 2 == 0) { // Su retroceso de casilla es el avance de la columna de la matriz
                                jugador.setSentido(1);
                                mover[1] = j + 1;
                                n = 1;
                                UIGrafica.cambiarDirecciones(0, n, 0);
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                    UIGrafica.cambiarDirecciones((casilla.length - mover[1]) - 1, n - (casilla.length - mover[1]), 1);
                                }
                            } else {
                                jugador.setSentido(-1);
                                mover[1] = j - 1;
                                n = -1;
                                UIGrafica.cambiarDirecciones(-n, 0, 0);
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                    UIGrafica.cambiarDirecciones(((-n - mover[1]) - 1), mover[1], 1);
                                }
                            }
                            break;
                        case 4: //Retrocede 2
                            UI.mensaje(2, "4");
                            if (i % 2 == 0) { // Su retroceso de casilla es el avance de la columna de la matriz
                                jugador.setSentido(1);
                                mover[1] = j + 2;
                                n = 2;
                                UIGrafica.cambiarDirecciones(0, n, 0);
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                    UIGrafica.cambiarDirecciones((casilla.length - mover[1]) - 1, n - (casilla.length - mover[1]), 1);
                                }
                            } else {
                                jugador.setSentido(-1);
                                mover[1] = j - 2;
                                n = -2;
                                UIGrafica.cambiarDirecciones(-n, 0, 0);
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                    UIGrafica.cambiarDirecciones(((-n - mover[1]) - 1), mover[1], 1);
                                }
                            }
                            break;
                    }
                    jugador.setPosicion(mover);
                }
            }
        }
        return caso;
    }

    public static void moverFicha(Casilla[][] tablero, Jugador jugador, Dado dado) {
        //dado.OprimirTecla(jugador);
        dado.lanzarDado();
        int numeroObtenido = dado.getNumeroObtenido();
        // UI.mensaje(3, String.valueOf(numeroObtenido));
        int mover[] = new int[2];
        mover[0] = jugador.getPosicion()[0];

        if (jugador.getPosicion()[0] % 2 == 0) { // Su avance de casilla es el retroceso de la columna de la matriz
            jugador.setSentido(-1);
            mover[1] = jugador.getPosicion()[1] - numeroObtenido;
            UIGrafica.cambiarDirecciones(numeroObtenido, 0, 0);
            if (mover[1] < 0) {
                mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                mover[1] = (-1 * mover[1]) - 1;
                UIGrafica.cambiarDirecciones(((numeroObtenido - mover[1]) - 1), mover[1], 1);
                if (mover[0] < 0) {
                    UI.mensaje(4, "salir");
                    JOptionPane.showMessageDialog(null, "Te saliste del tablero, perdiste turno.");
                    mover[0] = jugador.getPosicion()[0];
                    mover[1] = jugador.getPosicion()[1];
                    UIGrafica.cambiarDirecciones(0,0,0);
                }
            }
        } else {
            jugador.setSentido(1);
            mover[1] = jugador.getPosicion()[1] + numeroObtenido;
            UIGrafica.cambiarDirecciones(0, numeroObtenido, 0);
            if (mover[1] >= tablero.length) { // Su avance de casilla es el avance de la columna de la matriz
                mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                mover[1] = (2 * tablero.length) - (mover[1] + 1);
                UIGrafica.cambiarDirecciones((tablero.length - mover[1]) - 1, numeroObtenido - (tablero.length - mover[1]), 1);
            }
        }
        System.out.println(jugador.getSentido());
        jugador.setPosicion(mover);
    }

    public static void moverFicha(Casilla[][] tablero, Jugador jugador, int numeroAleatorio) {
        int numeroObtenido = numeroAleatorio;
        UI.mensaje(3, String.valueOf(numeroObtenido));
        int mover[] = new int[2];
        mover[0] = jugador.getPosicion()[0];

        if (jugador.getPosicion()[0] % 2 == 0) { // Su avance de casilla es el retroceso de la columna de la matriz (izquierda)
            mover[1] = jugador.getPosicion()[1] - numeroObtenido;
            if (mover[1] < 0) {
                mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                mover[1] = (-1 * mover[1]) - 1;
                if (mover[0] < 0) {
                    UI.mensaje(4, "salir");
                    mover[0] = jugador.getPosicion()[0];
                    mover[1] = jugador.getPosicion()[1];
                }
            }
        } else {// Su avance de casilla es el avance de la columna de la matriz
            mover[1] = jugador.getPosicion()[1] + numeroObtenido;
            if (mover[1] >= tablero.length) {
                mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                mover[1] = (2 * tablero.length) - (mover[1] + 1);
            }
        }
        jugador.setPosicion(mover);
    }
}
