import java.util.Scanner;

public class Combat {
    Enemy enemy = Enemies.Skeleton();

    Scanner scanner = new Scanner(System.in);

    void StartFight(Player player) {
        System.out.println("You've been attacked by a "+enemy.Name+"!");
        
        while (enemy.Alive && player.Alive) {

            String PlayerChoice = scanner.nextLine();

            if (player.StunTurns == 0) {
                if (PlayerChoice.contains("1")) {

                } else if (PlayerChoice.contains("2")) {
                    
                } else if (PlayerChoice.contains("3")) {
                    
                } else if (PlayerChoice.contains("4")) {
                    
                }
            }

        }
    }
}
