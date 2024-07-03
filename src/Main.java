import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Planet> planets = new ArrayList<>();
        List<Specie> species = new ArrayList<>();
        List<Alien> aliens = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            System.out.println("Digite uma opção: ");
            System.out.println("1 - Registrar alienígena");
            System.out.println("2 - Registrar espécie");
            System.out.println("3 - Avaliar periculosidade");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    registerNewAlien(scanner, species, aliens, planets);
                    break;
                case "2":
                    registerSpecies(scanner, species, planets);
                    break;
                case "3":
                    evaluateDangerLevels(aliens);
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    public static void registerNewAlien(Scanner scanner, List<Specie> species, List<Alien> aliens, List<Planet> planets) {
        System.out.println("Informe a ID do alienígena: ");
        String id = scanner.nextLine();
        System.out.println("Informe o nome do alienígena: ");
        String name = scanner.nextLine();
        Specie specie;

        if (species.isEmpty()) {
            System.out.println("É necessário uma espécie antes de cadastrar um alienígena.");
            return;
        }

        System.out.println("Escolha uma opção de espécie: ");
        specie = chooseSpecies(scanner, species);
        int dangerLevel = getDangerLevel(scanner);
        Alien alien = new Alien(id, name, specie, dangerLevel, new Date());
        aliens.add(alien);
    }

    public static void registerSpecies(Scanner scanner, List<Specie> species, List<Planet> planets) {
        System.out.println("Informe o nome da espécie: ");
        String name = scanner.nextLine();
        System.out.println("Informe o planeta de origem: ");
        String planetName = scanner.nextLine();
        Planet planet = findPlanet(planetName, planets);

        if (planet == null) {
            planet = new Planet(planetName);
        }

        int dangerLevel = getDangerLevel(scanner);

        Specie specie = new Specie(name, planet, dangerLevel);
        species.add(specie);
    }

    public static void evaluateDangerLevels(List<Alien>aliens) {
        for (Alien alien : aliens) {
            alien.showData();
            System.out.println("=========");
        }
    }

    public static Planet findPlanet(String name, List<Planet> planets) {
        Planet planet = null;

        for (Planet p : planets) {
            if (p.getName().equals(name)) {
                planet = p;
                return planet;
            }
        }

        return planet;
    }

    public static int getDangerLevel(Scanner scanner) {
        int dangerLevel = 0;

        System.out.println("Informe o nível de periculosidade:");

        while (dangerLevel < 1 || dangerLevel > 10) {
            try {
                dangerLevel = Integer.parseInt(scanner.nextLine());

                if (dangerLevel < 1 || dangerLevel > 10) {
                    System.out.println("Opção inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida");
            }
        }

        return dangerLevel;
    }

    public static Specie chooseSpecies(Scanner scanner, List<Specie> species) {
        for (int i = 0; i < species.size(); i++) {
            System.out.println(i + 1 + " - " + species.get(i).getName());
        }

        int speciesIndex = 0;

        while (speciesIndex <= 0 || speciesIndex > species.size()) {
            try {
                speciesIndex = Integer.parseInt(scanner.nextLine());
                if (speciesIndex <= 0 || speciesIndex > species.size()) {
                    System.out.println("Opção inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida");
            }
        }

        return species.get(speciesIndex - 1);
    }
}