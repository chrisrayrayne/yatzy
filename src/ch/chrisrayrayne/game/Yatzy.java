package ch.chrisrayrayne.game;

public class Yatzy {

    public static void main(String[] args) {
        Game g = new ExpertGame();
        g.init(Game.RULESET_YATZY);
        g.play();
    }
}