import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemManager {
    private Scanner scanner;
    private List<Planet> planets;
    private List<Specie> species;
    private List<Alien> aliens;

    public SystemManager() {
        this.scanner = new Scanner(System.in);
        this.planets = new ArrayList<>();
        this.species = new ArrayList<>();
        this.aliens = new ArrayList<>();
    }

    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }

    public void addSpecie(Specie specie) {
        this.species.add(specie);
    }

    public void addAlien(Alien alien) {
        this.aliens.add(alien);
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public List<Specie> getSpecies() {
        return species;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
