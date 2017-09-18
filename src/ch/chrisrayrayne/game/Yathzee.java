package ch.chrisrayrayne.game;

public class Yathzee {

    public static void main(String[] args) {
        Game g = new BeginnerGame();
        g.init(Game.RULESET_YATZHEE);
        g.play();
    }
}
