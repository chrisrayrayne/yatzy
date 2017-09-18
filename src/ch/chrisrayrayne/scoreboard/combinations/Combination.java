package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.game.Game;

import java.util.ArrayList;

public abstract class Combination {

    private int points = Game.RULESET_YATZY;

    protected int ruleSet = 0;

    public Combination(int ruleSetValue){
        this.ruleSet = ruleSetValue;
    }

    public abstract int countPoints(ArrayList<Dice> dices);

    public void complete(final ArrayList<Dice> dices){
        this.points = this.countPoints(dices);
    }

    public int getPoints() {
        return this.points;
    }

    public abstract String toString();
}