/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.*;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class UI {

    static Scanner s = new Scanner(System.in);
    static Scanner leer = new Scanner(System.in);

    /*  
    public static String Menu(int menu){
    	String ingreso = null;
    	while(menu <= 2){
    		
    		boolean validar = true;
        	switch(menu){
        	case 1:
                System.out.println("*-*-*-* SERPIENTES Y ESCALERAS UN *-*-*-*"
                		+ "\n\nSeleccione una opci�n: "
                        + "\n1. Modo cl�sico 8 x 8."
                        + "\n2. Modo cl�sico 10 x 10."
                        + "\n3. Modo cl�sico 12 x 12."
                        + "\n4. Modo supervivencia.");
        		break;
        	case 2: 
                System.out.println("Seleccione el n�mero de jugadores (1-4): ");
        		break;
        	}
        	ingreso = s.nextLine();
        	
            for (int i = 0; i < ingreso.length(); i++) {
                if (!isNumeric(String.valueOf(ingreso.charAt(i)))) {
                    validar = false;
                    if (!validar) {
                        System.out.println("Digite un n�mero v�lido (1-4)\n");
                    }
                }
            }
    	}
    	
		return ingreso;
    }
    
     */
    public static void imprimirTablero(Tablero tablero, Jugador jugadores[]) {
        Casilla c[][] = tablero.getCasillas();
        Escalera e[] = tablero.getEscaleras();
        boolean hayEscalera = false;
        Serpiente s[] = tablero.getSerpientes();
        boolean haySerpiente = false;

        boolean jugador1 = false;
        boolean jugador2 = false;
        boolean jugador3 = false;
        boolean jugador4 = false;

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[1].length; j++) {

                for (int k = 0; k < e.length; k++) {
                    if ((e[k].getCasillaInicio()[0] == i) && (e[k].getCasillaInicio()[1] == j)) {
                        hayEscalera = true;
                    }

                    if ((e[k].getCasillaFinal()[0] == i) && (e[k].getCasillaFinal()[1] == j)) {
                        hayEscalera = true;
                    }

                    if ((s[k].getCasillaInicio()[0] == i) && (s[k].getCasillaInicio()[1] == j)) {
                        haySerpiente = true;
                    }

                    if ((s[k].getCasillaFinal()[0] == i) && (s[k].getCasillaFinal()[1] == j)) {
                        haySerpiente = true;
                    }

                    for (int l = 0; l < jugadores.length; l++) {
                        int pocision[] = jugadores[l].getPosicion();
                        if ((pocision[0] == i) && (pocision[1] == j)) {
                            if (l == 0) {
                                jugador1 = true;
                            }
                            if (l == 1) {
                                jugador2 = true;
                            }
                            if (l == 2) {
                                jugador3 = true;
                            }
                            if (l == 3) {
                                jugador4 = true;
                            }
                        }
                    }
                }

                String impresion;
                if (c[i][j].isSorpresa()) {
                    impresion = "?";
                } else if (hayEscalera) {
                    impresion = "E";
                    hayEscalera = false;
                } else if (haySerpiente) {
                    impresion = "S";
                    haySerpiente = false;
                } else {
                    impresion = "-";
                }

                if (jugador1) {
                    impresion = "J1";
                    jugador1 = false;
                }

                if (jugador2) {
                    impresion = "J2";
                    jugador2 = false;
                }

                if (jugador3) {
                    impresion = "J3";
                    jugador3 = false;
                }

                if (jugador4) {
                    impresion = "J4";
                    jugador4 = false;
                }
                System.out.print(impresion + "\t");
            }
            System.out.println("");
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String leerNombre() {
        String nombre;
        boolean correcto;
        do {
            correcto = true;
            System.out.println("Digite el nombre:");
            nombre = leer.nextLine();
            if (nombre.length() < 5 || nombre.length() > 15) {
                System.out.println("El nombre debe tener minimo 5 caracteres y maximo 15\nDigite nuevamente su nombre");
                correcto = false;
            } else {
                for (int i = 0; i < nombre.length(); i++) {
                    if (isNumeric(String.valueOf(nombre.charAt(i)))) {
                        correcto = false;
                    }
                }
                if (!correcto) {
                    System.out.println("El nombre no debe tener ningun numero\nPor favor vuelva a digitarlo\n");
                }
            }
        } while (!correcto);
        return nombre;
    }

    public static String leerColorFicha() {
        boolean correcto;
        int posicion = -1;

        System.out.println("Seleccione el color de la ficha");
        System.out.println("<1> Amarillo");
        System.out.println("<2> Azul");
        System.out.println("<3> Rojo");
        System.out.println("<4> Verde");
        while (posicion < 1 || posicion > 4) {
            do {
                correcto = true;
                try {
                    posicion = s.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("se debe ingresar un numero entero");
                    if (s.hasNext()) {
                        s.next();
                    }
                    correcto = false;
                }
            } while (!correcto);
            if (posicion < 1 || posicion > 4) {
                System.out.println("ingrese un numero valido");
            }
        }
        return Ficha.colores[posicion - 1];
    }

    public static String leerColorDado() {
        boolean correcto;
        int posicion = -1;

        System.out.println("Seleccione el color del dado");
        System.out.println("<1> Negro");
        System.out.println("<2> Gris");
        System.out.println("<3> Blano");
        while (posicion < 1 || posicion > 3) {
            do {
                correcto = true;
                try {
                    posicion = s.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("se debe ingresar un numero entero");
                    if (s.hasNext()) {
                        s.next();
                    }
                    correcto = false;
                }
            } while (!correcto);
            if (posicion < 1 || posicion > 3) {
                System.out.println("ingrese un numero valido");
            }
        }
        return Dado.colores[posicion - 1];
    }

    public static boolean terminar() {
        String fin;
        System.out.println("para terminar el juego presione la tecla T");
        System.out.println("para jugar denuevo presione cualquier otra tecla");
        fin = s.nextLine();
        return !(fin == "T" || fin == "t");
    }

}
