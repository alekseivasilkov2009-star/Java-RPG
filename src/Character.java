import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Character {

    String Name;
    int MaxHealth;
    int Health;
    boolean Alive = true;
    int MeleeDamage = 100;
    int SpellDamage = 100;
    int StunTurns;
    int PoisonTurns;
    int BleedingTurns;
    int MaxMana;
    int Mana;
    boolean CanBePoisoned = true;
    boolean CanBleed = true;

    List<Spell> spells = new ArrayList<>();

    HashMap<String, Object> Characteristic = new HashMap<>();

    void TakeDamage(int Damage, String DamageType) {
        int Resistance = (int) Characteristic.get(DamageType);
        int FinalDamage = Damage - (Damage * Resistance / 100);

        Health -= FinalDamage;
        if (Health <= 0) {
            Health = 0;
            Alive = false;
        }
    }

    void Heal(int Heal) {
        Health += Heal;
        if (Health > MaxHealth) {
            Health = MaxHealth;
        }
    }

    void ChangeResistance(int ResistanceValue, String ResistanceName) {
        int Resistance = (int) Characteristic.get(ResistanceName);
        Resistance += ResistanceValue;

        if (Resistance >= 100) {
            Resistance = 99;
        }

        Characteristic.put(ResistanceName, Resistance);
    }
}
