package ch.chrisrayrayne.game;

import ch.chrisrayrayne.player.HumanPlayer;
import ch.chrisrayrayne.player.Player;
import ch.chrisrayrayne.scoreboard.LowerSection;
import ch.chrisrayrayne.scoreboard.Section;
import ch.chrisrayrayne.scoreboard.UpperSection;

import java.util.ArrayList;

public abstract class Game {
    public static final int RULESET_YATZY = 0;
    public static final int RULESET_YATZHEE = 1;

    protected ArrayList<Section> sections = new ArrayList<>();
    protected ArrayList<Player> players = new ArrayList<>();

    public void init(int ruleSet) {
        this.players.add(new HumanPlayer());

        for (Player p : this.players) {
            p.sections.add(new UpperSection(ruleSet));
            p.sections.add(new LowerSection(ruleSet));
        }

        this.sections.add(new UpperSection(ruleSet));
        this.sections.add(new LowerSection(ruleSet));
    }

    public abstract void play();
}
