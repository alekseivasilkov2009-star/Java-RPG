import java.util.ArrayList;
import java.util.List;

public class Player extends Character{

    List<Character> party = new ArrayList<>();
    List<Item> inventory = new ArrayList<>();

    int Level = 1;
    int Experience = 0;
    int NeededExperience = 100;
    int ExpMultiplier;
    int SellingMultiplier = 1;
    int Gold = 0;
    int InventoryCapacity = 20;

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

    void AddPartyMember(Character partyMember) {
        if (party.size() < 4) {
            party.add(partyMember);
        }
    }

    void RemovePartyMember(Character partyMember) {
        party.remove(partyMember);
    }

    void AddItem(Item item) {
        if (inventory.size() < InventoryCapacity) {
            inventory.add(item);
        }
    }

    void RemoveItem(Item item) {
        inventory.remove(item);
    }

    void IncreaseExp(int experience) {
        int FinalExp = Experience + (experience * ExpMultiplier);
        if (FinalExp >= NeededExperience) {
            int excess = Experience - NeededExperience;
            Experience = excess;
            Level ++;
        }
    }
}
