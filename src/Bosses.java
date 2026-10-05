public class Bosses {

    static Enemy skeletonKnight() {
        Enemy skeletonKnight = new Enemy(
                "Skeleton Knight",
                250,
                100,
                30,
                10,
                false,
                true);

        skeletonKnight.addSpell(Spells.swordCleave());
        skeletonKnight.addSpell(Spells.slicingSpin());
        skeletonKnight.addSpell(Spells.leer());

        return skeletonKnight;
    }
}
