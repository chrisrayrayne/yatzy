package ch.chrisrayrayne;

public class Dice {

    private boolean blocked = false;

    private int eyesRolled = 0;

    public int roll() {
        if(!this.blocked) {
            eyesRolled = (int) (Math.random() * 6 + 1);
        }
        return eyesRolled;
    }

    public int getEyesRolled() {
        return this.eyesRolled;
    }

    public void block() {
        this.blocked = true;
    }

    public void reset() {
        this.blocked = false;
        this.eyesRolled = 0;
    }

    public String toString(){
        return this.getEyesRolled() + (this.blocked ? "x" : " ");
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public static class SortByEyesRolled implements java.util.Comparator<Dice> {
        @Override
        public int compare(Dice o1, Dice o2) {
            return Integer.compare(o1.getEyesRolled(), o2.getEyesRolled());
        }
    }
}