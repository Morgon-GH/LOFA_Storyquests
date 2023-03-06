package de.morgon.LegendsOfArrol.mechanics;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class ControlBlockBreak implements Listener {


    @EventHandler
    public void OnBreakBlock(BlockBreakEvent e){

       Player p = e.getPlayer();

        e.setCancelled(!p.hasPermission("LegendsOfArrol.Building"));

    }

    @EventHandler
    public void OnBreakBlock(BlockPlaceEvent e){

        Player p = e.getPlayer();

        e.setCancelled(!p.hasPermission("LegendsOfArrol.Building"));

    }

}
