import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class TraderGood {

    static Random random = new Random();

    List<Supplier<Spell>> spells = List.of(
            Spells::tailwind,
            Spells::freeze,
            Spells::venomSting,
            Spells::heal
    );

    void getRandomSpell(Player player) {

        int index = random.nextInt(spells.size());

        Spell spell = spells.get(index).get();

        spells.remove(index);
        player.addSpell(spell);
        player.SpellPrice += 1000;
    }

    void upgradeDamage(Player player) {
        player.DamageOutput += 5;
        player.DamagePrice += 100;
    }

    void upgradeProtection(Player player) {
        player.Protection += 5;
        player.MaxHealth += 5;
        player.Health = player.MaxHealth;
        player.DurabilityPrice += 100;
    }
}
