import java.util.HashMap;

public class Spell {
    HashMap<String, Object> data = new HashMap<>();

    String SpellName;

    void castSpell(Character caster, Character target) {

        System.out.println(caster.Name+" has used "+this.SpellName+"!");

        if (this.data.containsKey("Damage")) {
            target.takeDamage((int) this.data.get("Damage") * caster.DamageOutput / 100, false);
        }

        if (this.data.containsKey("StunTurns")) {
            if (!caster.StunFail) {
                target.StunTurns += (int) this.data.get("StunTurns");
                caster.StunFail = true;
            } else {
                caster.StunFail = false;
            }
        }

        if (this.data.containsKey("Heal")) {
            caster.heal((int) this.data.get("Heal"));
        }

        if (this.data.containsKey("PoisonTurns") && target.CanPoison) {
            target.PoisonTurns += (int) this.data.get("PoisonTurns");
            target.PoisonDamage += (int) this.data.get("PoisonDamage");
        }

        if (this.data.containsKey("BleedingTurns") && target.CanBleed) {
            target.BleedingTurns += (int) this.data.get("BleedingTurns");
            target.BleedDamage += (int) this.data.get("BleedDamage");
        }

        if (this.data.containsKey("SpeedSetUp")) {
            caster.SpeedSetup += (int) this.data.get("SpeedSetUp");
        }

        if (this.data.containsKey("DamageSetUp")) {
            caster.DamageSetup += (int) this.data.get("DamageSetUp");
        }

        if (this.data.containsKey("ProtectionSetUp")) {
            caster.ProtectionSetup += (int) this.data.get("ProtectionSetUp");
        }

        if (this.data.containsKey("EnemySpeedSetUp")) {
            target.SpeedSetup += (int) this.data.get("EnemySpeedSetUp");
        }

        if (this.data.containsKey("EnemyDamageSetUp")) {
            target.DamageSetup += (int) this.data.get("EnemyDamageSetUp");
        }

        if (this.data.containsKey("EnemyProtectionSetUp")) {
            target.ProtectionSetup += (int) this.data.get("EnemyProtectionSetUp");
        }
    }

}
