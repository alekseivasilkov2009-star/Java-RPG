public class Player extends Character{

    int Level = 1;
    int Expirience = 0;
    int Gold = 0;

    void ChangeGold(int GoldValue) {
        Gold += GoldValue;
        if (Gold < 0) {
            Gold = 0;
        }
    }

    void AddSpell(Spell spell) {
        spells.add(spell);
        System.out.println(Name+" has received the "+spell.data.get("Name")+"!");
    }

}
