public class Enemies {

    static Enemy Skeleton() {
        return new Enemy(
                "Skeleton",
                100,
                100,
                100,
                0,
                0,
                false,
                true,
                10,
                10);
    }

    static Enemy Bear() {
        return new Enemy(
                "Bear",
                200,
                100,
                100,
                0,
                0,
                true,
                true,
                0,
                10);
    }

    static Enemy Rat() {
        return new Enemy(
                "Rat",
                50,
                100,
                100,
                0,
                0,
                true,
                true,
                0,
                10);
    }


}
