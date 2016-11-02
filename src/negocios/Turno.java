/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

/**
 *
 * @author LENOVO
 */
public class Turno {

    static private int numeroDeJugadores;
    static private int turnoDe = 1;

    static public void CambiarTurno() {
        turnoDe++;
        if (turnoDe > numeroDeJugadores) {
            turnoDe = 1;
        }
    }

    static public int getTurnoDe() {
        return turnoDe;
    }

    public static void setNumeroDeJugadores(int numeroDeJugadores) {
        Turno.numeroDeJugadores = numeroDeJugadores;
    }
}
