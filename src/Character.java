import java.util.ArrayList;
import java.util.List;

public class Character {

    String Name;
    int MaxHealth = 1;
    int Health = MaxHealth;
    boolean Alive = true;

    int DamageOutput = 100;
    int CurrentDamageOutput = 100;
    int DamageSetup = 0;

    int Protection = 0;
    int CurrentProtection = 0;
    int ProtectionSetup = 0;

    boolean StunFail = false;
    int StunTurns = 0;

    int PoisonTurns = 0;
    boolean CanPoison = true;
    int PoisonDamage = 0;

    int BleedingTurns = 0;
    boolean CanBleed = true;
    int BleedDamage = 0;

    int Speed = 0;
    int CurrentSpeed = 0;
    int SpeedSetup = 0;

    List<Character> allies = new ArrayList<>();
    List<Character> foes = new ArrayList<>();
    List<Spell> spells = new ArrayList<>();

    void takeDamage(int damage, boolean isTickDamage) {
        int finalDamage;
        if (!isTickDamage) {
            finalDamage = damage * DamageOutput / 100 - (damage * Protection / 100);
        } else {
            finalDamage = damage;
        }

        Health -= finalDamage;
        if (Health <= 0) {
            Health = 0;
            Alive = false;
        }
    }

    void heal(int Heal) {
        Health += Heal;
        if (Health > MaxHealth) {
            Health = MaxHealth;
        }
    }

    void addAlly(Character ally) {
        allies.add(ally);
    }

    void addFoe(Character foe) {
        foes.add(foe);
    }

    void turnStatuses() {
        if (StunTurns > 0) {
            StunTurns --;
        }

        if (BleedingTurns > 0) {
            BleedingTurns --;
            takeDamage(BleedDamage + (MaxHealth * 2 / 100), true);
            System.out.println(Name+" took "+BleedDamage + (MaxHealth * 2 / 100)+" bleed damage, this will last for another "+BleedingTurns+" turns!");
        }

        if (PoisonTurns > 0) {
            PoisonTurns --;
            takeDamage(PoisonDamage, true);
            System.out.println(Name+" took "+PoisonDamage+" poison damage, this will last for another "+PoisonTurns+" turns!");
        }

        if (SpeedSetup > 0) {
            CurrentSpeed = Speed + (5 * SpeedSetup);
        }

        if (DamageSetup > 0) {

            CurrentDamageOutput = DamageOutput + (10 * DamageSetup);
        }

        if (ProtectionSetup > 0) {

            CurrentProtection = Protection + (10 * ProtectionSetup);
        }

    }

    void addSpell(Spell spell) {
        spells.add(spell);
    }

    void clearCharacter() {
        this.Health = MaxHealth;
        this.CurrentDamageOutput = DamageOutput;
        this.CurrentProtection = Protection;
        this.CurrentSpeed = Speed;

        this.ProtectionSetup = 0;
        this.SpeedSetup = 0;
        this.DamageSetup = 0;

        this.PoisonDamage = 0;
        this.PoisonTurns = 0;

        this.BleedDamage = 0;
        this.BleedingTurns = 0;

        this.DamageSetup = 0;
        this.ProtectionSetup = 0;
    }
}
