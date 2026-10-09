import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Event {

    static Random random = new Random();

    void fight(Player player, Scanner scanner) {
        Combat fight = new Combat();
        fight.startFight(player, false, scanner);
    }

    void bossFight(Player player, Scanner scanner) {
        Combat fight = new Combat();
        fight.startFight(player, true, scanner);
    }

    static TraderGood trader = new TraderGood();

    void village(Player player, Scanner scanner) {
        System.out.println("You've reached a small village. There you rest for a while, restoring your health fully. On the village's market you could buy something useful...");
        player.sellItems();
        player.heal(player.MaxHealth);
        player.CampaignProgress ++;

        System.out.println("At the market you see various goods. Your eye is caught by a adventurer trader that has everything, from spells to equipment.");
        System.out.println("Type 1 to buy a random spell that the trader has to offer\nType 2 to buy an upgrade for your damage output\nType 3 to buy an upgrade for your survivability\nType 4 to leave");
        System.out.println(player.Gold);
        int choice;

        while (!scanner.hasNextInt()) {
            System.out.println("Please type in a valid option!");
            scanner.next();
        }

        choice = scanner.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("Please type in a valid option!");
            choice = scanner.nextInt();
        }

        while (choice < 4) {
            if (choice == 1) {
                trader.getRandomSpell(player);
            } else if (choice == 2) {
                trader.upgradeDamage(player);
            } else if (choice == 3) {
                trader.upgradeProtection(player);
            }
            choice = scanner.nextInt();
        }

        System.out.println("You leave the village...");

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
            player.addPartyMember(ally);
            System.out.println(ally.Name+" has joined your party!");
            System.out.println(player.party.size());
        }
    }

    void startEventLoop(Player player, Scanner scanner) {

        while (player.Alive && player.CampaignProgress < 100) {
            int randomEvent = random.nextInt(1, 11);

            if (randomEvent <= 6) {
                if (player.CampaignProgress < 90) {
                    fight(player, scanner);
                } else {
                    bossFight(player, scanner);
                }
            } else if (randomEvent > 6 && randomEvent < 8) {
                village(player, scanner);
            } else if (randomEvent > 8) {
                camp(player);
            }
        }

        if (player.Alive && player.CampaignProgress == 100) {
            System.out.println("YOU WON!");
        }
    }
}
