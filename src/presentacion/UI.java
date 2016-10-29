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

    public static void imprimirTablero(Tablero tablero, Jugador jugadores[]) {
        Casilla c[][] = tablero.getCasillas();
        Escalera e[] = tablero.getEscaleras();
        boolean hayEscalera = false;
        Serpiente s[] = tablero.getSerpientes();
        boolean haySerpiente = false;

        boolean jugador1 = false;
        boolean jugador2 = false;
        boolean jugador3 = false;
        boolean jugador4 = false;

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
                    
                    for (int l = 0; l < jugadores.length; l++) {
                        int pocision[] = jugadores[l].getPosicion();
                        if ((pocision[0] == i) && (pocision[1] == j)) {
                            if(l==0){
                                jugador1 = true;
                            }
                            if(l==1){
                                jugador2 = true;
                            }
                            if(l==2){
                                jugador3 = true;
                            }
                            if(l==3){
                                jugador4 = true;
                            }
                        }
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
                
                if (jugador2) {
                    impresion = "J2";
                    jugador2 = false;
                }
                
                if (jugador3) {
                    impresion = "J3";
                    jugador3 = false;
                }
                
                if (jugador4) {
                    impresion = "J4";
                    jugador4 = false;
                }
                System.out.print(impresion + "\t");
            }
            System.out.println("");
        }
    }
}
