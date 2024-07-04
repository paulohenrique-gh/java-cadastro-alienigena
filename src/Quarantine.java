import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quarantine {
    private static List<Alien> aliens = new ArrayList<>();

    public static void addAlien(Alien alien) {
        aliens.add(alien);
    }

    public static List<Alien> getAliens() {
        return aliens;
    }

    public static void onRegisterNewAlien() {
        for (Alien alien : aliens) {
            alien.setLastMonitoredDate(new Date());
        }
    }
}
