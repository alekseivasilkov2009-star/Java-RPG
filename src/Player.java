import java.util.ArrayList;
import java.util.List;

public class Player extends Character{

    List<Character> party = new ArrayList<>();
    List<Item> inventory = new ArrayList<>();

    int SpellPrice = 1000;
    int DamagePrice = 100;
    int DurabilityPrice = 100;

    int Level = 1;
    int Experience = 0;
    int NeededExperience = 100;
    int ExpMultiplier;
    int SellingMultiplier = 1;
    int Gold = 0;
    int InventoryCapacity = 20;
    int CampaignProgress = 0;

    void changeGold(int GoldValue) {
        Gold += GoldValue;
        if (Gold < 0) {
            Gold = 0;
        }
    }

    void sellItems() {
        for (Item item : inventory) {
            inventory.remove(item);
            Gold += item.GoldWorth * SellingMultiplier;
        }
    }

    void addPartyMember(Character partyMember) {
        if (party.size() < 4) {
            party.add(partyMember);
        } else {
            System.out.println("Your party is full right now, therefore the "+partyMember.Name+" couldn't join you.");
        }
    }

    void removePartyMember(Character partyMember) {
        party.remove(partyMember);
    }

    void addItem(Item item) {
        if (inventory.size() < InventoryCapacity) {
            inventory.add(item);
        }
    }

    void removeItem(Item item) {
        inventory.remove(item);
    }

    void increaseExp(int experience) {
        int FinalExp = Experience + (experience * ExpMultiplier);
        if (FinalExp >= NeededExperience) {
            int excess = Experience - NeededExperience;
            Experience = excess;
            Level ++;
        }
    }

    void setUpPlayer() {
        this.MaxHealth = 100;
        this.Health = MaxHealth;
        this.Protection = 0;
        this.DamageOutput = 100;
        this.CurrentProtection = Protection;
        this.CurrentDamageOutput = DamageOutput;
        this.Speed = 20;
        this.CurrentSpeed = Speed;
    }
}
