package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StartingFirstQuestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(s instanceof Player){

            Player p = (Player) s;

            if(PlayerProgressConfig.get().getDouble(p.getName()) >= 1){

                double x = PlayerCoordinatesConfig.get().getDouble(p.getName() + ".X");
                double y = PlayerCoordinatesConfig.get().getDouble(p.getName() + ".Y");
                double z = PlayerCoordinatesConfig.get().getDouble(p.getName() + ".Z");

                Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
                p.teleport(loc);

            }else {

                int x = -3580;
                int y = 100;
                int z = -4119;

                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 1));
                p.teleport(new Location(Bukkit.getWorld("world"), x, y, z));

                p.sendMessage("§c-----------------------------------------------------");
                p.sendMessage("§cWillkommen bei den Legenden von Arrol");
                p.sendMessage("§c-----------------------------------------------------");
                p.sendMessage("§2Du beginnst deine Geschichte als Einfacher Bauer auf einem Hof im Land Arrol. Du hast nichts, außer dein Feld und deine zwei Pferde vor deiner Kutsche.");
                p.sendMessage("§2Wie jeden Tag beginnst du auch heute damit, das Feld zu ernten und den Ertrag an die Hafenstadt zu bringen. Doch der Tag wird anders verlaufen, als du es erwartet hast...");

                p.playSound(p.getPlayer(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

                BossBar bar = Bukkit.createBossBar("§2Aufgabe: Ernte Weizen vom Feld", BarColor.GREEN, BarStyle.SOLID);
                bar.setVisible(true);
                bar.addPlayer(p);

                PlayerProgressConfig.get().set(p.getName(), 1.1);
                PlayerProgressConfig.save();

            }

        }else System.out.println("Command must be executed by a player");

        return false;
    }
}
