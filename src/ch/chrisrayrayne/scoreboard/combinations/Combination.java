package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.game.Game;

import java.util.ArrayList;

public abstract class Combination {

    private int points = 0;

    protected int ruleSet = 0;

    private boolean finished = false;
    private String identifier;

    public Combination(int ruleSetValue, String identifier){
        this.ruleSet = ruleSetValue;
        this.identifier = identifier;
    }

    public abstract int countPoints(ArrayList<Dice> dices);

    public void complete(final ArrayList<Dice> dices){
        if (!this.finished) {
            this.points = this.countPoints(dices);
        }
        this.finished = true;
    }

    public int getPoints() {
        return this.points;
    }

    public abstract String toString();

    public boolean isFinished() {
        return this.finished;
    }

    public String getIdentifier() {
            return this.identifier;
    }
}