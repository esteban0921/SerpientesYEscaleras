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
public class Dado {
    private String color;
    private int numeroObtenido;

    public Dado(String color, int numeroObtenido) {
        this.color = color;
        this.numeroObtenido = numeroObtenido;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroObtenido() {
        return numeroObtenido;
    }
    
    public void lanzarDado(){
        Random  azar = new Random();
        this.numeroObtenido = (int)(azar.nextDouble() * 6 + 1);
    }  
}