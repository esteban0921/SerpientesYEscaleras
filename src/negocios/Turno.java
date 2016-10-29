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

    public int numeroDeJugadores;

    private int turnoDe;

    public Turno(int turnoDe) {
        this.turnoDe = turnoDe;
    }

    public int ComprobarTurno() {
        int turno = this.turnoDe;
        turno++;
        if (turno > this.numeroDeJugadores) {
            turno = 1;
        }
        return turno;
    }

    public int getTurnoDe() {
        return turnoDe;
    }
}
