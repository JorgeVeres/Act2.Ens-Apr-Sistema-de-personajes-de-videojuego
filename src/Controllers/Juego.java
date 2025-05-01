package controllers;

import java.util.ArrayList;
import java.util.List;

import model.Personaje;
import model.Interfaces.*;

public class Juego {
    private ArrayList<Personaje> personajes = new ArrayList<>();

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public void mostrarAcciones() {
        System.out.println("\n=== ACCIONES DE PERSONAJES ===");
        for (Personaje p : personajes) {
            System.out.println("\n--- " + p.toString() + " ---");
            p.atacar();
            
            if (p instanceof Defendible) ((Defendible) p).defender();
            if (p instanceof Curable) ((Curable) p).curar();
            if (p instanceof Magico) ((Magico) p).lanzarHechizo();
            if (p instanceof Movilizable) ((Movilizable) p).moverse();
            if (p instanceof Volador) ((Volador) p).volar();
        }
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
}