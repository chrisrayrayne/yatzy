package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.game.Game;

import java.util.ArrayList;

public class OneQuintuple extends CollectionCombination {

    public OneQuintuple(int ruleSetValue) {
        super(ruleSetValue, 5, "y");
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
                                break;
                            }
                        }
                    }
                    if (!dicesUsed.contains(dice)) {
                        ArrayList<Dice> temp = new ArrayList<>();
                        temp.add(base);
                        temp.add(dice);
                        collections.add(temp);
                        dicesUsed.add(base);
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

    @Override
    protected int getCount(ArrayList<ArrayList<Dice>> collections, ArrayList<Dice> dices) {
        for(ArrayList<Dice> collection: collections) {
            if (collection.size() == COUNT_GOAL){
                return 50;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        if (ruleSet == Game.RULESET_YATZY) {
            return "Yatzy";
        } else if (ruleSet == Game.RULESET_YATZHEE) {
            return "Yathzee";
        }
        return "Yatzy";
    }
}
