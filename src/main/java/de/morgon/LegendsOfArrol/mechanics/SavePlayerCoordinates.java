package de.morgon.LegendsOfArrol.mechanics;

import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import de.morgon.LegendsOfArrol.methods.Teleport;

public class SavePlayerCoordinates implements Listener {

    //save player location
    private void saveLocation(Player player, Location location){

        double x = location.getX();
        double y = location.getY() + 1.5;
        double z = location.getZ();

        PlayerCoordinatesConfig.get().set(player.getName() + ".X", x);
        PlayerCoordinatesConfig.get().set(player.getName() + ".Y", y);
        PlayerCoordinatesConfig.get().set(player.getName() + ".Z", z);
        PlayerCoordinatesConfig.save();
    }

    //detect when player joins, saves their location ant telepots to lobby
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(p.getLocation().getWorld() == Bukkit.getWorld("world")) {

            saveLocation(p, p.getLocation());

        }

        Teleport teleport = new Teleport();
        teleport.teleportToLobby(p);

    }

    //teleports player to last position when entering main world
    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e){

        Player p = e.getPlayer();
        Location loc = p.getLocation();

        if(p.getLocation().getWorld() == Bukkit.getWorld("world")) {

            saveLocation(p, loc);

        }

    }

    //saves player location when leaving bed
    @EventHandler
    public void onSleep(PlayerBedLeaveEvent e){

        Player p = e.getPlayer();
        Location loc = e.getBed().getLocation();

        if(p.getLocation().getWorld() == Bukkit.getWorld("world")) {

            saveLocation(p, loc);

        }
    }

}
