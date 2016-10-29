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
}
