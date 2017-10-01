package ch.chrisrayrayne.player;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.scoreboard.Section;
import ch.chrisrayrayne.scoreboard.combinations.Combination;

import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public boolean playRound() {
        this.rollDices();
        this.print();
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println("Which to block?");
        String blockString = s.next();
        for(int i = 0; (i+1) <= blockString.length(); i++) {
            try {
                int block = Integer.parseInt(blockString.substring(i, i + 1));
                if (block < this.getDices().size()) {
                    this.getDices().get(block).block();
                }
            } catch(Exception e) {

            }
        }

        boolean allBlocked = true;
        for(Dice d: this.getDices()){
            if (!d.isBlocked()){
                allBlocked = false;
                break;
            }
        }
        return allBlocked;
    }

    @Override
    public void print() {
        for(Dice d: this.getDices()) {
            System.out.println(this.getDices().indexOf(d) + ": " + d.toString());
        }
    }

    @Override
    public Combination chooseCombination() {
        this.printScoreCard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which to block?");
        String combinationString = scanner.next();
        try {
            for (Section s: this.sections) {
                for (Combination c: s.getCombinations()) {
                    if (combinationString.equals(c.getIdentifier()) && !c.isFinished()) {
                        return c;
                    }
                }
            }
        } catch(Exception e) {

        }
        return null;
    }
}
