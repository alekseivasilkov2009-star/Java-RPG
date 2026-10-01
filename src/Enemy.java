public class Enemy extends Character {

    Enemy(String Name, int HP, int MeDamage, int MaDamage, int PhysRes, int MagRes, boolean CanBleed, boolean CanPoison, int MP) {
        this.Name = Name;
        this.MaxHealth = HP;
        this.Health = MaxHealth;
        this.MeleeDamage = MeDamage;
        this.SpellDamage = MaDamage;
        this.CanBleed = CanBleed;
        this.CanBePoisoned = CanPoison;
        this.MaxMana = MP;
        this.Mana = MaxMana;

        Characteristic.put("Physical", (int) PhysRes);
        Characteristic.put("Magical", (int) MagRes);
    }

}
