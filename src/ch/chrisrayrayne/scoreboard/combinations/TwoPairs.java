package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

public class TwoPairs extends CollectionCombination {

    public TwoPairs(int ruleSetValue) {
        super(ruleSetValue, 2);
    }

    protected int getCount(ArrayList<ArrayList<Dice>> collections, ArrayList<Dice> dices) {
        int max = 0;
        int max2 = 0;
        for(ArrayList<Dice> collection: collections) {
            if (collection.size() == COUNT_GOAL){
                int sum = collection.get(0).getEyesRolled() * 2;
                if (sum > max) {
                    max = sum;
                } else if (sum > max2){
                    max2 = sum;
                }
            }
        }
        if (max > 0 && max2 > 0) {
            return max + max2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Two Pairs";
    }
}
