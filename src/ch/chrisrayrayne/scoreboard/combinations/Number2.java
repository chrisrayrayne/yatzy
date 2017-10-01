package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

public class Number2 extends Combination {

    public Number2(int ruleSetValue) {
        super(ruleSetValue, "2");
    }

    @Override
    public int countPoints(final ArrayList<Dice> dices) {
        int count = 0;
        for(Dice d: dices){
            if(d.isBlocked() && d.getEyesRolled()==2){
                count += d.getEyesRolled();
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Number 2s";
    }
}