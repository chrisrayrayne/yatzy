package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

/**
 * Created by chrisrayrayne on 09.05.18.
 */
public abstract class NumberCombination extends Combination {

    public NumberCombination(int ruleSetValue, String identifier) {
        super(ruleSetValue, identifier);
    }

    @Override
    public int countPoints(final ArrayList<Dice> dices) {
        int count = 0;
        for(Dice d: dices){
            if(d.isBlocked() && d.getEyesRolled()==6){
                count += d.getEyesRolled();
            }
        }
        return count;
    }
}
