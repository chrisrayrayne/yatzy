package ch.chrisrayrayne.game;

import ch.chrisrayrayne.player.Player;
import ch.chrisrayrayne.scoreboard.combinations.Combination;

public class ExpertGame extends Game {

    public void play() {
        boolean finishedPlaying;
        do {
            finishedPlaying = true;
            for (Player p: this.players) {
                if (!p.finishedPlaying()) {
                    finishedPlaying = false;
                    p.resetDices();
                    for(int i = 0; i < 3; i++) {
                        if(p.playRound()){
                            break;
                        }
                    }

                    Combination c = p.chooseCombination();
                    c.complete(p.getDices());
                    System.out.println(c.getPoints());
                    System.out.println(Math.addExact(p.sections.get(0).getPoints(), p.sections.get(1).getPoints()));
                }
            }
            
        } while (!finishedPlaying);
    }
}