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
public class Jugador {

    private int id;
    private String nombre;
    private Ficha ficha;
    private int posicion[] = new int[2];

    public Jugador(int id, String nombre, Ficha ficha) {
        this.id = id;
        this.nombre = nombre;
        this.ficha = ficha;
        int[] pocision = {10, 10};
        this.posicion = pocision;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Ficha getFicha() {
        return ficha;
    }
    
    public void setPosicion(int[] posicion){
        this.posicion = posicion;
    }
    
    public int[] getPosicion() {
        return posicion;
    }
}
