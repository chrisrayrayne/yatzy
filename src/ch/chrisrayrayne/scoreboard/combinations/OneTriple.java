package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.game.Game;

import java.util.ArrayList;

public class OneTriple extends CollectionCombination {

    public OneTriple(int ruleSetValue) {
        super(ruleSetValue, 3, "ot");
    }

    @Override
    public int countPoints(final ArrayList<Dice> dices) {
        ArrayList<ArrayList<Dice>> collections = new ArrayList<>();
        ArrayList<Dice> dicesUsed = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < dices.size(); i++) {
            Dice base = dices.get(i);
            if(!base.isBlocked() || dicesUsed.contains(base)){
                continue;
            }
            for(int o = i + 1; o < dices.size(); o++) {
                Dice dice = dices.get(o);
                if(!dices.get(o).isBlocked() || dicesUsed.contains(dice)){
                    continue;
                }
                if(base.getEyesRolled() == dice.getEyesRolled()){
                    for(ArrayList<Dice> collection: collections) {
                        if (collection.size() < COUNT_GOAL) {
                            if(collection.get(0).getEyesRolled() == dice.getEyesRolled()){
                                collection.add(dice);
                                dicesUsed.add(dice);
                            }
                        }
                    }
                    if (!dicesUsed.contains(dice)) {
                        ArrayList<Dice> temp = new ArrayList<>();
                        if(!dicesUsed.contains(base)) {
                            temp.add(base);
                            dicesUsed.add(base);
                        }
                        temp.add(dice);
                        collections.add(temp);
                        dicesUsed.add(dice);
                    }
                }
            }
        }
        if(collections.size()>0) {
            count = getCount(collections, dices);
        }
        return count;
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
                int sum = collection.get(0).getEyesRolled() * 3;
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
        return "One Triple";
    }
}
