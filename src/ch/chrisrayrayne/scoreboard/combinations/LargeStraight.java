package ch.chrisrayrayne.scoreboard.combinations;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.game.Game;

import java.util.ArrayList;

public class LargeStraight extends Combination {

    public LargeStraight(int ruleSetValue) {
        super(ruleSetValue, "ls");
    }

    @Override
    public int countPoints(final ArrayList<Dice> dices) {
        int count = 0;
        ArrayList<Dice> dicesSorted = new ArrayList<>(dices);
        dicesSorted.sort(new Dice.SortByEyesRolled());

        if (ruleSet == Game.RULESET_YATZY) {
            count = getCountYatzy(dicesSorted);
        }else if (ruleSet == Game.RULESET_YATZHEE) {
            count = getCountYatzhee(dicesSorted);
        }
        return count;
    }

    private int getCountYatzhee(ArrayList<Dice> dicesSorted) {
        int i = 1;
        int temp = -1;
        for (Dice d: dicesSorted) {
            if(d.getEyesRolled() == temp + 1) {
                i++;
                temp = d.getEyesRolled();
            } else {
                i = 1;
                temp = d.getEyesRolled();
            }
        }
        if (i >= 5) {
            return 40;
        }
        return 0;
    }

    private int getCountYatzy(ArrayList<Dice> dicesSorted) {
        for(int i = 2; i <= 6; i++){
            boolean found = false;
            for (Dice d: dicesSorted) {
                if(d.getEyesRolled() == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return 0;
            }
        }
        return 20;
    }

    @Override
    public String toString() {
        return "Large Straight";
    }
}
