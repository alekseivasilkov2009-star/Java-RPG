import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Event {

    static Random random = new Random();

    void fight(Player player) {
        Combat fight = new Combat();
        fight.startFight(player, false);
    }

    void bossFight(Player player) {
        Combat fight = new Combat();
        fight.startFight(player, true);
    }

    void village(Player player) {
        System.out.println("You've reached a small village. There you rest for a while, restoring your health fully. On the village's market you could buy something useful...");
        player.sellItems();
        player.heal(player.MaxHealth);
        player.CampaignProgress ++;

        Scanner scanner = new Scanner(System.in);

        System.out.println("At the market you see various goods. Your eye is caught by a adventurer trader that has everything, from spells to equipment.\nType in 1-4 for the corresponding item that is offered or 5 to leave and go on with your adventures.");
        while (!scanner.hasNextInt()) {
            System.out.println("Please type in a number!");
            scanner.nextLine();
        }

        if (scanner.nextInt() == 1) {

        }
    }

    void camp(Player player) {
        System.out.println("You've reached a small camp in the woods. You rest here for a while, restoring some of your health.");
        player.heal(player.MaxHealth / 4);
        if (random.nextInt(1, 5) == 1) {
            System.out.println("There was someone in at the camp too.");
        }
        player.CampaignProgress ++;

        List<Supplier<PartyMember>> possibleAllies = List.of(
                Allies::crusader,
                Allies::wizard,
                Allies::juggernaut,
                Allies::ratMan
        );

        Character ally = possibleAllies.get(random.nextInt(possibleAllies.size())).get();
        System.out.println("The person was a "+ally.Name+" he will join you if your party isn't full already.");
        if (player.allies.size() < 4) {
            player.addAlly(ally);
            System.out.println(ally.Name+" has joined your party!");
        }
    }

    void startEventLoop(Player player) {

        while (player.Alive) {
            int randomEvent = random.nextInt(1, 11);

            if (randomEvent <= 6) {
                if (player.CampaignProgress >= 95) {
                    fight(player);
                }
            } else if (randomEvent > 6 && randomEvent < 8) {
                village(player);
            } else if (randomEvent > 8) {
                camp(player);
            }
        }

    }
}
