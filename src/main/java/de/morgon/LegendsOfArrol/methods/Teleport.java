package de.morgon.LegendsOfArrol.methods;

import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Teleport {

    public void teleportToLobby(Player player){

        Location lobby = new Location(Bukkit.getWorld("lobby"), 131.5, 53.00, -615.5, 90, 0);
        player.teleport(lobby);

    }

    //teleports the given player to the coordinates saved in the config
    public void teleportToConfigCoordinates(Player p){

        double x = PlayerCoordinatesConfig.get().getDouble(p.getName() + ".X");
        double y = PlayerCoordinatesConfig.get().getDouble(p.getName() + ".Y");
        double z = PlayerCoordinatesConfig.get().getDouble(p.getName() + ".Z");

        Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
        p.teleport(loc);

    }

}
