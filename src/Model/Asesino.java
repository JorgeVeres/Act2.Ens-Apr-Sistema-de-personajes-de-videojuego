package model;

import model.interfaces.Curable;
import model.interfaces.Movilizable;

public class Asesino extends PersonajeFisico implements Movilizable, Curable {
    private int sigilo;
    private double critico;

    public Asesino(String nombre, int nivel, double salud, 
                  int sigilo, double critico) {
        super(nombre, nivel, salud);
        this.sigilo = sigilo;
        this.critico = critico;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " realiza un ataque sigiloso!");
    }

    public void atacarPorLaEspalda() {
        System.out.println(nombre + " ataca por la espalda con crítico!");
        critico *= 1.5;
    }

    public void ocultar() {
        System.out.println(nombre + " se oculta en las sombras!");
        sigilo += 20;
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " se teletransporta rápidamente!");
    }

    @Override
    public void curar() {
        System.out.println(nombre + " usa una poción curativa!");
        setSalud(getSalud() + 15);
    }
}