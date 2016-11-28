/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.*;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import negocios.*;

/**
 *
 * @author brian
 */
public class UIGrafica extends javax.swing.JFrame {

    private static int MovIzq;
    private static int MovDer;
    private static int MovY;
    private int posicionX = 0;
    private int posicionY = 0;
    private int velocidad_X = 1;
    private int velocidad_Y = 1;
    private int tamanoTablero = 0;
    private Tipo tipo;
    private int numeroObtenido;
    private ArrayList<Jugador> jugadores;
    private Dado dado = new Dado();
    private javax.swing.JLabel simbolo;

    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void cambiarDirecciones(int movIz, int movDer, int movY) {
        MovIzq = movIz;
        MovDer = movDer;
        MovY = movY;
    }

    private class espera extends Thread {

        int cuantasCasillas;
        private boolean continuar = true;

        public espera(int cuantasCasillas) {
            this.cuantasCasillas = cuantasCasillas;
        }

        public void run() {
            int conteo = 0;
            while (continuar) {
                try {
                    Thread.sleep(1);
                    if (conteo == cuantasCasillas) {
                        continuar = false;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(UIGrafica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private class Hilo extends Thread {

        int direccion; // 1. eje x... 2. eje y
        int cuantasCasillas;
        int idmovimiento;
        JLabel jugador;
        int caso = 0;
        private boolean continuar = true;
//Hilo(1, 6, 1, jugador);

        public Hilo(int idmovimiento, int direccion, int cuantasCasillas, JLabel jugador) {
            this.idmovimiento = idmovimiento;
            this.direccion = direccion;
            this.cuantasCasillas = cuantasCasillas;
            this.jugador = jugador;
        }

        public void detenElHilo() {
            continuar = false;
        }

        private void esperarXsegundos() {
            try {
                Thread.sleep(idmovimiento * 1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        public void cambiarPosicionFicha(JLabel Labeljugador, String color, int casillaFinal[]) throws InterruptedException {
            Thread.sleep(1000 * 1);
            switch (color) {

                case "azul":
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaAzul.gif");
                    Thread.sleep(1000 * 2);
                    posicionX = (casillaFinal[1] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    posicionY = (casillaFinal[0] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    Labeljugador.setLocation(new Point(posicionX, posicionY));
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaAzul.gif");
                    Thread.sleep(1000 * 2);
                    setIconInLabel(Labeljugador, "/Multimedia/Ficha Azul.png");
                    break;

                case "rojo":
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaRoja.gif");
                    Thread.sleep(1000 * 2);
                    posicionX = (casillaFinal[1] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    posicionY = (casillaFinal[0] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    Labeljugador.setLocation(new Point(posicionX, posicionY));
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaRoja.gif");
                    Thread.sleep(1000 * 2);
                    setIconInLabel(Labeljugador, "/Multimedia/Ficha Roja.png");
                    break;

                case "verde":
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaVerde.gif");
                    Thread.sleep(1000 * 2);
                    posicionX = (casillaFinal[1] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    posicionY = (casillaFinal[0] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    Labeljugador.setLocation(new Point(posicionX, posicionY));
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaVerde.gif");
                    Thread.sleep(1000 * 2);
                    setIconInLabel(Labeljugador, "/Multimedia/Ficha Verde.png");
                    break;

                case "amarillo":
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaAmarillo.gif");
                    Thread.sleep(1000 * 2);
                    posicionX = (casillaFinal[1] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    posicionY = (casillaFinal[0] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    Labeljugador.setLocation(new Point(posicionX, posicionY));
                    setIconInLabel(Labeljugador, "/Multimedia/desvanecerFichaAmarillo.gif");
                    Thread.sleep(1000 * 2);
                    setIconInLabel(Labeljugador, "/Multimedia/Ficha Amarilla.png");
                    break;

                default:
                    setIconInLabel(Labeljugador, "/Multimedia/explosion.gif");
                    Thread.sleep(1000 * 2);
                    posicionX = (casillaFinal[1] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    posicionY = (casillaFinal[0] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
                    Labeljugador.setLocation(new Point(posicionX, posicionY));
                    setIconInLabel(Labeljugador, "/Multimedia/explosion.gif");
                    Thread.sleep(1000 * 2);
                    setIconInLabel(Labeljugador, "/Multimedia/Fastama.png");
                    break;

            }
        }

        public void comprobarCaminoYMover(Camino[] camino, JLabel labelJugador) {
            for (int i = 0; i < camino.length; i++) {
                if ((camino[i].getCasillaInicio()[0] == jugadores.get((Turno.getTurnoDe() - 1)).getPosicion()[0]) && (camino[i].getCasillaInicio()[1] == jugadores.get((Turno.getTurnoDe() - 1)).getPosicion()[1])) {
                    try {
                        cambiarPosicionFicha(labelJugador, jugadores.get((Turno.getTurnoDe() - 1)).getFicha().getColor(), camino[i].getCasillaFinal());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UIGrafica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        public void run() {
            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            if (direccion == 1) {
                esperarXsegundos();
                posicionX = jugador.getX();
                posicionY = jugador.getY();
                int posicionInicial = posicionX;
                velocidad_X = 1;
                while (continuar) {
                    try {
                        moverX();
                        jugador.setLocation(new Point(posicionX, posicionY));
                        repaint();
                        Thread.sleep(1);
                        if (posicionX > (posicionInicial + (cuantasCasillas * ((screenSize.height - 140) / tamanoTablero) + 1))) {
                            detenElHilo();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UIGrafica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (direccion == -1) {
                esperarXsegundos();
                velocidad_X = -1;
                posicionX = jugador.getX();
                posicionY = jugador.getY();
                int posicionInicial = posicionX;
                while (continuar) {
                    try {
                        moverX();
                        jugador.setLocation(new Point(posicionX, posicionY));
                        repaint();
                        Thread.sleep(1);
                        if (posicionX < (posicionInicial - (cuantasCasillas * ((screenSize.height - 140) / tamanoTablero) + 1))) {
                            detenElHilo();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UIGrafica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (direccion == 6) {
                try {
                    System.out.println("Se ha lanzado el dado");
                    setIconInLabel(jLabelDeDado, "/Multimedia/lanzarDado.gif");
                    AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Multimedia/Dados.wav"));
                    sonido.play();
                    for (int i = 0; i < 2; i++) {
                        Thread.sleep(1000);
                    }
                    System.out.println("Valor: " + dado.getNumeroObtenido());
                    setIconInLabel(jLabelDeDado, "/Multimedia/dado" + dado.getNumeroObtenido() + ".png");
                    for (int i = 0; i < 2; i++) {
                        Thread.sleep(500);
                    }

                    System.out.println("Oprima el boton");
                    setIconInLabel(jLabelDeDado, "/Multimedia/oprimirBoton.gif");

                } catch (InterruptedException e) {
                    System.out.println("El mensaje de error es " + e.getMessage());
                }
                System.out.println("Sentido del jugador " + Turno.getTurnoDe() + " en el hilo:" + jugadores.get((Turno.getTurnoDe() - 1)).getSentido());
                if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == -1) {
                    moviminetoEjeXIzquierda(1, MovIzq, jugador);
                    moviminetoEjeY(2, MovY, jugador);
                    moviminetoEjeXDerecha(3, MovDer, jugador);
                } else if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == 1) {
                    moviminetoEjeXDerecha(1, MovDer, jugador);
                    moviminetoEjeY(2, MovY, jugador);
                    moviminetoEjeXIzquierda(3, MovIzq, jugador);
                } else {

                }
            } else {
                esperarXsegundos();
                velocidad_Y = -1;
                posicionX = jugador.getX();
                posicionY = jugador.getY();
                int posicionInicial = posicionY;
                while (continuar) {
                    try {
                        moverY();
                        jugador.setLocation(new Point(posicionX, posicionY));
                        repaint();
                        Thread.sleep(1);
                        if (posicionY <= (posicionInicial - (cuantasCasillas * ((screenSize.height - 140) / tamanoTablero) + 1))) {
                            detenElHilo();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UIGrafica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            if (direccion == 6) {
                esperarXsegundos();
                esperarXsegundos();
                this.comprobarCaminoYMover(tipo.getTablero().getEscaleras(), simbolo);
                Movimiento.comprobarCaminoYMover(tipo.getTablero().getEscaleras(), jugadores.get((Turno.getTurnoDe() - 1)));
                this.comprobarCaminoYMover(tipo.getTablero().getSerpientes(), simbolo);
                Movimiento.comprobarCaminoYMover(tipo.getTablero().getSerpientes(), jugadores.get((Turno.getTurnoDe() - 1)));
                caso = Movimiento.comprobarSorpresa(tipo.getTablero().getCasillas(), jugadores.get((Turno.getTurnoDe() - 1)));
                if (caso != 0) {
                    switch (caso) {
                        case 1: //Avanza 1
                            if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == -1) {
                                moviminetoEjeXIzquierda(1, MovIzq, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXDerecha(3, MovDer, jugador);
                            } else if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == 1) {
                                moviminetoEjeXDerecha(1, MovDer, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXIzquierda(3, MovIzq, jugador);
                            } else {

                            }
                            break;
                        case 2: //Avanza 2
                            if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == -1) {
                                moviminetoEjeXIzquierda(1, MovIzq, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXDerecha(3, MovDer, jugador);
                            } else if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == 1) {
                                moviminetoEjeXDerecha(1, MovDer, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXIzquierda(3, MovIzq, jugador);
                            } else {

                            }
                            break;
                        case 3: //Retrocede 1
                            if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == -1) {
                                moviminetoEjeXIzquierda(1, MovIzq, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXDerecha(3, MovDer, jugador);
                            } else if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == 1) {
                                moviminetoEjeXDerecha(1, MovDer, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXIzquierda(3, MovIzq, jugador);
                            } else {

                            }
                            break;
                        case 4: //Retrocede 2
                            if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == -1) {
                                moviminetoEjeXIzquierda(1, MovIzq, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXDerecha(3, MovDer, jugador);
                            } else if (jugadores.get((Turno.getTurnoDe() - 1)).getSentido() == 1) {
                                moviminetoEjeXDerecha(1, MovDer, jugador);
                                moviminetoEjeY(2, MovY, jugador);
                                moviminetoEjeXIzquierda(3, MovIzq, jugador);
                            } else {

                            }
                            break;
                    }
                    this.comprobarCaminoYMover(tipo.getTablero().getEscaleras(), simbolo);
                    Movimiento.comprobarCaminoYMover(tipo.getTablero().getEscaleras(), jugadores.get((Turno.getTurnoDe() - 1)));
                    this.comprobarCaminoYMover(tipo.getTablero().getSerpientes(), simbolo);
                    Movimiento.comprobarCaminoYMover(tipo.getTablero().getSerpientes(), jugadores.get((Turno.getTurnoDe() - 1)));
                }
                Turno.CambiarTurno();
                JOptionPane.showMessageDialog(null, "Turno del jugador " + Turno.getTurnoDe() + ": " + jugadores.get(Turno.getTurnoDe() - 1).getNombre());
            } else {

            }
        }
    }

    public void moverX() {
        posicionX += velocidad_X;
    }

    public void moverY() {
        posicionY += velocidad_Y;
    }

    public void moviminetoEjeXDerecha(int idmovimiento, int casillas, JLabel jugador) {
        if (casillas != 0) {
            Hilo h = new Hilo(idmovimiento, 1, casillas, jugador);
            h.start();
        }
    }

    public void LanzarDado(JLabel simbolo) {
        this.simbolo = simbolo;
        Hilo h = new Hilo(1, 6, 1, simbolo);
        h.start();
    }

    public void moviminetoEjeXIzquierda(int idmovimiento, int casillas, JLabel jugador) {
        if (casillas != 0) {
            Hilo h = new Hilo(idmovimiento, -1, casillas, jugador);
            h.start();
        }
    }

    public void moviminetoEjeY(int idmovimiento, int casillas, JLabel jugador) {
        if (casillas != 0) {
            Hilo h = new Hilo(idmovimiento, 2, casillas, jugador);
            h.start();
        }
    }

    public void setIconInLabel(JLabel label, String dirreccion) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(dirreccion));
        ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }

    public JLabel crearJugador(Jugador jugador) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel labeljugador = new JLabel();
        boolean fantasma = false;

        labeljugador.setSize(((screenSize.height - 140) / tamanoTablero) - 20, ((screenSize.height - 140) / tamanoTablero) - 20);
        switch (jugador.getFicha().getColor()) {

            case "azul":
                setIconInLabel(labeljugador, "/Multimedia/Ficha Azul.png");
                break;

            case "amarillo":
                setIconInLabel(labeljugador, "/Multimedia/Ficha Amarilla.png");
                break;

            case "rojo":
                setIconInLabel(labeljugador, "/Multimedia/Ficha Roja.png");
                break;

            case "verde":
                setIconInLabel(labeljugador, "/Multimedia/Ficha verde.png");
                break;

            case "gris":
                setIconInLabel(labeljugador, "/Multimedia/Fastama.png");
                fantasma = true;
                break;

            default:

                break;

        }
        if (fantasma) {
            posicionX = (jugador.getPosicion()[1] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
            posicionY = (jugador.getPosicion()[0] * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
            labeljugador.setLocation(new Point(posicionX, posicionY));
        } else {
            posicionX = (-1 * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
            posicionY = ((tamanoTablero - 1) * ((screenSize.height - 140) / tamanoTablero) + 1) + (((((screenSize.height - 140) / tamanoTablero) + 1) - (((screenSize.height - 140) / tamanoTablero) - 20)) / 2);
            labeljugador.setLocation(new Point(posicionX, posicionY));
        }
        return labeljugador;
    }

    /**
     * Creates new form NewJFrame
     */
    public UIGrafica(Tipo tipo, ArrayList<Jugador> jugadores) {
        this.tipo = tipo;
        this.jugadores = jugadores;
        initComponents();
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.height, screenSize.height - 100));
        this.setMinimumSize(new Dimension(screenSize.height - 120, screenSize.height - 100));
        this.setMaximumSize(new Dimension(screenSize.height - 100, screenSize.height - 100));
        Tablero.setSize(screenSize.height - 140, screenSize.height - 140);

        if (tipo.getTamanoTablero() == 64) {
            setIconInLabel(Tablero, "/Multimedia/Tablero 8x8.png");
            tamanoTablero = 8;
            this.repaint();
        }

        if (tipo.getTamanoTablero() == 100) {
            setIconInLabel(Tablero, "/Multimedia/Tablero 10x10.png");
            tamanoTablero = 10;
            this.repaint();
        }

        if (tipo.getTamanoTablero() == 144) {
            setIconInLabel(Tablero, "/Multimedia/Tablero 12x12.png");
            tamanoTablero = 12;
            this.repaint();
        }

        if (jugadores.size() == 2) {
            jugador1 = crearJugador(jugadores.get(0));
            Tablero.add(jugador1);
            this.repaint();

            jugador2 = crearJugador(jugadores.get(1));
            Tablero.add(jugador2);
            this.repaint();
        }
        if (jugadores.size() == 3) {
            jugador1 = crearJugador(jugadores.get(0));
            Tablero.add(jugador1);
            this.repaint();

            jugador2 = crearJugador(jugadores.get(1));
            Tablero.add(jugador2);
            this.repaint();

            jugador3 = crearJugador(jugadores.get(2));
            Tablero.add(jugador3);
            this.repaint();
        }
        if (jugadores.size() == 4) {
            jugador1 = crearJugador(jugadores.get(0));
            Tablero.add(jugador1);
            this.repaint();

            jugador2 = crearJugador(jugadores.get(1));
            Tablero.add(jugador2);
            this.repaint();

            jugador3 = crearJugador(jugadores.get(2));
            Tablero.add(jugador3);
            this.repaint();

            jugador4 = crearJugador(jugadores.get(3));
            Tablero.add(jugador4);
            this.repaint();
        }

        Turno.setNumeroDeJugadores(jugadores.size());

        jLabelDeDado.setSize(100, 100);
        setIconInLabel(jLabelDeDado, "/Multimedia/oprimirBoton.gif");
        setTitle("Serpientes Y Escaleras");
        Tablero.add(jLabelDeDado);
        jLabelDeDado.setLocation(new Point((screenSize.height - 140) + 10, 200));
        this.repaint();

        Tablero.add(BotonLanzarDado);
        BotonLanzarDado.setLocation(new Point((screenSize.height - 140) + 10, 320));

        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    public static boolean Movimiento(Tipo tipo, Jugador jugador, Dado dado) {
        Movimiento.moverFicha(tipo.getTablero().getCasillas(), jugador, dado);
        return Movimiento.esGanador(jugador);
    }

    public static boolean comprobarFantasma(Jugador jugador1, Jugador fantasma) {
        if ((fantasma.getPosicion()[0] == jugador1.getPosicion()[0]) && (fantasma.getPosicion()[1] == jugador1.getPosicion()[1])) {
            UI.mensaje(7, jugador1.getNombre());
            return true;
        } else {
            return false;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jugador1 = new javax.swing.JLabel();
        Tablero = new javax.swing.JLabel();
        jugador2 = new javax.swing.JLabel();
        jugador3 = new javax.swing.JLabel();
        jugador4 = new javax.swing.JLabel();
        jLabelDeDado = new javax.swing.JLabel();
        BotonLanzarDado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BotonLanzarDado.setText("Lanzar Dado");
        BotonLanzarDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLanzarDadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 1679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jugador3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jugador4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabelDeDado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(BotonLanzarDado)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDeDado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(BotonLanzarDado)
                        .addGap(0, 804, Short.MAX_VALUE))
                    .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLanzarDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLanzarDadoActionPerformed
        boolean JuegoTerminado = false;
        switch (Turno.getTurnoDe()) {
            case 1:
                JuegoTerminado = this.Movimiento(tipo, jugadores.get(0), dado);
                LanzarDado(jugador1);
//                Turno.CambiarTurno();
                break;
            case 2:
                JuegoTerminado = Movimiento(tipo, jugadores.get(1), dado);
                LanzarDado(jugador2);
                if (!JuegoTerminado) {
                    if (jugadores.get(1).getFicha().getColor() == "gris") {
                        JuegoTerminado = comprobarFantasma(jugadores.get(0), jugadores.get(1));
                    }
                }
//                Turno.CambiarTurno();
                break;
            case 3:
                JuegoTerminado = Movimiento(tipo, jugadores.get(2), dado);
                LanzarDado(jugador3);
                if (!JuegoTerminado) {
                    if (jugadores.get(2).getFicha().getColor() == "gris") {
                        JuegoTerminado = comprobarFantasma(jugadores.get(0), jugadores.get(2));
                    }
                }
//                Turno.CambiarTurno();
                break;
            case 4:
                JuegoTerminado = Movimiento(tipo, jugadores.get(3), dado);
                LanzarDado(jugador4);
                if (!JuegoTerminado) {
                    if (jugadores.get(1).getFicha().getColor() == "gris") {
                        JuegoTerminado = comprobarFantasma(jugadores.get(0), jugadores.get(3));
                    }
                }
//                Turno.CambiarTurno();
                break;
            default:
                //System.out.println("No hay m�s turnos"); //Se supone que jam�s sera diferente de estos valores.
                break;
        }
        if (JuegoTerminado) {
            JOptionPane.showMessageDialog(null, "Juego Terminado");
            System.exit(0);
        }
    }//GEN-LAST:event_BotonLanzarDadoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UIGrafica.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UIGrafica.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UIGrafica.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UIGrafica.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UIGrafica().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLanzarDado;
    private javax.swing.JLabel Tablero;
    private javax.swing.JLabel jLabelDeDado;
    private javax.swing.JLabel jugador1;
    private javax.swing.JLabel jugador2;
    private javax.swing.JLabel jugador3;
    private javax.swing.JLabel jugador4;
    // End of variables declaration//GEN-END:variables
}
