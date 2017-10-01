package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

public class OnePair extends CollectionCombination {

    public OnePair(int ruleSetValue) {
        super(ruleSetValue, 2, "op");
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
        int max = 0;
        for(ArrayList<Dice> collection: collections) {
            if (collection.size() == COUNT_GOAL){
                int sum = collection.get(0).getEyesRolled() * 2;
                if (sum > max) {
                    max = sum;
                }
            }

        }
        return max;
    }

    @Override
    public String toString() {
        return "One Pair";
    }
}
