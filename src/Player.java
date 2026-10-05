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

    void setUpPlayer(String name) {
        this.Name = name;
        this.MaxHealth = 100;
        this.Health = MaxHealth;
        this.Protection = 100;
        this.DamageOutput = 0;
        this.CurrentProtection = Protection;
        this.CurrentDamageOutput = DamageOutput;
        this.Speed = 20;
        this.CurrentSpeed = Speed;
    }
}
