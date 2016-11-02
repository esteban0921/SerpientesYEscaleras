/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import datos.*;
import presentacion.UI;

/**
 *
 * @author LENOVO
 */
public class Juego {

    private Tipo tipo;
    private ArrayList <Jugador> jugadores;
    private Dado dado;

    public Juego(Tipo tipo, ArrayList <Jugador> jugadores, Dado dado) {
        this.tipo = tipo;
        this.jugadores = jugadores;
        this.dado = dado;
    }

    public static Tipo crearTipo1() { //8x8
        int casillaInicioS1[] = {0, 1};
        int casillaFinalS1[] = {2, 3};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int casillaInicioS2[] = {4, 3};
        int casillaFinalS2[] = {6, 5};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        Serpiente serpientes[] = {serpiente1, serpiente2};

        int casillaInicioE1[] = {7, 1};
        int casillaFinalE1[] = {4, 0};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {4, 6};
        int casillaFinalE2[] = {0, 7};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        Escalera escaleras[] = {escalera1, escalera2};

        Casilla casillas[][] = new Casilla[8][8];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[1][1].setSorpresa(true);
        casillas[2][5].setSorpresa(true);
        casillas[3][3].setSorpresa(true);
        casillas[5][5].setSorpresa(true);
        casillas[7][3].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo2 = new Tipo(64, tablero, false, 5, escaleras.length, serpientes.length, false);
        return tipo2;
    }
    
    public static Tipo crearTipo2() { //10x10
        int casillaInicioS1[] = {2, 6};
        int casillaFinalS1[] = {6, 8};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int casillaInicioS2[] = {0, 1};
        int casillaFinalS2[] = {5, 0};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        Serpiente serpientes[] = {serpiente1, serpiente2};

        int casillaInicioE1[] = {9, 2};
        int casillaFinalE1[] = {4, 3};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {4, 9};
        int casillaFinalE2[] = {1, 8};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        Escalera escaleras[] = {escalera1, escalera2};

        Casilla casillas[][] = new Casilla[10][10];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[5][5].setSorpresa(true);
        casillas[2][2].setSorpresa(true);
        casillas[7][7].setSorpresa(true);
        casillas[6][1].setSorpresa(true);
        casillas[3][8].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo1 = new Tipo(100, tablero, false, 5, escaleras.length, serpientes.length, false);
        return tipo1;
    }

    public static Tipo crearTipo3() { //12*12
        int[] casillaInicioS1 = {0, 2};
        int[] casillaFinalS1 = {4, 0};
        Serpiente serpiente1 = new Serpiente(casillaInicioS1, casillaFinalS1);

        int[] casillaInicioS2 = {7, 11};
        int casillaFinalS2[] = {11, 8};
        Serpiente serpiente2 = new Serpiente(casillaInicioS2, casillaFinalS2);

        int[] casillaInicioS3 = {4, 5};
        int casillaFinalS3[] = {9, 7};
        Serpiente serpiente3 = new Serpiente(casillaInicioS3, casillaFinalS3);

        Serpiente serpientes[] = {serpiente1, serpiente2, serpiente3};

        int casillaInicioE1[] = {11, 3};
        int casillaFinalE1[] = {7, 4};
        Escalera escalera1 = new Escalera(casillaInicioE1, casillaFinalE1);

        int casillaInicioE2[] = {6, 8};
        int casillaFinalE2[] = {1, 5};
        Escalera escalera2 = new Escalera(casillaInicioE2, casillaFinalE2);

        int casillaInicioE3[] = {3, 11};
        int casillaFinalE3[] = {0, 10};
        Escalera escalera3 = new Escalera(casillaInicioE3, casillaFinalE3);

        Escalera escaleras[] = {escalera1, escalera2, escalera3};

        Casilla casillas[][] = new Casilla[12][12];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        casillas[2][2].setSorpresa(true);
        casillas[3][8].setSorpresa(true);
        casillas[7][2].setSorpresa(true);
        casillas[8][8].setSorpresa(true);
        casillas[11][5].setSorpresa(true);

        Tablero tablero = new Tablero(casillas, escaleras, serpientes);

        Tipo tipo3 = new Tipo(144, tablero, false, 5, escaleras.length, serpientes.length, false);
        return tipo3;
    }

    public static Jugador crearJugador(int id, String nombre, String color) {
        Ficha fichaJugador = new Ficha(color);
        Jugador jugador = new Jugador(id, nombre, fichaJugador);
        return jugador;
    }

    public static boolean MovimientoYComprobar(Tipo tipo, Jugador jugador, Dado dado) {
        Movimiento.moverFicha(tipo.getTablero().getCasillas(), jugador, dado);
        Movimiento.comprobarEscalera(tipo.getTablero().getEscaleras(), jugador);
        Movimiento.comprobarSerpiente(tipo.getTablero().getSerpientes(), jugador);
        Movimiento.comprobarSorpresa(tipo.getTablero().getCasillas(), jugador);
        return Movimiento.esGanador(jugador);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	boolean jugar = true, colorRepetido = true;
    	int opcion, numJugadores;
    	boolean fantasma; //Donde se coloca?
    	Tipo tipo;
    	int[] posicionJugador = {0, 0};
    	
    	ArrayList <Jugador> jugadores = new ArrayList<Jugador>();
    	
    	while(jugar){
    		
    		fantasma = false;
    		opcion = 1;
    		if(UI.Menu(opcion) == "2") fantasma = true;
    		opcion++;
    		switch(UI.Menu(opcion)){
    			case "1":
    				tipo = crearTipo1();
    				break;
    			case "2":
    				tipo = crearTipo2();
    				break;
    			default:
    				tipo = crearTipo3();
    				break;
    		}
    		opcion++;
    		numJugadores = Integer.parseInt(UI.Menu(opcion));
    		System.out.println(numJugadores);
    		
    		if(!jugadores.isEmpty()) jugadores.clear();
    		
    		
    		for(int i = 0; i < numJugadores; i++){
    			jugadores.add(i, crearJugador(i + 1, UI.leerNombre(i + 1), UI.leerColorFicha()));
    			if(i > 0){
    				while(colorRepetido){
    					if((i == 1) && (jugadores.get(1).getFicha().getColor().equals(jugadores.get(0).getFicha().getColor()))) colorRepetido = true;
    					else if((i == 2) && (jugadores.get(2).getFicha().getColor().equals(jugadores.get(0).getFicha().getColor())
    							|| (jugadores.get(2).getFicha().getColor().equals(jugadores.get(1).getFicha().getColor())))) colorRepetido = true;
    					else if((i == 3) && (jugadores.get(3).getFicha().getColor().equals(jugadores.get(0).getFicha().getColor())
    							|| (jugadores.get(3).getFicha().getColor().equals(jugadores.get(1).getFicha().getColor()))
    							|| (jugadores.get(3).getFicha().getColor().equals(jugadores.get(2).getFicha().getColor())))) colorRepetido = true;
    					else colorRepetido = false;
    					if(colorRepetido == true){
    						UI.error();
    						jugadores.get(i).getFicha().setColor(UI.leerColorFicha());
    					}
    				}
    				colorRepetido = true;
    			}
    		}
    		
    		Dado dado = new Dado(UI.leerColorDado());
    		
    		//Juego juego = new Juego(tipo, jugadores, dado); //Por lo visto no sirve de nada

    		switch(tipo.getTamanoTablero()){
    			case 64:
    				posicionJugador[0] = 7;
    				break;
    			case 100:
    				posicionJugador[0] = 9;
    				break;
    			case 144:
    				posicionJugador[0] = 13;
    				break;
    		}
    		posicionJugador[1] = -1;
    		
    		for (int i = 0; i < jugadores.size(); i++) {
    			jugadores.get(i).setPosicion(posicionJugador);
			}		
    		
    		Turno.setNumeroDeJugadores(numJugadores);
    		
    		boolean JuegoTerminado = false;
    		while (!JuegoTerminado) {
    			switch (Turno.getTurnoDe()) {
    			case 1:
    				JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(0), dado);
    				Turno.CambiarTurno();
    				break;
    			case 2:
    				JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(1), dado);
    				Turno.CambiarTurno();
    				break;
    			case 3:
    				JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(2), dado);
    				Turno.CambiarTurno();
    				break;
    			case 4:
    				JuegoTerminado = MovimientoYComprobar(tipo, jugadores.get(3), dado);
    				Turno.CambiarTurno();
    				break;
    			default:
    				//System.out.println("No hay más turnos"); //Se supone que jamás sera diferente de estos valores.
    				break;
    			}
    			UI.imprimirTablero(tipo.getTablero(), jugadores);
    		}
    		
    		jugar = (UI.terminar());
    		
    	}
    }
}