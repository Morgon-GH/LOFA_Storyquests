package de.morgon.LegendsOfArrol.configs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SavePlayerCoordinates implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(p.getLocation().getWorld() == Bukkit.getWorld("world")) {

            double x = p.getLocation().getX();
            double y = p.getLocation().getY();
            double z = p.getLocation().getZ();

            PlayerCoordinatesConfig.get().set(p.getName() + ".X", x);
            PlayerCoordinatesConfig.get().set(p.getName() + ".Y", y);
            PlayerCoordinatesConfig.get().set(p.getName() + ".Z", z);
            PlayerCoordinatesConfig.save();
        }

        Location lobby = new Location(Bukkit.getWorld("lobby"), 131.5, 53.00, -615.5, 90, 0);
        p.teleport(lobby);
    }

}
