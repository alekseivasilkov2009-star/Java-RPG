public class Enemy extends Character {

    public static int Difficulty = 1;

    Enemy(String Name, int HP, int DMG, int PRT, int SPD, boolean CanBleed,boolean CanPoison) {
        this.Name = Name;
        this.MaxHealth = HP * Difficulty;
        this.Health = MaxHealth;
        this.DamageOutput = DMG;
        this.CurrentDamageOutput = DamageOutput;
        this.Protection = PRT;
        this.CurrentProtection = Protection;
        this.CanBleed = CanBleed;
        this.CanPoison = CanPoison;
        this.Speed = SPD;
        this.CurrentSpeed = Speed;
    }

}
