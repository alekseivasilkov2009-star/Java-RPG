import java.util.HashMap;

public class Spell {
    HashMap<String, Object> data = new HashMap<>();

    void CastSpell(Spell spell, Character caster, Character target) {
        if (caster.Mana >= (int) spell.data.get("NeededMana")) {
            if (spell.data.containsKey("Damage")) {
                target.TakeDamage((int) spell.data.get("Damage") * caster.SpellDamage / 100, (String) spell.data.get("DamageType"));
            }

            if (spell.data.containsKey("StunTurns")) {
                target.StunTurns += (int) spell.data.get("StunTurns");
            }

            if (spell.data.containsKey("Heal")) {
                caster.Heal((int) spell.data.get("Heal"));
            }

            if (spell.data.containsKey("PoisonTurns") && target.CanBePoisoned) {
                if (target.CanBePoisoned) {
                    target.PoisonTurns += (int) spell.data.get("PoisonTurns");
                }
            }

            if (spell.data.containsKey("BleedingTurns") && target.CanBleed) {
                if (target.CanBleed) {
                    target.BleedingTurns += (int) spell.data.get("BleedingTurns");
                }
            }
        }

    }

}
