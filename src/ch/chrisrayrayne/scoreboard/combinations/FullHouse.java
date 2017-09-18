package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.game.Game;

import java.util.ArrayList;

public class FullHouse extends CollectionCombination {

    public FullHouse(int ruleSetValue) {
        super(ruleSetValue, 3);
    }

    protected int getCountYatzy(ArrayList<ArrayList<Dice>> collections) {
        ArrayList<Dice> pair;
        ArrayList<Dice> triple = null;
        int max2 = 0;
        int max3 = 0;
        for(ArrayList<Dice> collection: collections) {
            if (collection.size() == 3) {
                int count3 = collection.get(0).getEyesRolled() * 3;
                int count2 = collection.get(0).getEyesRolled() * 2;
                if (count3 > max3) {
                    max3 = count3;
                    int countBefore2 = triple!=null ? triple.get(0).getEyesRolled() * 2 : 0;
                    if (countBefore2 > max2) {
                        max2 = countBefore2;
                        pair = triple;
                    }
                    triple = collection;
                } else if (count2 > max2) {
                    max2 = count2;
                    pair = collection;
                }
            } else if (collection.size() == 2) {
                int count2 = collection.get(0).getEyesRolled() * 2;
                if (count2 > max2) {
                    max2 = count2;
                    pair = collection;
                }
            }
        }
        if (max3 > 0 && max2 > 0) {
            return max3 + max2;
        }
        return 0;
    }

    protected int getCountYatzhee(ArrayList<ArrayList<Dice>> collections) {
        ArrayList<Dice> pair = null;
        ArrayList<Dice> triple = null;
        for(ArrayList<Dice> collection: collections) {
            if (collection.size() == 3) {
                pair = triple;
                triple = collection;
            } else if (collection.size() == 2) {
                pair = collection;
            }
        }
        if (pair != null && triple != null) {
            return 25;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Full House";
    }

    @Override
    protected int getCount(ArrayList<ArrayList<Dice>> collections, ArrayList<Dice> dices) {
        if (ruleSet == Game.RULESET_YATZY) {
            return getCountYatzy(collections);
        } else if (ruleSet == Game.RULESET_YATZHEE) {
            return getCountYatzhee(collections);
        }
        return 0;
    }
}
