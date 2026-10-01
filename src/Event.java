import java.util.Random;

public class Event {

    public static void StartEventLoop(Player player) {

        while (player.Alive) {
            Random random = new Random();
            int randomEvent = random.nextInt(1, 11);

            if (randomEvent <= 4) {

            }
        }


    }

    void Fight(Player player) {
        Combat fight = new Combat();

    }

    void Village(Player player) {

    }

    void Camp(Player player) {

    }

}
