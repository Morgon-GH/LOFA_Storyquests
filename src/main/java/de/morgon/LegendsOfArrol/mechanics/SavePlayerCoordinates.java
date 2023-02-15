package de.morgon.LegendsOfArrol.mechanics;

import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class SavePlayerCoordinates implements Listener {

    private void saveLocation(Player player, Location location){

        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        PlayerCoordinatesConfig.get().set(player.getName() + ".X", x);
        PlayerCoordinatesConfig.get().set(player.getName() + ".Y", y);
        PlayerCoordinatesConfig.get().set(player.getName() + ".Z", z);
        PlayerCoordinatesConfig.save();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(p.getLocation().getWorld() == Bukkit.getWorld("world")) {

            saveLocation(p, p.getLocation());

        }

        Location lobby = new Location(Bukkit.getWorld("lobby"), 131.5, 53.00, -615.5, 90, 0);
        p.teleport(lobby);
    }

    @EventHandler
    public void onSleep(PlayerBedLeaveEvent e){

        Player p = e.getPlayer();
        Location loc = e.getBed().getLocation();

        saveLocation(p, loc);

    }

}
