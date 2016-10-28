/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author LENOVO
 */
public class Tipo {
    private int tamañoTablero;
    private Tablero tablero;
    private boolean unJugador;
    private int numeroCasillasSorpresa;
    private int numeroEscaleras;
    private int numeroSerpientes;
    private boolean fantasmas;
    
    public Tipo (int tamañoTablero, Tablero tablero, boolean unJugador, int numeroCasillasSorpresa, int numeroEscaleras, int numeroSerpientes, boolean fantasmas){
        this.tamañoTablero = tamañoTablero;
        this.tablero = tablero;
        this.unJugador = unJugador;
        this.numeroCasillasSorpresa = numeroCasillasSorpresa;
        this.numeroEscaleras = numeroEscaleras;
        this.numeroSerpientes = numeroSerpientes;
        this.fantasmas = fantasmas;
    }

    public int getTamañoTablero() {
        return tamañoTablero;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public boolean isUnJugador() {
        return unJugador;
    }

    public int getNumeroCasillasSorpresa() {
        return numeroCasillasSorpresa;
    }

    public int getNumeroEscaleras() {
        return numeroEscaleras;
    }

    public int getNumeroSerpientes() {
        return numeroSerpientes;
    }

    public boolean isFantasmas() {
        return fantasmas;
    }
    
    
    
    
    
}
