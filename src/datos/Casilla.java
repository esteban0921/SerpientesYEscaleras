/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class Casilla {
    private boolean sorpresa;

    public Casilla() {
        this.sorpresa = false;
    }

    public void setSorpresa(boolean sorpresa) {
        this.sorpresa = sorpresa;
    }

    public boolean isSorpresa() {
        return sorpresa;
    }
    
    public int generarSorpresa(){
        Random azar = new Random();
        int caso;
        caso = (int) (azar.nextDouble() * 4 + 1); //Retroceder 1, avanzar 1, retroceder 2, avanzar 2;
        return caso;
    }
}
