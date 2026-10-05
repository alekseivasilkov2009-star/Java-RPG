import java.util.Scanner;
import java.util.HashMap;

public class Game{
    public static void main(String[] args) {
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your name:");
        player.Name = scanner.nextLine();
        System.out.println("Your name is "+player.Name+" now.");

        Spell swordAttack = new Spell();
        swordAttack.data.put("Name", "Sword Attack");
        swordAttack.data.put("Damage", 10);
        player.addSpell(swordAttack);
    }
}