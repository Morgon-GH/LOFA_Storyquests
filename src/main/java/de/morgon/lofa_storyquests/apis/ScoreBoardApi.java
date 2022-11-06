package de.morgon.lofa_storyquests.apis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoardApi implements Listener {

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {

    }

    public void createBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard storyquest = manager.getNewScoreboard();
        Object obj = storyquest.registerNewObjective("storyquest","dummy","storyquest");

    }
}
