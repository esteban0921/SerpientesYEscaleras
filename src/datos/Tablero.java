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
public class Tablero {
    private Casilla casillas[][];
    private Escalera escaleras[];
    private Serpiente serpientes[];
    
    public Tablero(Casilla casilla[][], Escalera escaleras[], Serpiente serpientes[]){
        this.casillas = casilla;
        this.escaleras = escaleras;
        this.serpientes = serpientes;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public Escalera[] getEscaleras() {
        return escaleras;
    }

    public Serpiente[] getSerpientes() {
        return serpientes;
    }
    
}
