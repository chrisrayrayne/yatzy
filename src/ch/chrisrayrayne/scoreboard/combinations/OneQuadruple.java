package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.game.Game;

import java.util.ArrayList;

public class OneQuadruple extends CollectionCombination {

    public OneQuadruple(int ruleSetValue) {
        super(ruleSetValue, 4, "oq");
    }

    protected int getCount(ArrayList<ArrayList<Dice>> collections, ArrayList<Dice> dices) {
        if (ruleSet == Game.RULESET_YATZY) {
            return getCountYatzy(collections);
        }
        if (ruleSet == Game.RULESET_YATZHEE) {
            return getCountYatzhee(collections, dices);
        }
        return 0;
    }

    private int getCountYatzy(ArrayList<ArrayList<Dice>> collections) {
        int max = 0;
        for(ArrayList<Dice> collection: collections) {
            if (collection.size() == COUNT_GOAL){
                int sum = collection.get(0).getEyesRolled() * 4;
                if (sum > max) {
                    max = sum;
                }
            }
        }
        if (max > 0) {
            return max;
        }
        return 0;
    }

    public int getCountYatzhee(ArrayList<ArrayList<Dice>> collections, ArrayList<Dice> dices) {
        for(ArrayList<Dice> collection: collections) {
            if (collection.size() == COUNT_GOAL) {
                int points = 0;
                for(Dice d: dices){
                    points += d.getEyesRolled();
                }
                return points;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "4 of a kind";
    }
}
