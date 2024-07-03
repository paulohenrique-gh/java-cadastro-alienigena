public class Specie {
    private String name;
    private Planet originPlanet;
    private int dangerLevel;

    public Specie(String name, Planet originPlanet, int dangerLevel) {
        this.name = name;
        this.originPlanet = originPlanet;
        this.dangerLevel = dangerLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Planet getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(Planet originPlanet) {
        this.originPlanet = originPlanet;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }
}
