/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.*;

/**
 *
 * @author LENOVO
 */
public class UI {

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
                            if(l==0){
                                jugador1 = true;
                            }
                            if(l==1){
                                jugador2 = true;
                            }
                            if(l==2){
                                jugador3 = true;
                            }
                            if(l==3){
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

public static int BuscarDatos(String[] Arreglo, String string) {
        int result = -1;
        int cant = 0;
        for (String stringFounded : Arreglo) {
            if (Arreglo[cant].equals(string)) {
                result = cant;
            }
            cant++;
        }
        return result;
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
        boolean correcto = true;
        String nombre;
        do {
            correcto = true;
            System.out.println("Digite el nombre:");
            nombre = s.nextLine();
            if (nombre.length() < 5 || nombre.length() > 15) {
                System.out.println("El nombre debe tener minimo 5 caracteres y maximo 15\nDigite nuevamente su nombre");
                correcto = false;
            } else {
                for (int i = 0; i < nombre.length(); i++) {
                    if (isNumeric(String.valueOf(nombre.charAt(i)))) {
                        correcto = false;
                    }
                }
                if (correcto = false) {
                    System.out.println("El nombre no debe tener ningun numero\nPor favor vuelva a digitarlo\n");
                }
            }
        } while (correcto == false);
        return nombre;
    }
    
    public static String LeerColorDeFicha() {
        boolean correcto = true;
        String colorDeFicha = "Color invalido";
        int posicion = 0;

        do {
            colorDeFicha = "Color invalido";
            System.out.println("Digite el color de la ficha");
            colorDeFicha = s.nextLine();
            if (colorDeFicha.length() > 3 && colorDeFicha.length() < 9) {
                posicion = BuscarDatos(datos.Ficha.colores, colorDeFicha);
                if (posicion < datos.Ficha.colores.length) {
                    correcto = true;
                }
            } else {
                for (int i = 0; i < colorDeFicha.length(); i++) {
                    if (isNumeric(String.valueOf(colorDeFicha.charAt(i)))) {
                        correcto = false;
                    }
                }
                if (correcto == false) {
                    System.out.println("El color no puede tener ningun caracter alfabetico");
                }
            }
        } while (correcto);
        return colorDeFicha;
    }
    
    public static String LeerColorDeDado() {
        boolean correcto = true;
        String colorDeDado = "Color invalido";
        int posicion = 0;

        do {
            colorDeDado = "Color invalido";
            System.out.println("Digite el color del dado");
            colorDeDado = s.nextLine();
            if (colorDeDado.length() > 3 && colorDeDado.length() < 9) {
                posicion = BuscarDatos(datos.Dado.colores, colorDeDado);
                if (posicion < datos.Dado.colores.length) {
                    correcto = true;
                }
            } else {
                for (int i = 0; i < colorDeDado.length(); i++) {
                    if (isNumeric(String.valueOf(colorDeDado.charAt(i)))) {
                        correcto = false;
                    }
                }
                if (correcto == false) {
                    System.out.println("El color no puede tener ningun caracter alfabetico");
                }
            }
        } while (correcto);
        return colorDeDado;
    }

   
    
}
