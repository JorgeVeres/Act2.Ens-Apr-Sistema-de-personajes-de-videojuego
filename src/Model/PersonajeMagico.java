package model;

public abstract class PersonajeMagico extends Personaje {
    public PersonajeMagico(String nombre, int nivel, double salud) {
        super(nombre, nivel, salud);
    }

    public void regenerarEnergia() {
        System.out.println(nombre + " regenera energía mágica!");
    }
}