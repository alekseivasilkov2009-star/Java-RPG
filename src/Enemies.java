import java.util.Random;

public class Enemies {

    static Random random = new Random();

    static Enemy skeleton() {
        Enemy skeleton = new Enemy(
                "Skeleton",
                60,
                100,
                0,
                0,
                false,
                true);
        skeleton.addSpell(Spells.bluntHit());
        skeleton.addSpell(Spells.bumpHit());

        return skeleton;
    }

    static Enemy bear() {
        Enemy bear = new Enemy(
                "Bear",
                80,
                150,
                30,
                5,
                true,
                true);

        bear.addSpell(Spells.growl());
        bear.addSpell(Spells.bite());
        bear.addSpell(Spells.scratch());

        return bear;
    }

    static Enemy rat() {
        Enemy rat = new Enemy(
                "Rat",
                35,
                50,
                0,
                10,
                true,
                true);

        rat.addSpell(Spells.bite());
        rat.addSpell(Spells.scratch());
        for (Spell spell : rat.spells) {
            spell.data.put("PoisonTurns", 3);
            spell.data.put("PoisonDamage", 1);
        }

        return rat;
    }

    static Enemy golem() {
        Enemy golem = new Enemy(
                "Golem",
                70,
                100,
                60,
                0,
                false,
                false);

        golem.addSpell(Spells.avalanche());
        golem.addSpell(Spells.rockSlam());

        return golem;
    }

    static Enemy webber() {
        Enemy webber = new Enemy(
                "Webber",
                50,
                100,
                5,
                10,
                true,
                true);

        webber.addSpell(Spells.bite());
        webber.addSpell(Spells.web());

        return webber;
    }

    static Enemy venomousWebber() {
        Enemy venomousWebber = new Enemy(
                "Venomous Webber",
                40,
                100,
                0,
                15,
                true,
                true);

        venomousWebber.addSpell(Spells.bite());
        venomousWebber.addSpell(Spells.web());

        for (Spell spell : venomousWebber.spells) {
            spell.data.put("PoisonTurns", 3);
            spell.data.put("PoisonDamage", 2);
        }

        return venomousWebber;
    }
}
