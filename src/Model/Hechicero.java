package model;

import model.interfaces.Defendible;
import model.interfaces.Magico;

public class Hechicero extends PersonajeMagico implements Magico, Defendible {
    private int mana;
    private int concentracion;

    public Hechicero(String nombre, int nivel, double salud, 
                    int mana, int concentracion) {
        super(nombre, nivel, salud);
        this.mana = mana;
        this.concentracion = concentracion;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " lanza un hechizo oscuro!");
        mana -= 15;
    }

    public void invocarEntidad() {
        System.out.println(nombre + " invoca un demonio!");
        mana -= 50;
    }

    @Override
    public void defender() {
        System.out.println(nombre + " crea un escudo mágico!");
    }

    @Override
    public double lanzarHechizo() {
        System.out.println(nombre + " lanza un hechizo elemental!");
        return mana -= 25;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void usarMana(int i) {
        if (i <= mana) {
            mana -= i;
            System.out.println(nombre + " usa " + i + " de maná!");
        } else {
            System.out.println(nombre + " no tiene suficiente maná!");
        }
        System.out.println("Mana restante: " + mana);
    }
}