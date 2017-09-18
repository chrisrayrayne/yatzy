package ch.chrisrayrayne.scoreboard;

import ch.chrisrayrayne.game.Game;
import ch.chrisrayrayne.scoreboard.combinations.*;

public class UpperSection extends Section {

    public UpperSection(int ruleSet) {
        super(ruleSet);
        this.combinations.add(new Number1(ruleSet));
        this.combinations.add(new Number2(ruleSet));
        this.combinations.add(new Number3(ruleSet));
        this.combinations.add(new Number4(ruleSet));
        this.combinations.add(new Number5(ruleSet));
        this.combinations.add(new Number6(ruleSet));
    }

    public int getPoints() {
        int count = super.getPoints();
        if(this.ruleSet == Game.RULESET_YATZY) {
            if(count >= 63) {
                count += 50;
            }
        } else if(this.ruleSet == Game.RULESET_YATZHEE) {
            if(count >= 63) {
                count += 25;
            }
        }
        return count;
    }
}
