import java.util.Date;

public class Alien {
    private String id;
    private String name;
    private Specie specie;
    private int dangerLevel;
    private Date entryDate;
    private Date lastMonitoredDate;

    public Alien(String id, String name, Specie specie, int dangerLevel, Date entryDate) {
        this.id = id;
        this.name = name;
        this.specie = specie;
        this.dangerLevel = dangerLevel;
        this.entryDate = entryDate;
        this.lastMonitoredDate = entryDate;
        this.validateRisk();
        Quarantine.onRegisterNewAlien();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getLastMonitoredDate() {
        return lastMonitoredDate;
    }

    public void setLastMonitoredDate(Date lastMonitoredDate) {
        this.lastMonitoredDate = lastMonitoredDate;
    }

    private void validateRisk() {
        if (this.isDangerous()) {
            Quarantine.addAlien(this);
        }
    }

    private boolean isDangerous() {
        return this.getDangerLevel() >= 7;
    }

    public void showData() {
        System.out.println("Nome: " + this.name + "\nEspecie: " + this.specie.getName() +
                "\nNivel de periculosidade: " + this.getAverageDangerLevel() +
                "\nStatus: " + (this.isInQuarantine() ? " em quarentena" : "fora de quarentena"));
    }

    public int getAverageDangerLevel() {
        return (this.getDangerLevel() + this.specie.getDangerLevel()) / 2;
    }

    private boolean isInQuarantine() {
        for (Alien alien : Quarantine.getAliens()) {
            if (alien.equals(this)) {
                return true;
            }
        }

        return false;
    }
}
