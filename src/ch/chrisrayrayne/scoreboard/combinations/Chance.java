package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

public class Chance extends Combination {

    public Chance(int ruleSetValue) {
        super(ruleSetValue);
    }

    @Override
    public int countPoints(final ArrayList<Dice> dices) {
        int count = 0;
        for(Dice d: dices){
            count += d.getEyesRolled();
        }
        return count;
    }

    @Override
    public String toString() {
        return "Chance";
    }
}
