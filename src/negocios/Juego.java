/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import datos.*;
import java.util.Random;
import presentacion.UI;

/**
 *
 * @author LENOVO
 */
public class Juego {

    private Tipo tipo;
    private ArrayList<Jugador> jugadores;
    private Dado dado;

    public Juego(Tipo tipo, ArrayList<Jugador> jugadores, Dado dado) {
        this.tipo = tipo;
        this.jugadores = jugadores;
        this.dado = dado;
    }

    public static Tipo crearTipo1() { //8x8
        int casillaInicioS1[] = {5, 5};
        int casillaFinalS1[] = {7, 3};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int casillaInicioS2[] = {3, 0};
        int casillaFinalS2[] = {5, 0};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        int casillaInicioS3[] = {3, 5};
        int casillaFinalS3[] = {5, 7};
        Serpiente serpiente3 = new Serpiente(casillaInicioS3, casillaFinalS3);

        int casillaInicioS4[] = {2, 4};
        int casillaFinalS4[] = {5, 3};
        Serpiente serpiente4 = new Serpiente(casillaInicioS4, casillaFinalS4);

        int casillaInicioS5[] = {0, 2};
        int casillaFinalS5[] = {4, 2};
        Serpiente serpiente5 = new Serpiente(casillaInicioS5, casillaFinalS5);

        int casillaInicioS6[] = {1, 5};
        int casillaFinalS6[] = {3, 6};
        Serpiente serpiente6 = new Serpiente(casillaInicioS6, casillaFinalS6);

        Serpiente serpientes[] = {serpiente1, serpiente2, serpiente3, serpiente4, serpiente5, serpiente6};

        int casillaInicioE1[] = {7, 2};
        int casillaFinalE1[] = {6, 0};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {7, 6};
        int casillaFinalE2[] = {5, 6};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        int casillaInicioE3[] = {6, 3};
        int casillaFinalE3[] = {3, 1};
        Escalera escalera3 = new Escalera(casillaInicioE3, casillaFinalE3);

        int casillaInicioE4[] = {4, 4};
        int casillaFinalE4[] = {2, 2};
        Escalera escalera4 = new Escalera(casillaInicioE4, casillaFinalE4);

        int casillaInicioE5[] = {2, 6};
        int casillaFinalE5[] = {0, 7};
        Escalera escalera5 = new Escalera(casillaInicioE5, casillaFinalE5);

        int casillaInicioE6[] = {1, 3};
        int casillaFinalE6[] = {0, 5};
        Escalera escalera6 = new Escalera(casillaInicioE6, casillaFinalE6);

        Escalera escaleras[] = {escalera1, escalera2, escalera3, escalera4, escalera5, escalera6};

        Casilla casillas[][] = new Casilla[8][8];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[7][5].setSorpresa(true);
        casillas[5][1].setSorpresa(true);
        casillas[3][7].setSorpresa(true);
        casillas[0][4].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo2 = new Tipo(64, tablero, false, 4, escaleras.length, serpientes.length, false);
        return tipo2;
    }

    public static Tipo crearTipo2() { //10x10
        int casillaInicioS1[] = {8, 4};
        int casillaFinalS1[] = {9, 7};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int casillaInicioS2[] = {4, 2};
        int casillaFinalS2[] = {8, 2};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        int casillaInicioS3[] = {5, 6};
        int casillaFinalS3[] = {7, 5};
        Serpiente serpiente3 = new Serpiente(casillaInicioS3, casillaFinalS3);

        int casillaInicioS4[] = {3, 8};
        int casillaFinalS4[] = {6, 9};
        Serpiente serpiente4 = new Serpiente(casillaInicioS4, casillaFinalS4);

        int casillaInicioS5[] = {0, 7};
        int casillaFinalS5[] = {3, 6};
        Serpiente serpiente5 = new Serpiente(casillaInicioS5, casillaFinalS5);

        int casillaInicioS6[] = {1, 6};
        int casillaFinalS6[] = {5, 3};
        Serpiente serpiente6 = new Serpiente(casillaInicioS6, casillaFinalS6);

        int casillaInicioS7[] = {0, 1};
        int casillaFinalS7[] = {3, 2};
        Serpiente serpiente7 = new Serpiente(casillaInicioS7, casillaFinalS7);

        int casillaInicioS8[] = {0, 3};
        int casillaFinalS8[] = {2, 2};
        Serpiente serpiente8 = new Serpiente(casillaInicioS8, casillaFinalS8);

        Serpiente serpientes[] = {serpiente1, serpiente2, serpiente3, serpiente4, serpiente5, serpiente6, serpiente7, serpiente8};

        int casillaInicioE1[] = {9, 2};
        int casillaFinalE1[] = {7, 3};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {9, 8};
        int casillaFinalE2[] = {5, 9};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        int casillaInicioE3[] = {8, 1};
        int casillaFinalE3[] = {6, 0};
        Escalera escalera3 = new Escalera(casillaInicioE3, casillaFinalE3);

        int casillaInicioE4[] = {6, 3};
        int casillaFinalE4[] = {5, 1};
        Escalera escalera4 = new Escalera(casillaInicioE4, casillaFinalE4);

        int casillaInicioE5[] = {7, 7};
        int casillaFinalE5[] = {3, 3};
        Escalera escalera5 = new Escalera(casillaInicioE5, casillaFinalE5);

        int casillaInicioE6[] = {4, 6};
        int casillaFinalE6[] = {0, 8};
        Escalera escalera6 = new Escalera(casillaInicioE6, casillaFinalE6);

        int casillaInicioE7[] = {3, 0};
        int casillaFinalE7[] = {1, 1};
        Escalera escalera7 = new Escalera(casillaInicioE7, casillaFinalE7);

        int casillaInicioE8[] = {2, 4};
        int casillaFinalE8[] = {0, 5};
        Escalera escalera8 = new Escalera(casillaInicioE8, casillaFinalE8);

        Escalera escaleras[] = {escalera1, escalera2, escalera3, escalera4, escalera5, escalera6, escalera7, escalera8};

        Casilla casillas[][] = new Casilla[10][10];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[9][3].setSorpresa(true);
        casillas[6][4].setSorpresa(true);
        casillas[4][0].setSorpresa(true);
        casillas[3][9].setSorpresa(true);
        casillas[0][4].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo1 = new Tipo(100, tablero, false, 5, escaleras.length, serpientes.length, false);
        return tipo1;
    }

    public static Tipo crearTipo3() { //12*12
        int[] casillaInicioS1 = {9, 5};
        int[] casillaFinalS1 = {11, 2};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int[] casillaInicioS2 = {6, 2};
        int casillaFinalS2[] = {10, 0};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        int[] casillaInicioS3 = {7, 9};
        int casillaFinalS3[] = {10, 9};
        Serpiente serpiente3 = new Serpiente(casillaInicioS3, casillaFinalS3);

        int[] casillaInicioS4 = {4, 8};
        int[] casillaFinalS4 = {8, 6};
        Serpiente serpiente4 = new Serpiente(casillaInicioS4, casillaFinalS4);

        int[] casillaInicioS5 = {2, 7};
        int casillaFinalS5[] = {8, 3};
        Serpiente serpiente5 = new Serpiente(casillaInicioS5, casillaFinalS5);

        int[] casillaInicioS6 = {1, 9};
        int casillaFinalS6[] = {4, 9};
        Serpiente serpiente6 = new Serpiente(casillaInicioS6, casillaFinalS6);

        int[] casillaInicioS7 = {3, 1};
        int[] casillaFinalS7 = {5, 2};
        Serpiente serpiente7 = new Serpiente(casillaInicioS7, casillaFinalS7);

        int[] casillaInicioS8 = {0, 2};
        int casillaFinalS8[] = {4, 0};
        Serpiente serpiente8 = new Serpiente(casillaInicioS8, casillaFinalS8);

        int[] casillaInicioS9 = {0, 3};
        int casillaFinalS9[] = {2, 2};
        Serpiente serpiente9 = new Serpiente(casillaInicioS9, casillaFinalS9);

        Serpiente serpientes[] = {serpiente1, serpiente2, serpiente3, serpiente4, serpiente5, serpiente6, serpiente7, serpiente8, serpiente9};

        int casillaInicioE1[] = {11, 3};
        int casillaFinalE1[] = {7, 4};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {6, 8};
        int casillaFinalE2[] = {1, 5};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        int casillaInicioE3[] = {3, 11};
        int casillaFinalE3[] = {0, 10};
        Escalera escalera3 = new Escalera(casillaInicioE3, casillaFinalE3);

        int casillaInicioE4[] = {11, 3};
        int casillaFinalE4[] = {7, 4};
        Escalera escalera4 = new Escalera(casillaInicioE4, casillaFinalE4);

        int casillaInicioE5[] = {6, 8};
        int casillaFinalE5[] = {1, 5};
        Escalera escalera5 = new Escalera(casillaInicioE5, casillaFinalE5);

        int casillaInicioE6[] = {3, 11};
        int casillaFinalE6[] = {0, 10};
        Escalera escalera6 = new Escalera(casillaInicioE6, casillaFinalE6);

        int casillaInicioE7[] = {11, 3};
        int casillaFinalE7[] = {7, 4};
        Escalera escalera7 = new Escalera(casillaInicioE7, casillaFinalE7);

        int casillaInicioE8[] = {6, 8};
        int casillaFinalE8[] = {1, 5};
        Escalera escalera8 = new Escalera(casillaInicioE8, casillaFinalE8);

        int casillaInicioE9[] = {3, 11};
        int casillaFinalE9[] = {0, 10};
        Escalera escalera9 = new Escalera(casillaInicioE9, casillaFinalE9);

        Escalera escaleras[] = {escalera1, escalera2, escalera3, escalera4, escalera5, escalera6, escalera7, escalera8, escalera9};

        Casilla casillas[][] = new Casilla[12][12];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[11][9].setSorpresa(true);
        casillas[9][3].setSorpresa(true);
        casillas[7][3].setSorpresa(true);
        casillas[5][1].setSorpresa(true);
        casillas[5][9].setSorpresa(true);
        casillas[4][6].setSorpresa(true);
        casillas[1][7].setSorpresa(true);
        casillas[0][4].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo3 = new Tipo(144, tablero, false, 8, escaleras.length, serpientes.length, false);
        return tipo3;
    }

    public static Jugador crearJugador(int id, String nombre, String color) {
        Ficha fichaJugador = new Ficha(color);
        Jugador jugador = new Jugador(id, nombre, fichaJugador);
        return jugador;
    }

    public static boolean MovimientoYComprobar(Tipo tipo, Jugador jugador, Dado dado) {
        Movimiento.moverFicha(tipo.getTablero().getCasillas(), jugador, dado);
        Movimiento.comprobarEscalera(tipo.getTablero().getEscaleras(), jugador);
        Movimiento.comprobarSerpiente(tipo.getTablero().getSerpientes(), jugador);
        Movimiento.comprobarSorpresa(tipo.getTablero().getCasillas(), jugador);
        return Movimiento.esGanador(jugador);
    }

    public static Jugador[] crearFantasmas(int tamanoTablero) { //crea los tres fantasmas
        int[] posicionJugador = {0, 0};
        Random azar = new Random();
        Jugador Fantasmas[] = new Jugador[3];
        Ficha fichaFantasma = new Ficha("gris");

        for (int i = 0; i < 3; i++) {
            switch (tamanoTablero) {
                case 64:
                    posicionJugador[0] = (int) (azar.nextDouble() * 7 + 4);
                    posicionJugador[1] = (int) (azar.nextDouble() * 7);
                    break;
                case 100:
                    posicionJugador[0] = (int) (azar.nextDouble() * 9 + 5);
                    posicionJugador[1] = (int) (azar.nextDouble() * 9);
                    break;
                case 144:
                    posicionJugador[0] = (int) (azar.nextDouble() * 11 + 6);
                    posicionJugador[1] = (int) (azar.nextDouble() * 11);
                    break;
            }
            Jugador Fantasma = new Jugador((i+2), "Fantasma " + (i+1), fichaFantasma);
            Fantasma.setPosicion(posicionJugador);
            Fantasmas[i]=Fantasma;
        }
        return Fantasmas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean jugar = true, colorRepetido = true;
        int opcion, numJugadores;
        boolean fantasma; //Donde se coloca?
        Tipo tipo;
        int[] posicionJugador = {0, 0};

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        while (jugar) {

            fantasma = false;
            opcion = 1;
            if (UI.Menu(opcion) == "2") {
                fantasma = true;
            }
            opcion++;
            switch (UI.Menu(opcion)) {
                case "1":
                    tipo = crearTipo1();
                    break;
                case "2":
                    tipo = crearTipo2();
                    break;
                default:
                    tipo = crearTipo3();
                    break;
            }
            opcion++;
            numJugadores = Integer.parseInt(UI.Menu(opcion));
            System.out.println(numJugadores);

            if (!jugadores.isEmpty()) {
                jugadores.clear();
            }

            for (int i = 0; i < numJugadores; i++) {
                jugadores.add(i, crearJugador(i + 1, UI.leerNombre(i + 1), UI.leerColorFicha()));
                if (i > 0) {
                    while (colorRepetido) {
                        if ((i == 1) && (jugadores.get(1).getFicha().getColor().equals(jugadores.get(0).getFicha().getColor()))) {
                            colorRepetido = true;
                        } else if ((i == 2) && (jugadores.get(2).getFicha().getColor().equals(jugadores.get(0).getFicha().getColor())
                                || (jugadores.get(2).getFicha().getColor().equals(jugadores.get(1).getFicha().getColor())))) {
                            colorRepetido = true;
                        } else if ((i == 3) && (jugadores.get(3).getFicha().getColor().equals(jugadores.get(0).getFicha().getColor())
                                || (jugadores.get(3).getFicha().getColor().equals(jugadores.get(1).getFicha().getColor()))
                                || (jugadores.get(3).getFicha().getColor().equals(jugadores.get(2).getFicha().getColor())))) {
                            colorRepetido = true;
                        } else {
                            colorRepetido = false;
                        }
                        if (colorRepetido == true) {
                            UI.error();
                            jugadores.get(i).getFicha().setColor(UI.leerColorFicha());
                        }
                    }
                    colorRepetido = true;
                }
            }

            Dado dado = new Dado(UI.leerColorDado());

            //Juego juego = new Juego(tipo, jugadores, dado); //Por lo visto no sirve de nada
            switch (tipo.getTamanoTablero()) {
                case 64:
                    posicionJugador[0] = 7;
                    break;
                case 100:
                    posicionJugador[0] = 9;
                    break;
                case 144:
                    posicionJugador[0] = 11;
                    break;
            }
            posicionJugador[1] = -1;

            for (int i = 0; i < jugadores.size(); i++) {
                jugadores.get(i).setPosicion(posicionJugador);
            }

            Turno.setNumeroDeJugadores(numJugadores);

            boolean JuegoTerminado = false;
            while (!JuegoTerminado) {
                switch (Turno.getTurnoDe()) {
                    case 1:
                        JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(0), dado);
                        Turno.CambiarTurno();
                        break;
                    case 2:
                        JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(1), dado);
                        Turno.CambiarTurno();
                        break;
                    case 3:
                        JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(2), dado);
                        Turno.CambiarTurno();
                        break;
                    case 4:
                        JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(3), dado);
                        Turno.CambiarTurno();
                        break;
                    default:
                        //System.out.println("No hay m�s turnos"); //Se supone que jam�s sera diferente de estos valores.
                        break;
                }
                UI.imprimirTablero(tipo.getTablero(), jugadores);
            }

            jugar = (UI.terminar());

        }
    }
}
