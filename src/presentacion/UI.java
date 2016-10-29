/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.*;

/**
 *
 * @author LENOVO
 */
public class UI {

    public static void imprimirTablero(Tablero tablero, int[] posicionJugador1) {
        Casilla c[][] = tablero.getCasillas();
        Escalera e[] = tablero.getEscaleras();
        boolean hayEscalera = false;
        Serpiente s[] = tablero.getSerpientes();
        boolean haySerpiente = false;

        boolean jugador1 = false;

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[1].length; j++) {

                for (int k = 0; k < e.length; k++) {
                    if ((e[k].getCasillaInicio()[0] == i) && (e[k].getCasillaInicio()[1] == j)) {
                        hayEscalera = true;
                    }

                    if ((e[k].getCasillaFinal()[0] == i) && (e[k].getCasillaFinal()[1] == j)) {
                        hayEscalera = true;
                    }

                    if ((s[k].getCasillaInicio()[0] == i) && (s[k].getCasillaInicio()[1] == j)) {
                        haySerpiente = true;
                    }

                    if ((s[k].getCasillaFinal()[0] == i) && (s[k].getCasillaFinal()[1] == j)) {
                        haySerpiente = true;
                    }

                    if ((posicionJugador1[0] == i) && (posicionJugador1[1] == j)) {
                        jugador1 = true;
                    }
                }

                String impresion;
                if (c[i][j].isSorpresa()) {
                    impresion = "?";
                } else if (hayEscalera) {
                    impresion = "E";
                    hayEscalera = false;
                } else if (haySerpiente) {
                    impresion = "S";
                    haySerpiente = false;
                } else {
                    impresion = "-";
                }
                if (jugador1) {
                    impresion = "J1";
                    jugador1 = false;
                }
                System.out.print(impresion + "\t");
            }
            System.out.println("");
        }
    }
}
