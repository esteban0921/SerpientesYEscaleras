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
}
