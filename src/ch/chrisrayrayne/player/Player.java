package ch.chrisrayrayne.player;

import ch.chrisrayrayne.Dice;
import ch.chrisrayrayne.scoreboard.Section;
import ch.chrisrayrayne.scoreboard.combinations.Combination;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {


    public ArrayList<Section> sections = new ArrayList<>();

    public Player() {
        for(int i = 0; i < 5; i++) {
            this.dices.add(new Dice());
        }
    }

    private ArrayList<Dice> dices = new ArrayList<>();

    public ArrayList<Dice> getDices() {
        return this.dices;
    }

    public void resetDices() {
        for (Dice d: this.dices) {
            d.reset();
        }
    }

    public void rollDices() {
        for (Dice d: this.dices) {
            d.roll();
        }
    }

    public abstract boolean playRound();

    public abstract void print();

    public void blockDices() {
        for (Dice d: this.dices) {
            d.block();
        }
    }

    public boolean finishedPlaying() {
        for (Section s: this.sections) {
            for (Combination c: s.getCombinations()) {
                if (!c.isFinished()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printScoreCard() {
        for (Section s: this.sections) {
            for (Combination c: s.getCombinations()) {
                System.out.println((c.isFinished() ? "-" : c.getIdentifier()) + ": " + c.toString() + " -> " + (c.isFinished() ? c.getPoints() : ""));
            }
        }
    }

    public abstract Combination chooseCombination();
}
