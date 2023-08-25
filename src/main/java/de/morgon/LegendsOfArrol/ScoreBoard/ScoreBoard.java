package de.morgon.LegendsOfArrol.ScoreBoard;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreBoard {

    public static Scoreboard getBaseScoreboard(Player player){
        String Perm = PlaceholderAPI.setPlaceholders(player,"%luckperms_prefix%");
        String Time = PlaceholderAPI.setPlaceholders(player,"%world_time_world%");
        String Leer = "";
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("main", "main", "§6§lLegends Of Arrol");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§1§lYour Rank:").setScore(11);
        objective.getScore(Perm).setScore(10);
        objective.getScore(Leer).setScore(9);
        objective.getScore("§1§lTime:").setScore(8);
        objective.getScore(Time).setScore(7);
        objective.getScore(Leer).setScore(6);
        objective.getScore("§1§lCurrent Quest:").setScore(5);
        objective.getScore(Leer).setScore(4);
        objective.getScore(Leer).setScore(3);
        objective.getScore("§1§lMoney on Bank:").setScore(2);
        objective.getScore(Leer).setScore(1);
        objective.getScore(Leer).setScore(0);

        return s;

    }





}
