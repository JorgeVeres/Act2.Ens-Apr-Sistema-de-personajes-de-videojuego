package controllers;

import model.*;

import model.interfaces.*;
import java.util.Scanner;

public class Batalla {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean batallaActiva = true;
    
    public static void iniciarCombateInteractivo(Personaje jugador1, Personaje jugador2) {
        batallaActiva = true;
        System.out.println("\n⚔️ COMIENZA LA BATALLA INTERACTIVA ⚔️");
        
        while(batallaActiva && jugador1.getSalud() > 0 && jugador2.getSalud() > 0) {
            if(!realizarTurno(jugador1, jugador2, 1)) break;
            if(!batallaActiva || jugador2.getSalud() <= 0) break;
            
            if(!realizarTurno(jugador2, jugador1, 2)) break;
            if(!batallaActiva || jugador1.getSalud() <= 0) break;
        }
        
        if(batallaActiva) {
            System.out.println("\n🏁 BATALLA TERMINADA!");
            System.out.println("Ganador: " + 
                (jugador1.getSalud() > 0 ? "Jugador 1" : "Jugador 2"));
        }
    }

    private static boolean realizarTurno(Personaje atacante, Personaje defensor, int numJugador) {
        System.out.println("\n=== TURNO DE JUGADOR " + numJugador + " ===");
        System.out.println("Salud actual: " + atacante.getSalud());
        mostrarAccionesDisponibles(atacante);
        
        System.out.print("Selecciona una acción (0 para abandonar): ");
        int accion = scanner.nextInt();
        
        if(accion == 0) {
            System.out.println("\n🚩 El Jugador " + numJugador + " ha abandonado la batalla!");
            batallaActiva = false;
            return false;
        }
        
        ejecutarAccion(atacante, defensor, accion);
        return true;
    }
    
    private static void mostrarAccionesDisponibles(Personaje p) {
        System.out.println("\nAcciones disponibles:");
        int opcion = 1;
        
        System.out.println(opcion++ + ". Atacar básico");
        
        if(p instanceof Defendible) {
            System.out.println(opcion++ + ". Defender");
        }
        if(p instanceof Curable) {
            System.out.println(opcion++ + ". Curar");
        }
        if(p instanceof Magico) {
            System.out.println(opcion++ + ". Lanzar hechizo");
        }
        if(p instanceof Movilizable) {
            System.out.println(opcion++ + ". Moverse");
        }
        if(p instanceof Volador) {
            System.out.println(opcion++ + ". Volar");
        }
        
        // Acciones específicas de clase
        if(p instanceof Guerrero) {
            System.out.println(opcion++ + ". Cargar ataque");
        }
        if(p instanceof Mago) {
            System.out.println(opcion++ + ". Regenerar maná");
        }
        if(p instanceof Arquero) {
            System.out.println(opcion++ + ". Disparar flecha");
            System.out.println(opcion++ + ". Reabastecer flechas");
        }
        if(p instanceof Hechicero) {
            System.out.println(opcion++ + ". Invocar entidad");
        }
        if(p instanceof Asesino) {
            System.out.println(opcion++ + ". Ataque por la espalda");
            System.out.println(opcion++ + ". Ocultar");
        }
        System.out.println("0. Abandonar batalla");
    }
    
    private static void ejecutarAccion(Personaje atacante, Personaje defensor, int accion) {
        int opcion = 1;
        // Atacar básico (siempre disponible)
        if(accion == opcion++) {
            atacante.atacar();
            defensor.setSalud(defensor.getSalud() - 20);
        }
        else if(atacante instanceof Defendible && accion == opcion++) {
            ((Defendible) atacante).defender();
        }
        else if(atacante instanceof Curable && accion == opcion++) {
            ((Curable) atacante).curar();
        }
        else if(atacante instanceof Magico && accion == opcion++) {
            ((Magico) atacante).lanzarHechizo();
        }
        else if(atacante instanceof Movilizable && accion == opcion++) {
            ((Movilizable) atacante).moverse();
        }
        else if(atacante instanceof Volador && accion == opcion++) {
            ((Volador) atacante).volar();
        }
        // Acciones específicas de clase
        else if(atacante instanceof Guerrero && accion == opcion++) {
            ((Guerrero) atacante).cargarAtaque();
        }
        else if(atacante instanceof Mago && accion == opcion++) {
            ((Mago) atacante).regenerarMana();
        }
        else if(atacante instanceof Arquero) {
            if(accion == opcion++) {
                ((Arquero) atacante).dispararFlecha();
            } else if(accion == opcion++) {
                ((Arquero) atacante).reabastecerFlechas();
            }
        }
        else if(atacante instanceof Hechicero && accion == opcion++) {
            ((Hechicero) atacante).invocarEntidad();
        }
        else if(atacante instanceof Asesino) {
            if(accion == opcion++) {
                ((Asesino) atacante).atacarPorLaEspalda();
            } else if(accion == opcion++) {
                ((Asesino) atacante).ocultar();
            }
        }
        else {
            System.out.println("Acción no válida! Se realiza ataque básico.");
            atacante.atacar();
            defensor.setSalud(defensor.getSalud() - 15);
        }
        
        System.out.println("Salud de " + defensor.getNombre() + ": " + defensor.getSalud());
    }
}