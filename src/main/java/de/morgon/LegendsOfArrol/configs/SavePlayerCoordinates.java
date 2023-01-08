package de.morgon.LegendsOfArrol.configs;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SavePlayerCoordinates implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
/*        Player p = e.getPlayer();

        Location loc = p.getLocation(); */
        PlayerCoordinatesConfig.get().addDefault("hi", "crap");
        PlayerCoordinatesConfig.save();

        System.out.println("Joined");
//        p.sendMessage("Welcome");
    }

}
