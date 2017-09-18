package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

public class Number1 extends Combination {

    public Number1(int ruleSetValue) {
        super(ruleSetValue);
    }

    @Override
    public int countPoints(final ArrayList<Dice> dices) {
        int count = 0;
        for(Dice d: dices){
            if(d.isBlocked() && d.getEyesRolled()==1){
                count += d.getEyesRolled();
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Number 1s";
    }
}