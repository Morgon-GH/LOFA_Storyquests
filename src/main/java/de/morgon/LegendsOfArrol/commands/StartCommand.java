package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.GUI.ScoreBoard;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.Message;
import de.morgon.LegendsOfArrol.methods.Teleport;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class StartCommand implements CommandExecutor {
    Message message = new Message();
    Teleport teleport = new Teleport();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(s instanceof Player){

            Player p = (Player) s;

            //teleports player to his last location if they have started the story already
            if(PlayerProgressConfig.get().getDouble(p.getName()) >= 1){

                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 1));
                teleport.teleportToConfigCoordinates(p);
                p.setBedSpawnLocation(p.getLocation());

            }else {
                //teleports the player to the start of the map and starts their story

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

                p.playSound(Objects.requireNonNull(p.getPlayer()), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

                PlayerProgressConfig.get().set(p.getName(), 1.1);
                PlayerProgressConfig.save();

            }

            p.getPlayer().setScoreboard(ScoreBoard.getBaseScoreboard(p.getPlayer()));

        }else message.needsPlayerMessage(s);


        return false;
    }
}
