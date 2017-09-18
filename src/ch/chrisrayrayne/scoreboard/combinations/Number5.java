package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

public class Number5 extends Combination {

    public Number5(int ruleSetValue) {
        super(ruleSetValue);
    }

    @Override
    public int countPoints(final ArrayList<Dice> dices) {
        int count = 0;
        for(Dice d: dices){
            if(d.isBlocked() && d.getEyesRolled()==5){
                count += d.getEyesRolled();
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Number 5s";
    }
}