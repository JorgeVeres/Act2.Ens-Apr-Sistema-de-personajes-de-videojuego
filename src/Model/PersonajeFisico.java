package model;

public abstract class PersonajeFisico extends Personaje {
    public PersonajeFisico(String nombre, int nivel, double salud) {
        super(nombre, nivel, salud);
    }

    public void ataqueFisico() {
        System.out.println(nombre + " realiza un ataque físico básico!");
    }
}