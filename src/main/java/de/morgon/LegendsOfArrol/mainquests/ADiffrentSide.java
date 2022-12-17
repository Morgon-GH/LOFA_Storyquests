package de.morgon.LegendsOfArrol.mainquests;

/*
This quest immediately starts when the player joins the game
*/

import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ADiffrentSide implements Listener {

    @EventHandler
    public void onSpawn(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("wheatQuest1")){
            if(PlayerProgressConfig.get().getString(p.getName()).equals("1")) {
                if (e.getBlock().equals(Material.WHEAT)) {
                    p.sendMessage("§4Sehr gut!");
                    p.sendMessage("§4Sammle insgesammt 10 Weizen und bringe sie zur Hafenstadt. Du findest sie, wenn du dem Weg hinter dem Haus folgst");
                }
            }
        }
    }

}
