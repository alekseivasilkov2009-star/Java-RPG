import java.util.DuplicateFormatFlagsException;

public class Enemy extends Character {

    public static int Difficulty = 1;

    Enemy(String Name, int HP, int MeDamage, int MaDamage, int PhysRes, int MagRes, boolean CanBleed, boolean CanPoison, int MP, int SPD) {
        this.Name = Name;
        this.MaxHealth = HP * Difficulty;
        this.Health = MaxHealth;
        this.MeleeDamage = MeDamage * Difficulty;
        this.SpellDamage = MaDamage * Difficulty;
        this.CanBleed = CanBleed;
        this.CanBePoisoned = CanPoison;
        this.MaxMana = MP * Difficulty;
        this.Mana = MaxMana;
        this.Speed = SPD;

        Characteristic.put("Physical", (int) PhysRes);
        Characteristic.put("Magical", (int) MagRes);
    }

}
