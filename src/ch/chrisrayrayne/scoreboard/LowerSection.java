package ch.chrisrayrayne.scoreboard;

import ch.chrisrayrayne.game.Game;
import ch.chrisrayrayne.scoreboard.combinations.*;

public class LowerSection extends Section {

    public LowerSection(int ruleSetValue) {
        super(ruleSetValue);
        if(this.ruleSet== Game.RULESET_YATZY){
            this.combinations.add(new OnePair(ruleSetValue));
            this.combinations.add(new TwoPairs(ruleSetValue));
        }
        this.combinations.add(new OneTriple(ruleSetValue));
        this.combinations.add(new OneQuadruple(ruleSetValue));
        this.combinations.add(new SmallStraight(ruleSetValue));
        this.combinations.add(new LargeStraight(ruleSetValue));
        this.combinations.add(new FullHouse(ruleSetValue));
        this.combinations.add(new Chance(ruleSetValue));
        this.combinations.add(new OneQuintuple(ruleSetValue));
    }
}