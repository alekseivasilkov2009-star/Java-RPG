import java.util.Scanner;
import java.util.HashMap;

public class Game{
    public static void main(String[] args) {
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your name:");
        player.Name = scanner.nextLine();
        System.out.println("Your name is "+player.Name+" now.");

        Spell SwordAttack = new Spell();
        SwordAttack.data.put("Name", "Sword Attack");
        SwordAttack.data.put("DamageType", "Physical");
        SwordAttack.data.put("Damage", 5);
        SwordAttack.data.put("NeededMana", 0);
        player.AddSpell(SwordAttack);
    }
}