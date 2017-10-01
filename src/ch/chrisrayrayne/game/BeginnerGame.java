package ch.chrisrayrayne.game;

import ch.chrisrayrayne.player.HumanPlayer;
import ch.chrisrayrayne.player.Player;
import ch.chrisrayrayne.scoreboard.LowerSection;
import ch.chrisrayrayne.scoreboard.Section;
import ch.chrisrayrayne.scoreboard.UpperSection;
import ch.chrisrayrayne.scoreboard.combinations.Combination;

import java.util.ArrayList;

public class BeginnerGame extends Game {

    public void play() {
        for(Section s: this.sections) {
            for(Combination c: s.getCombinations()) {
                for(Player p: this.players){
                    System.out.println(c.toString());
                    p.resetDices();
                    for(int i = 0; i < 3; i++) {
                        if(p.playRound()){
                            break;
                        }
                    }
                    c.complete(p.getDices());
                    System.out.println(c.getPoints());
                    System.out.println(Math.addExact(this.sections.get(0).getPoints(), this.sections.get(1).getPoints()));
                }
            }
        }
    }
}
