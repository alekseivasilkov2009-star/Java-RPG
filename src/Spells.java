public class Spells {

    static Spell FireBall() {
        Spell spell = new Spell();

        spell.data.put("Damage", 20);
        spell.data.put("DamageType", "Magical");

        return spell;
    }

    static Spell Freeze() {
        Spell spell = new Spell();

        spell.data.put("Damage", 10);
        spell.data.put("DamageType", "Magical");
        spell.data.put("StunTurns", 2);

        return spell;
    }

    static Spell Heal() {
        Spell spell = new Spell();

        spell.data.put("Heal", 20);

        return spell;
    }

}
