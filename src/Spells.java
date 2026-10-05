import java.util.Random;

public class Spells {

    static Random random = new Random();

    static Spell haymaker() {
        Spell spell = new Spell();
        spell.SpellName = "Haymaker";
        spell.data.put("Damage", 20);

        return spell;
    }

    static Spell rest() {
        Spell spell = new Spell();
        spell.SpellName = "Rest";
        spell.data.put("Heal", 1);

        return spell;
    }

    static Spell holyStrike() {
        Spell spell = new Spell();
        spell.SpellName = "Holy Strike";
        spell.data.put("Damage", 10);
        spell.data.put("Heal", 10);

        return spell;
    }

    static Spell shieldYourself() {
        Spell spell = new Spell();
        spell.SpellName = "Shield Yourself";
        spell.data.put("ProtectionSetUp", 2);

        return spell;
    }

    static Spell shieldbash() {
        Spell spell = new Spell();
        spell.SpellName = "Shieldb";
        spell.data.put("StunTurns", 1);

        return spell;
    }

    static Spell tailwind() {
        Spell spell = new Spell();
        spell.SpellName = "Tailwind";
        spell.data.put("SpeedSetUp", 2);

        return spell;
    }

    static Spell explosion() {
        Spell spell = new Spell();
        spell.SpellName = "Explosion";
        spell.data.put("Damage", 30);

        return spell;
    }

    static Spell timeDilation() {
        Spell spell = new Spell();
        spell.SpellName = "Time Dilation";
        spell.data.put("Damage", 5);
        spell.data.put("EnemySpeedSetup", -2);

        return spell;
    }

    static Spell wisdom() {
        Spell spell = new Spell();
        spell.SpellName = "Wisdom";
        spell.data.put("DamageSetUp", 2);

        return spell;
    }

    static Spell freeze() {
        Spell spell = new Spell();
        spell.SpellName = "Freeze";
        spell.data.put("Damage", 10);
        spell.data.put("StunTurns", 1);

        return spell;
    }

    static Spell heal() {
        Spell spell = new Spell();
        spell.SpellName = "Heal";
        spell.data.put("Heal", 25);

        return spell;
    }

    static Spell venomSting() {
        Spell spell = new Spell();
        spell.SpellName = "Venom Sting";
        spell.data.put("Damage", 5);
        spell.data.put("PoisonTurns", 5);
        spell.data.put("PoisonDamage", 5);

        return spell;
    }

    static Spell scratch() {
        Spell spell = new Spell();
        spell.SpellName = "Scratch";
        spell.data.put("Damage", 10);
        spell.data.put("BleedingTurns", 2);
        spell.data.put("BleedDamage", 1);

        return spell;
    }

    static Spell growl() {
        Spell spell = new Spell();
        spell.SpellName = "Growl";
        spell.data.put("Damage", 5);
        spell.data.put("EnemySpeedSetUp", -1);

        return spell;
    }

    static Spell bluntHit() {
        Spell spell = new Spell();
        spell.SpellName = "Blunt Hit";
        spell.data.put("Damage", 7);
        spell.data.put("StunTurns", 1);

        return spell;
    }

    static Spell bumpHit() {
        Spell spell = new Spell();
        spell.SpellName = "Bump Hit";
        spell.data.put("Damage", 5);

        return spell;
    }

    static Spell bite() {
        Spell spell = new Spell();
        spell.SpellName = "Bite";
        spell.data.put("Damage", 10);
        spell.data.put("BleedingTurns", 4);
        spell.data.put("BleedDamage", 1);

        return spell;
    }

    static Spell avalanche() {
        Spell spell = new Spell();
        spell.SpellName = "Avalanche";
        spell.data.put("Damage", 5);
        spell.data.put("StunTurns", 1);
        spell.data.put("ProtectionSetUp", -1);
        spell.data.put("DamageSetUp", 1);

        return spell;
    }

    static Spell rockSlam() {
        Spell spell = new Spell();
        spell.SpellName = "Rock Slam";
        spell.data.put("Damage", 10);

        return spell;
    }

    static Spell swordCleave() {
        Spell spell = new Spell();
        spell.SpellName = "Sword Cleave";
        spell.data.put("Damage", 10);
        spell.data.put("BleedingTurns", 1);
        spell.data.put("BleedDamage", 10);

        return spell;
    }

    static Spell slicingSpin() {
        Spell spell = new Spell();
        spell.SpellName = "Slicing Spin";
        spell.data.put("Damage", 25);
        spell.data.put("SpeedSetup", 1);

        return spell;
    }

    static Spell leer() {
        Spell spell = new Spell();
        spell.SpellName = "Leer";
        spell.data.put("Damage", 5);
        spell.data.put("Heal", 5);
        spell.data.put("EnemyProtectionSetup", -1);

        return spell;
    }

    static Spell web() {
        Spell spell = new Spell();
        spell.SpellName = "Web";
        spell.data.put("Damage", 2);
        spell.data.put("StunTurns", 1);

        return spell;
    }
}
