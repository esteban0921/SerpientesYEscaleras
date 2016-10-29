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
public class Camino {
    private int casillaInicio[] = new int[2];
    private int casillaFinal[] = new int[2];
    
    
    public Camino(int[] casillaInicio, int[] casillaFinal){ // fila - columna, fila - columna
        this.casillaInicio = casillaInicio;
        this.casillaFinal = casillaFinal;
    }

    public int[] getCasillaInicio() {
        return casillaInicio;
    }

    public int[] getCasillaFinal() {
        return casillaFinal;
    }
}
