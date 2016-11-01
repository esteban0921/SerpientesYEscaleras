/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.*;

/**
 *
 * @author LENOVO
 */
public class Movimiento {

    public static boolean esGanador(Jugador jugador) {
        if ((jugador.getPosicion()[0] == 0) && (jugador.getPosicion()[1] == 0)) {
            System.out.println("Has Ganado el juego " + jugador.getNombre() + "... Felicitaciones!");
            return true;
        } else {
            return false;
        }
    }

    public static void comprobarEscalera(Escalera[] escaleras, Jugador jugador) {
        for (int i = 0; i < escaleras.length; i++) {
            if ((escaleras[i].getCasillaInicio()[0] == jugador.getPosicion()[0]) && (escaleras[i].getCasillaInicio()[1] == jugador.getPosicion()[1])) {
                jugador.setPosicion(escaleras[i].getCasillaFinal());
            }
        }
    }

    public static void comprobarSerpiente(Serpiente[] serpientes, Jugador jugador) {
        for (int i = 0; i < serpientes.length; i++) {
            if ((serpientes[i].getCasillaInicio()[0] == jugador.getPosicion()[0]) && (serpientes[i].getCasillaInicio()[1] == jugador.getPosicion()[1])) {
                jugador.setPosicion(serpientes[i].getCasillaFinal());
            }
        }
    }

    public static void comprobarSorpresa(Casilla[][] casilla, Jugador jugador) { //Si cayó al metodo, llevar al metodo obtener sorpresa
        int caso; // {tipo, avance fila, avance columna}
        int mover[] = new int[2];
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla.length; j++) {
                if ((casilla[i][j].isSorpresa() == true) && (jugador.getPosicion()[0] == i) && (jugador.getPosicion()[1] == j)) {
                    caso = casilla[i][j].generarSorpresa();
                    mover[0] = i;
                    switch (caso) {
                        case 1: //Avanza 1
                            System.out.println("Casilla Sorpresa ¿¿??: Avanza una casilla");
                            if (i % 2 == 0) { // Su avance de casilla es el retroceso de la columna de la matriz
                                mover[1] = j - 1;
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                }
                            } else {
                                mover[1] = j + 1;
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                }
                            }
                            break;
                        case 2: //Avanza 2
                            System.out.println("Casilla Sorpresa ¿¿??: Avanza dos casilla");
                            if (i % 2 == 0) { // Su avance de casilla es el retroceso de la columna de la matriz
                                mover[1] = j - 2;
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                }
                            } else {
                                mover[1] = j + 2;
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                }
                            }
                            break;
                        case 3: //Retrocede 1
                            System.out.println("Casilla Sorpresa ¿¿??: Retrocede una casilla");
                            if (i % 2 == 0) { // Su retroceso de casilla es el avance de la columna de la matriz
                                mover[1] = j + 1;
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                }
                            } else {
                                mover[1] = j - 1;
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                }
                            }
                            break;
                        case 4: //Retrocede 2
                            System.out.println("Casilla Sorpresa ¿¿??: Retrocede dos casilla");
                            if (i % 2 == 0) { // Su retroceso de casilla es el avance de la columna de la matriz
                                mover[1] = j + 2;
                                if (mover[1] >= casilla.length) { // Su avance de casilla es el avance de la columna de la matriz
                                    mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                                    mover[1] = (2 * casilla.length) - (mover[1] + 1);
                                }
                            } else {
                                mover[1] = j - 2;
                                if (mover[1] < 0) {
                                    mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                                    mover[1] = (-1 * mover[1]) - 1;
                                }
                            }
                            break;
                    }
                    jugador.setPosicion(mover);
                }
            }
        }
    }

    public static void moverFicha(Casilla[][] tablero, Jugador jugador, Dado dado) {
        dado.OprimirTecla(jugador);
        int numeroObtenido = dado.getNumeroObtenido();
        System.out.println("Numero obtenido: " + numeroObtenido);
        int mover[] = new int[2];
        mover[0] = jugador.getPosicion()[0];

        if (jugador.getPosicion()[0] % 2 == 0) { // Su avance de casilla es el retroceso de la columna de la matriz
            mover[1] = jugador.getPosicion()[1] - numeroObtenido;
            if (mover[1] < 0) {
                mover[0]--; //Teniendo en cuenta que para subir de fila el tablero se debe disminuir la coordenada fila del arreglo.
                mover[1] = (-1 * mover[1]) - 1;
                if(mover[0]<0){
                    System.out.println("Te saliste del tablero, perdiste turno");
                    mover[0] = jugador.getPosicion()[0];
                    mover[1] = jugador.getPosicion()[1];
                }
            }
        } else {
            mover[1] = jugador.getPosicion()[1] + numeroObtenido;
            if (mover[1] >= tablero.length) { // Su avance de casilla es el avance de la columna de la matriz
                mover[0]--; //Para evitar una excepción, se debe evitar que la sorpresa esté en las tres ultimas casillas del tablero
                mover[1] = (2 * tablero.length) - (mover[1] + 1);
            }
        }
        jugador.setPosicion(mover);
    }
}
