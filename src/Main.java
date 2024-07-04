import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SystemManager systemManager = new SystemManager();

        boolean flag = true;
        System.out.println("CADASTRO INTERPLANETÁRIO\n");

        while (flag) {
            System.out.println("Digite uma opção: ");
            System.out.println("1 - Registrar alienígena");
            System.out.println("2 - Registrar espécie");
            System.out.println("3 - Avaliar periculosidade");
            System.out.println("4 - Mostrar relatório");
            System.out.println("5 - Sair");

            String opcao = systemManager.getScanner().nextLine();

            switch (opcao) {
                case "1":
                    registerNewAlien(systemManager);
                    break;
                case "2":
                    registerSpecies(systemManager);
                    break;
                case "3":
                    evaluateDangerLevel(systemManager);
                    break;
                case "4":
                    showReport(systemManager);
                    break;
                case "5":
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    public static void registerNewAlien(SystemManager systemManager) {
        Scanner scanner = systemManager.getScanner();
        List<Specie> species = systemManager.getSpecies();

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
        specie = chooseSpecies(systemManager);
        int dangerLevel = getDangerLevel(systemManager);
        Alien alien = new Alien(id, name, specie, dangerLevel, new Date());
        systemManager.addAlien(alien);
    }

    public static void registerSpecies(SystemManager systemManager) {
        Scanner scanner = systemManager.getScanner();

        System.out.println("Informe o nome da espécie: ");
        String name = scanner.nextLine();
        System.out.println("Informe o planeta de origem: ");
        String planetName = scanner.nextLine();
        Planet planet = findPlanet(planetName, systemManager);

        if (planet == null) {
            planet = new Planet(planetName);
            systemManager.addPlanet(planet);
        }

        int dangerLevel = getDangerLevel(systemManager);

        Specie specie = new Specie(name, planet, dangerLevel);
        systemManager.addSpecie(specie);
    }

    public static void evaluateDangerLevel(SystemManager systemManager) {
        Scanner scanner = systemManager.getScanner();
        List<Alien> aliens = systemManager.getAliens();

        Alien alien;

        while(true) {
            System.out.println("Informe o nome do alienígena:");
            String name = scanner.nextLine();

            for (Alien a : aliens) {
                if (a.getName().equalsIgnoreCase(name)) {
                    alien = a;
                    System.out.println("Nível de periculosidade: " + alien.getAverageDangerLevel());
                    return;
                }
            }

            System.out.println("Alienígena não localizado");
        }

    }

    public static Planet findPlanet(String name, SystemManager systemManager) {
        List<Planet> planets = systemManager.getPlanets();

        Planet planet = null;

        for (Planet p : planets) {
            if (p.getName().equals(name)) {
                planet = p;
                return planet;
            }
        }

        return planet;
    }

    public static int getDangerLevel(SystemManager systemManager) {
        Scanner scanner = systemManager.getScanner();

        int dangerLevel = 0;

        System.out.println("Informe o nível de periculosidade de 1 a 10:");

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

    public static Specie chooseSpecies(SystemManager systemManager) {
        Scanner scanner = systemManager.getScanner();
        List<Specie> species = systemManager.getSpecies();

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

    public static void showReport(SystemManager systemManager) {
        List<Alien> aliens = systemManager.getAliens();

        for (Alien alien : aliens) {
            alien.showData();
            System.out.println("=========");
        }
    }
}