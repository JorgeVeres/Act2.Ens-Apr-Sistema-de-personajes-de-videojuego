package view;

import controllers.Batalla;
import controllers.Juego;
import model.Personaje;
import model.interfaces.*;

import java.util.Scanner;

public class View {
    private final Juego juego;
    private Personaje jugador1;
    private Personaje jugador2;
    private final Scanner scanner = new Scanner(System.in);

    public View(Juego juego) {
        this.juego = juego;
    }

    public void iniciar() {
        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Seleccionar Personajes");
            System.out.println("2. Mostrar Acciones de Todos los Personajes");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    seleccionarPersonajes();
                    break;
                case 2:
                    juego.mostrarAcciones(); // Aquí se muestran las acciones
                    break;
                case 3:
                    iniciarBatalla();
                    break;
                case 4:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 4);
    }

    private void seleccionarPersonajes() {
        System.out.println("\n=== SELECCIÓN DE PERSONAJES ===");
        jugador1 = seleccionarPersonaje(1);
        jugador2 = seleccionarPersonaje(2);
        System.out.println("\nPersonajes seleccionados:");
        System.out.println("- Jugador 1: " + jugador1);
        System.out.println("- Jugador 2: " + jugador2);
    }

    private Personaje seleccionarPersonaje(int numeroJugador) {
        System.out.println("\nJugador " + numeroJugador + ", selecciona tu personaje:");
        
        // Mostrar todos los personajes disponibles
        int index = 1;
        for(Personaje p : juego.getPersonajes()) {
            System.out.println(index++ + ". " + p);
        }
        
        // Validar entrada
        int eleccion;
        do {
            System.out.print("Elección (1-" + juego.getPersonajes().size() + "): ");
            eleccion = scanner.nextInt() - 1;
        } while(eleccion < 0 || eleccion >= juego.getPersonajes().size());
        
        return juego.getPersonajes().get(eleccion);
    }

    private void mostrarHabilidades() {
        if(jugador1 == null || jugador2 == null) {
            System.out.println("Primero selecciona los personajes!");
            return;
        }
        
        System.out.println("\nHabilidades de " + jugador1.getNombre() + ":");
        mostrarHabilidadesPersonaje(jugador1);
        
        System.out.println("\nHabilidades de " + jugador2.getNombre() + ":");
        mostrarHabilidadesPersonaje(jugador2);
    }

    private void mostrarHabilidadesPersonaje(Personaje p) {
        System.out.println("1. Atacar básico");
        
        if(p instanceof Defendible) {
            System.out.println("2. Defender");
        }
        if(p instanceof Curable) {
            System.out.println("3. Curar");
        }
        if(p instanceof Magico) {
            System.out.println("4. Lanzar hechizo");
        }
        if(p instanceof Movilizable) {
            System.out.println("5. Moverse");
        }
        if(p instanceof Volador) {
            System.out.println("6. Volar");
        }
    }

    private void iniciarBatalla() {
        if(jugador1 == null || jugador2 == null) {
            System.out.println("Primero selecciona ambos personajes!");
            return;
        }
        
        System.out.println("\n=== INICIANDO BATALLA ===");
        Batalla.iniciarCombateInteractivo(jugador1, jugador2);
        
        // Resetear salud
        jugador1.setSalud(150);  // Valor inicial según personaje
        jugador2.setSalud(150);
    }
}