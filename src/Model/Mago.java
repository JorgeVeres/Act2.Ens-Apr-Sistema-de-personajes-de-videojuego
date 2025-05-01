package model;

import model.interfaces.Curable;
import model.interfaces.Magico;

public class Mago extends PersonajeMagico implements Magico, Curable {
    private int mana;
    private int sabiduria;

    public Mago(String nombre, int nivel, double salud, 
               int mana, int sabiduria) {
        super(nombre, nivel, salud);
        this.mana = mana;
        this.sabiduria = sabiduria;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " lanza un hechizo básico!");
        mana -= 10;
    }

    @Override
    public double lanzarHechizo() {
        System.out.println(nombre + " invoca un hechizo poderoso!");
        return mana -= 30;
    }

    public void regenerarMana() {
        System.out.println(nombre + " regenera 50 de maná!");
        mana += 50;
    }

    @Override
    public void curar() {
        System.out.println(nombre + " cura sus heridas!");
        setSalud(getSalud() + 20);
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