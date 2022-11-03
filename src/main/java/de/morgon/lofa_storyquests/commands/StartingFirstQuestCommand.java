package de.morgon.lofa_storyquests.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartingFirstQuestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(s instanceof Player){

            Player p = (Player) s;
            int x = -3580;
            int y = 100;
            int z = -4119;

            p.teleport(new Location(p.getWorld(), x, y, z));

            p.sendMessage("§cWillkommen bei den Legenden von Arrol");
            p.sendMessage("§c-------------------------------------------------------------------------------------------");
            p.sendMessage("§2Du beginnst deine Geschichte als Einfacher Bauer auf einem Hof. Du hast nichts, außer dein Feld und deine zwei Pferde vor deiner Kutsche.");
            p.sendMessage("§2Wie jeden Tag beginnst du auch heute damit, das Feld zu ernten und den Ertrag an die Hafenstadt zu bringen. Doch der Tag wird anders verlaufen, als du es erwartet hast...");

            p.playSound(p.getPlayer(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

            BossBar bar = Bukkit.createBossBar("§2Aufgabe: Ernte Weizen vom Feld", BarColor.GREEN, BarStyle.SOLID);
            bar.setVisible(true);
            bar.addPlayer(p);


        }else System.out.println("Command must be executed by a player");

        return false;
    }
}
