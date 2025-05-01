package model;

import model.interfaces.Movilizable;
import model.interfaces.Volador;

public class Arquero extends PersonajeFisico implements Volador, Movilizable {
    private int agilidad;
    private int numFlechas;

    public Arquero(String nombre, int nivel, double salud, 
                  int agilidad, int numFlechas) {
        super(nombre, nivel, salud);
        this.agilidad = agilidad;
        this.numFlechas = numFlechas;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " dispara una flecha rápida!");
        numFlechas--;
    }

    public void dispararFlecha() {
        System.out.println(nombre + " dispara una flecha precisa!");
        numFlechas--;
    }

    public void reabastecerFlechas() {
        System.out.println(nombre + " recarga su carcaj!");
        numFlechas += 10;
    }

    @Override
    public void volar() {
        System.out.println(nombre + " vuela ágilmente!");
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " se desplaza sigilosamente!");
    }
}