package ch.chrisrayrayne.scoreboard;

import ch.chrisrayrayne.scoreboard.combinations.Combination;

import java.util.ArrayList;

import static ch.chrisrayrayne.game.Game.RULESET_YATZY;

public abstract class Section {

    protected int ruleSet = RULESET_YATZY;

    public Section(int ruleSetValue){
        this.ruleSet = ruleSetValue;
    }

    protected ArrayList<Combination> combinations = new ArrayList<>();

    public int getPoints() {
        int count = 0;
        for(Combination c: combinations) {
            count += c.getPoints();
        }
        return count;
    }

    public ArrayList<Combination> getCombinations() {
        return this.combinations;
    }
}