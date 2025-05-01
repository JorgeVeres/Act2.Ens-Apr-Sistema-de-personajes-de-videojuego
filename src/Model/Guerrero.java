package model;

import model.interfaces.Defendible;

public class Guerrero extends PersonajeFisico implements Defendible {
    private int fuerza;
    private int armadura;
    private boolean escudo;

    public Guerrero(String nombre, int nivel, double salud, 
                   int fuerza, int armadura, boolean escudo) {
        super(nombre, nivel, salud);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo = escudo;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con fuerza " + fuerza + "!");
    }

    public void cargarAtaque() {
        System.out.println(nombre + " carga un ataque poderoso!");
        fuerza += 10;
    }

    @Override
    public void defender() {
        System.out.println(nombre + " defiende con " + 
                          (escudo ? "escudo" : "armadura") + "!");
    }
}