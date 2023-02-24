package de.morgon.LegendsOfArrol.methods;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Teleport {

    public void teleportToLobby(Player player){

        Location lobby = new Location(Bukkit.getWorld("lobby"), 131.5, 53.00, -615.5, 90, 0);
        player.teleport(lobby);

    }

}
