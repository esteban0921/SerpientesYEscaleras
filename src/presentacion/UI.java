/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class UI {

    static Scanner s = new Scanner(System.in);

    public static String Menu(int menu){
    	if (menu == 1) System.out.println("\n*-*-*-* SERPIENTES Y ESCALERAS UN *-*-*-*");
    	String ingreso = null;
		boolean validar = false;
		
		switch(menu){
		case 1: System.out.println("\nSeleccione un modo de juego: "
				+ "\n<1> Modo clasico."
				+ "\n<2> Modo supervivencia.");
		break;
		case 2: //Seleccionar tamaño
			System.out.println("\nSeleccione el tamaño del tablero: "
					+ "\n<1> 8 x 8."
					+ "\n<2> 10 x 10."
					+ "\n<3> 12 x 12.");
			break;
		case 3: //Seleccionar jugadores para cualquiera de los dos juegos. Cual es el modo de un jugador?
			System.out.println("Seleccione el numero de jugadores (2-4): ");
			break;
		}
		
		while(!validar){
			validar = true;
			ingreso = s.nextLine(); //Revisar en caso de no almacenar bien.
			for (int i = 0; i < ingreso.length(); i++) {
				if (!isNumeric(String.valueOf(ingreso.charAt(i)))) {
					validar = false;
					i = ingreso.length();
				}
				else if(i == ingreso.length() - 1){
					if(menu == 1 && ((Integer.parseInt(ingreso) < 1) || (Integer.parseInt(ingreso) > 2))) validar = false;
					if(menu == 2 && ((Integer.parseInt(ingreso) < 1) || (Integer.parseInt(ingreso) > 3))) validar = false;
					if(menu == 3 && ((Integer.parseInt(ingreso) < 2) || (Integer.parseInt(ingreso) > 4))) validar = false;
				}
			}
			if(menu == 1 && !validar) System.err.print("Digite un numero valido (1-2): ");
			if(menu == 2 && !validar) System.err.print("Digite un numero valido (1-3): ");
			if(menu == 3 && !validar) System.err.print("Digite un numero valido (2-4): ");
		}
		return ingreso;
    }
    
     
    public static void imprimirTablero(Tablero tablero, ArrayList<Jugador> jugadores) {
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

                    for (int l = 0; l < jugadores.size(); l++) {
                        int pocision[] = jugadores.get(l).getPosicion();
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

    public static String leerNombre(int n) {
        String nombre;
        boolean correcto;
        do {
        	System.out.println("Jugador " + n + ": \n");
            correcto = true;
            System.out.print("Digite el nombre: ");
            nombre = s.nextLine();
            if (nombre.length() < 5 || nombre.length() > 15) {
                System.err.println("El nombre debe tener minimo 5 caracteres y maximo 15\nDigite nuevamente su nombre");
                correcto = false;
            } else {
                for (int i = 0; i < nombre.length(); i++) {
                    if (isNumeric(String.valueOf(nombre.charAt(i)))) {
                        correcto = false;
                    }
                }
                if (!correcto) {
                    System.err.println("El nombre no debe tener ningun numero\nPor favor vuelva a digitarlo\n");
                }
            }
        } while (!correcto);
        return nombre;
    }

    public static String leerColorFicha() {
        boolean correcto;
        int posicion = -1;

        System.out.println("Seleccione el color de la ficha: ");
        System.out.println("<1> Amarillo.");
        System.out.println("<2> Azul.");
        System.out.println("<3> Rojo.");
        System.out.println("<4> Verde.");
        while (posicion < 1 || posicion > 4) {
            do {
                correcto = true;
                try {
                    posicion = s.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Se debe ingresar un numero entero.");
                    if (s.hasNext()) s.next();
                    correcto = false;
                }
            } while (!correcto);
            if (posicion < 1 || posicion > 4) System.err.println("ingrese un numero valido");
        }
        return Ficha.colores[posicion - 1];
    }

    public static String leerColorDado() {
        boolean correcto;
        int posicion = -1;

        System.out.println("Seleccione el color del dado");
        System.out.println("<1> Negro.");
        System.out.println("<2> Gris.");
        System.out.println("<3> Blanco.");
        while (posicion < 1 || posicion > 3) {
            do {
                correcto = true;
                try {
                    posicion = s.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.err.println("se debe ingresar un numero entero");
                    if (s.hasNext()) {
                        s.next();
                    }
                    correcto = false;
                }
            } while (!correcto);
            if (posicion < 1 || posicion > 3) {
                System.err.println("ingrese un numero valido");
            }
        }
        return Dado.colores[posicion - 1];
    }

    public static boolean terminar() {
        String fin;
        System.out.println("Para terminar el juego presione la tecla T.");
        System.out.println("Para jugar de nuevo presione cualquier otra tecla.");
        fin = s.nextLine();
        return !(fin.equalsIgnoreCase("T"));
    }


	public static void error() {
			System.err.println("No puede seleccionar una ficha del mismo color.");
	}


	public static void mensaje(int n, String m) {
		switch (n){
			case 1:
				System.out.println("\nHas Ganado el juego " + m + "... Felicitaciones!\n");
				break;
			case 2:
				if(m == "1") System.out.println("Casilla Sorpresa: Avanza una casilla");
				else if(m == "2") System.out.println("Casilla Sorpresa: Avanza dos casillas");
				else if(m == "3") System.out.println("Casilla Sorpresa: retrocede una casilla");
				else if(m == "4") System.out.println("Casilla Sorpresa: retrocede dos casillas");
				break;
			case 3:
				System.out.println("Numero obtenido: " + m + "\n");
				break;
			case 4:
                System.out.println("Te saliste del tablero, perdiste turno.");
				break;
			case 5: 
				System.out.println(m + ": Presione cualquier tecla para lanzar el dado");
				break;
		}
	}
}
