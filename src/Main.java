import controllers.Juego;
import model.*;
import view.View;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();

        // Crear 2 personajes de cada tipo
        juego.agregarPersonaje(new Guerrero("Conan", 12, 150, 95, 60, true));
        juego.agregarPersonaje(new Guerrero("Thor", 15, 180, 110, 75, false));
        juego.agregarPersonaje(new Mago("Gandalf", 20, 100, 300, 150));
        juego.agregarPersonaje(new Mago("Merlín", 18, 90, 250, 130));
        juego.agregarPersonaje(new Arquero("Legolas", 14, 120, 100, 30));
        juego.agregarPersonaje(new Arquero("Hawkeye", 12, 110, 90, 25));
        juego.agregarPersonaje(new Hechicero("Saruman", 17, 80, 200, 90));
        juego.agregarPersonaje(new Hechicero("Voldemort", 19, 75, 180, 100));
        juego.agregarPersonaje(new Asesino("Ezio", 16, 100, 100, 3.0));
        juego.agregarPersonaje(new Asesino("Altair", 14, 95, 95, 2.8));

        new View(juego).iniciar(); // Inicia solo la interfaz
    }
}