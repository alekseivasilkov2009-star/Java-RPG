import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class TraderGood {

    static Random random = new Random();

    void getRandomSpell() {
        List<Supplier<Spell>> spells = List.of(
                Spells::tailwind,
                Spells::freeze,
                Spells::venomSting,
                Spells::heal
        );
        Spell spell = spells.get(random.nextInt(spells.size())).get();

    }
}
