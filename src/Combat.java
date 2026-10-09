import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Combat {

    Random random = new Random();

    List<Character> enemyParty = new ArrayList<>();
    List<Character> fightParticipants = new ArrayList<>();

    List<Supplier<Enemy>> enemies = List.of(
            Enemies::skeleton,
            Enemies::bear,
            Enemies::golem,
            Enemies::rat,
            Enemies::venomousWebber,
            Enemies::webber
    );

    void generateEnemies(Player player) {
        int enemyAmount = random.nextInt(1, 2 + Enemy.Difficulty);

        while (enemyAmount > 0) {
            Enemy enemy = enemies.get(random.nextInt(enemies.size())).get();
            enemyParty.add(enemy);
            for (Character playerAlly : player.party) {
                enemy.addFoe(playerAlly);
            }
            player.addFoe(enemy);
            enemyAmount --;
        }
    }

    void startFight(Player player, boolean isBossFight, Scanner scanner) {

        if (!isBossFight) {
            generateEnemies(player);
        } else {
            Enemy skeletonKnight = Bosses.skeletonKnight();
            enemyParty.add(skeletonKnight);
            for (Character playerAlly : player.party) {
                skeletonKnight.addFoe(playerAlly);
            }
            player.addFoe(skeletonKnight);
        }

        for (Character enemy : enemyParty) {
            fightParticipants.add(enemy);
        }

        for (Character ally : player.party) {
            fightParticipants.add(ally);
        }

        for (Character participant : fightParticipants) {
            System.out.println(participant.Name+":\n"+participant.Health+"/"+participant.MaxHealth+"\nDamage: "+participant.CurrentDamageOutput+"\nProtection: "+participant.CurrentProtection+"\nSpeed: "+participant.CurrentSpeed+"\n");
        }

        while (enemyParty.size() > 0 && player.Alive) {
            fightParticipants.sort(
                    (a, b) -> Integer.compare(b.Speed, a.Speed)
            );

            for (Character participant : fightParticipants) {
                if (!participant.Alive) {
                    continue;
                }

                if (participant.StunTurns == 0) {
                    System.out.println("Now it's "+participant.Name+"'s turn\n"+participant.Name+":\n"+participant.Health+"/"+participant.MaxHealth+"\nDamage: "+participant.CurrentDamageOutput+"\nProtection: "+participant.CurrentProtection+"\nSpeed: "+participant.CurrentSpeed+"\n");
                    if (participant == player) {
                        Character chosenTarget = null;

                        while (chosenTarget == null) {
                            String targetChoice = scanner.nextLine();
                            if (targetChoice.contains("1")) {
                                chosenTarget = player.foes.get(0);
                            } else if (targetChoice.contains("2")) {
                                if (player.foes.size() < 2) {
                                    chosenTarget = player.foes.get(0);
                                } else {
                                    chosenTarget = player.foes.get(1);
                                }
                            } else if (targetChoice.contains("3")) {
                                if (player.foes.size() < 3) {
                                    chosenTarget = player.foes.get(0);
                                } else {
                                    chosenTarget = player.foes.get(2);
                                }
                            } else if (targetChoice.contains("4")) {
                                if (player.foes.size() < 4) {
                                    chosenTarget = player.foes.get(0);
                                } else {
                                    chosenTarget = player.foes.get(3);
                                }
                            }
                        }

                        System.out.println("You chose "+chosenTarget.Name+" as your target!");

                        Spell currentSpell = null;

                        while (currentSpell == null) {
                            String actionChoice = scanner.nextLine();
                            if (actionChoice.contains("1")) {
                                currentSpell = player.spells.get(0);
                            } else if (actionChoice.contains("2")) {
                                if (player.spells.size() < 2) {
                                    currentSpell = player.spells.get(0);
                                } else {
                                    currentSpell = player.spells.get(1);
                                }
                            } else if (actionChoice.contains("3")) {
                                if (player.spells.size() < 3) {
                                    currentSpell = player.spells.get(0);
                                } else {
                                    currentSpell = player.spells.get(2);
                                }
                            } else if (actionChoice.contains("4")) {
                                if (player.spells.size() < 4) {
                                    currentSpell = player.spells.get(0);
                                } else {
                                    currentSpell = player.spells.get(3);
                                }
                            }
                        }

                        System.out.println(chosenTarget.Name+" is chosen as the target for the "+currentSpell.SpellName+" spell!");
                        currentSpell.castSpell(player, chosenTarget);
                    } else {
                        Spell currentSpell = participant.spells.get(random.nextInt(participant.spells.size()));

                        if (enemyParty.contains(participant)) {
                            currentSpell.castSpell(participant, player.party.get(random.nextInt(player.party.size())));
                        } else {
                            currentSpell.castSpell(participant, enemyParty.get(random.nextInt(enemyParty.size())));
                        }
                    }
                } else {
                    System.out.println(participant.Name+" is stunned and couldn't act!");
                }

                participant.turnStatuses();

            }

            fightParticipants.removeIf(character -> !character.Alive);
            enemyParty.removeIf(enemy -> !enemy.Alive);

            player.foes.removeIf(enemy -> !enemy.Alive);
            player.allies.removeIf(ally -> !ally.Alive);

            System.out.println("END OF ROUND");
            System.out.println("Enemies alive: " + enemyParty.size());
            System.out.println("Player alive: " + player.Alive);
        }

        if (player.Alive && !isBossFight) {
            player.CampaignProgress += 5;
            for (Character playerPartyMember : player.party) {
                playerPartyMember.clearCharacter();
            }
        } else if (player.Alive && isBossFight) {
            player.CampaignProgress = 100;
            System.out.println("You've defeated the main boss and have beaten the game, congratulations!\n"+player.CampaignProgress+"% Campaign Progress");
        }
    }
}
