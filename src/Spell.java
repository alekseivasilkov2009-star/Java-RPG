import java.util.HashMap;

public class Spell {
    HashMap<String, Object> data = new HashMap<>();

    String SpellName;

    void castSpell(Character caster, Character target) {

        System.out.println(caster.Name+" has used "+this.SpellName+"!");

        if (this.data.containsKey("Damage")) {
            target.takeDamage((int) this.data.get("Damage"), false);
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

        if (this.data.containsKey("SpeedSetup")) {
            caster.SpeedSetup += (int) this.data.get("SpeedSetup");
        }

        if (this.data.containsKey("DamageSetup")) {
            caster.DamageSetup += (int) this.data.get("DamageSetup");
        }

        if (this.data.containsKey("ProtectionSetup")) {
            caster.ProtectionSetup += (int) this.data.get("ProtectionSetup");
        }

        if (this.data.containsKey("EnemySpeedSetup")) {
            target.SpeedSetup += (int) this.data.get("EnemySpeedSetup");
        }

        if (this.data.containsKey("EnemyDamageSetup")) {
            target.DamageSetup += (int) this.data.get("EnemyDamageSetup");
        }

        if (this.data.containsKey("EnemyProtectionSetup")) {
            target.ProtectionSetup += (int) this.data.get("EnemyProtectionSetup");
        }
    }

}
