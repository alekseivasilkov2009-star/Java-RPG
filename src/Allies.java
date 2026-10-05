public class Allies {

    static PartyMember crusader() {
        PartyMember nobleKnight = new PartyMember(
                "Crusader",
                75,
                100,
                20,
                7,
                true,
                true);

        nobleKnight.addSpell(Spells.holyStrike());
        nobleKnight.addSpell(Spells.shieldYourself());
        nobleKnight.addSpell(Spells.shieldbash());

        return nobleKnight;
    }

    static PartyMember wizard() {
        PartyMember wizard = new PartyMember(
                "Wizard",
                70,
                100,
                0,
                7,
                true,
                true);

        wizard.addSpell(Spells.freeze());
        wizard.addSpell(Spells.explosion());
        wizard.addSpell(Spells.timeDilation());
        wizard.addSpell(Spells.wisdom());

        return wizard;
    }

    static PartyMember juggernaut() {
        PartyMember juggernaut = new PartyMember(
                "Juggernaut",
                200,
                100,
                0,
                1,
                true,
                true);

        juggernaut.addSpell(Spells.rest());
        juggernaut.addSpell(Spells.haymaker());

        return juggernaut;
    }

    static PartyMember ratMan() {
        PartyMember ratMan = new PartyMember(
                "Rat-Man",
                65,
                170,
                0,
                21,
                true,
                true);

        ratMan.addSpell(Spells.scratch());
        ratMan.addSpell(Spells.bite());

        for (Spell spell : ratMan.spells) {
            spell.data.put("PoisonTurns", 5);
            spell.data.put("PoisonDamage", 5);
        }

        return ratMan;
    }
}
