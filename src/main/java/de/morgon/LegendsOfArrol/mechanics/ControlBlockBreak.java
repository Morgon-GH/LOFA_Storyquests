package de.morgon.LegendsOfArrol.mechanics;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class ControlBlockBreak implements Listener {


    @EventHandler
    public void OnBreakBlock(BlockBreakEvent e){

       Player p = e.getPlayer();

        if(p.hasPermission("LegendsOfArrol.Building")){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void OnBreakBlock(BlockPlaceEvent e){

        Player p = e.getPlayer();

        if(p.hasPermission("LegendsOfArrol.Building")){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }

    }

}
