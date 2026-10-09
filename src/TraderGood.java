import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.ArrayList;

public class TraderGood {

    static Random random = new Random();

    List<Supplier<Spell>> spells = new ArrayList<>(List.of(
            Spells::tailwind,
            Spells::freeze,
            Spells::venomSting,
            Spells::heal
    ));

    void getRandomSpell(Player player) {
        if (player.Gold >= player.SpellPrice && spells.size() > 0) {
            int index = random.nextInt(spells.size());

            Spell spell = spells.get(index).get();

            spells.remove(index);
            player.addSpell(spell);
            player.changeGold(-player.SpellPrice);
            player.SpellPrice += 1000;
            System.out.println("You've successfully bought the "+spell.SpellName+" spell!");
        } else if (player.Gold >= player.SpellPrice && spells.size() == 0) {
            System.out.println("The trader doesn't have any more spells for you");
        } else if (player.Gold < player.SpellPrice && spells.size() > 0) {
            System.out.println("You don't have enough gold to buy a spell from the trader");
        } else {
            System.out.println("You don't have enough gold and neither does the trader have any more spells for sale");
        }
        System.out.println(player.Gold);
    }

    void upgradeDamage(Player player) {
        if (player.Gold >= player.DamagePrice) {
            player.DamageOutput += 5;
            player.DamagePrice += 100;
            player.changeGold(-player.DamagePrice);
            System.out.println("You've successfully bought the damage upgrade\nDamage: "+player.DamageOutput);
        } else {
            System.out.println("You don't have enough gold to buy a damage upgrade from the trader");
        }
        System.out.println(player.Gold);
    }

    void upgradeProtection(Player player) {
        if (player.Gold >= player.DurabilityPrice) {
            player.Protection += 5;
            player.MaxHealth += 5;
            player.Health = player.MaxHealth;
            player.DurabilityPrice += 100;

            if (player.Protection >= 100) {
                player.Protection = 99;
            }
            player.changeGold(-player.DurabilityPrice);
            System.out.println("You've successfully bought the durability upgrade\nProtection: "+player.Protection+"\nHealth: "+player.MaxHealth+"/"+player.Health);
        } else {
            System.out.println("You don't have enough gold to buy a durability upgrade from the trader");
        }
        System.out.println(player.Gold);
    }
}
