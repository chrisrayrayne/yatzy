package ch.chrisrayrayne.player;

import ch.chrisrayrayne.Dice;

import java.util.ArrayList;

public abstract class Player {

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
}
