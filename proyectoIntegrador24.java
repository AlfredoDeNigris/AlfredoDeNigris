package com.mycompany.proyectointegrador24; //Define el paquete donde se encuentra la clase.

import java.util.Scanner; //Importa la clase Scanner del paquete java.util para leer la entrada del usuario.

public class ProyectoIntegrador24 { // Define una clase pública llamada ProyectoIntegrador24.
    public static void main(String[] args) { // Método principal que se ejecuta al iniciar el programa.

        // Declaración e Inicialización de variables.
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario desde la
                                             // consola.
        String nombreJugador1, nombreJugador2, ganador; // Declara variables de tipo String para los nombres de los
                                                        // jugadores y el ganador.
        int dado1, dado2, puntajeJugador1, puntajeJugador2, puntajeGanador, ronda; // Declara variables de tipo int para
                                                                                   // los dados, los puntajes y el
                                                                                   // número de rondas.
        // Inicializamos las variables con valores predeterminados.
        nombreJugador1 = "";
        nombreJugador2 = "";
        ganador = "";
        puntajeJugador1 = 0; // Acumulador del puntaje del jugador 1
        puntajeJugador2 = 0; // Acumulador del puntaje del jugador 2
        puntajeGanador = 0;
        ronda = 0; // Contador de rondas.

        System.out.println("Bienvenid@s Jugadores ¡Al Gran Juego!"); // Muestra un mensaje de bienvenida

        do { // Inicia el bucle "do-while", tambien llamado "hacer-mientras"
            ronda++; // Le suma uno al contador de rondas.
            // Turno jugador1.
            // Si nombreJugador1 está vacío, pide al usuario que ingrese el nombre del
            // primer jugador.
            if (nombreJugador1.isEmpty()) {
                System.out.println("Ingrese el nombre del primer participante");
                nombreJugador1 = sc.nextLine();
            }

            System.out.println("Es el turno de " + nombreJugador1); // Anuncia el turno del primer jugador.

            do { // Bucle "do-while", tambien llamado "hacer-mientras" que se repite hasta que
                 // los valores de los dos dados sean iguales.
                System.out.println("Ingrese el valor del primer dado");
                dado1 = validarPuntaje(sc.nextInt()); // Lee y valida el valor del primer dado.
                System.out.println("Ingrese el valor del segundo dado");
                dado2 = validarPuntaje(sc.nextInt()); // Lee y valida el valor del segundo dado.
                puntajeJugador1 = puntajeJugador1 + calcularPuntaje(dado1, dado2); // Calcula y suma el puntaje del
                                                                                   // primer jugador.

                // Limpieza del buffer de entrada para asegurar el correcto funcionamiento de
                // "Scanner".
                sc.nextLine();
            } while (dado1 != dado2);
            System.out.println("El turno de " + nombreJugador1 + " ha terminado."); // Anuncia el fin del primer
                                                                                    // jugador.

            // Turno jugador2.
            // Si nombreJugador2 está vacío, pide al usuario que ingrese el nombre del
            // segundo jugador.
            if (nombreJugador2.isEmpty()) {
                System.out.println("Ingrese el nombre del segundo participante");
                nombreJugador2 = sc.nextLine();
            }

            System.out.println("Es el turno de " + nombreJugador2); // Anuncia el turno del segundo jugador.

            do {// Bucle do-while que se repite hasta que los valores de los dos dados sean
                // iguales.
                System.out.println("Ingrese el valor del primer dado");
                dado1 = validarPuntaje(sc.nextInt());
                System.out.println("Ingrese el valor del segundo dado");
                dado2 = validarPuntaje(sc.nextInt());
                puntajeJugador2 = puntajeJugador2 + calcularPuntaje(dado1, dado2);

                // Limpieza del buffer de entrada para asegurar el correcto funcionamiento de
                // "Scanner".
                sc.nextLine();
            } while (dado1 != dado2);
            System.out.println("El turno de " + nombreJugador2 + " ha terminado."); // Anuncia el turno del segundo
                                                                                    // jugador.

        } while ((puntajeJugador1 < 50) && (puntajeJugador2 < 50)); // Termina el bucle cuando uno de los jugadores
                                                                    // alcanza 50 puntos.

        // Determinamos el ganador comparando los puntajes.
        if (puntajeJugador1 > puntajeJugador2) {
            ganador = nombreJugador1;
            puntajeGanador = puntajeJugador1;
        } else if (puntajeJugador2 > puntajeJugador1) {
            ganador = nombreJugador2;
            puntajeGanador = puntajeJugador2;
        }

        if (ganador.isEmpty()) { // En caso de empate se informa el puntaje de los jugadores y la ronda.
            System.out.println("Al terminar la ronda número " + ronda + ".");
            System.out.println("El Gran Juego ha terminado en empate");
            System.out.println("Ambos jugadores obtuvieron " + puntajeJugador1 + " puntos.");
        } else { // Informamos el ganador, su puntaje y el número de rondas.
            System.out.println("Al terminar la ronda número " + ronda + ".");
            System.out.println("Con un total de " + puntajeGanador + " puntos.");
            System.out.println(ganador + " ¡¡¡ha ganado El Gran Juego!!!");
        }
    }

    // Módulo que verifica si el puntaje ingresado es válido (entre 1 y 6).
    public static int validarPuntaje(int dado) {
        int dado1 = dado;
        if (dado1 < 1 || dado1 > 6) {
            dado1 = 0;
        }
        return dado1;
    }

    // Módulo que calcula el puntaje obtenido con los dados ingresados.
    public static int calcularPuntaje(int dado1, int dado2) {
        int puntaje = dado1 + dado2;
        if (determinarParidad(dado1) && determinarParidad(dado2)) {
            puntaje = dado1 * dado2;
        }
        return puntaje;
    }

    // Módulo que determina si el valor del dado es par.
    public static boolean determinarParidad(int dado) {
        return (dado != 0) && (dado % 2 == 0);
    }
}