package de.morgon.LegendsOfArrol.mechanics;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class FarmingWheat implements Listener {

    ItemStack wheat = new ItemStack(Material.WHEAT, 1);

    @EventHandler
    public void OnBreakWheat(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block block = e.getBlock();

        Material cropBlockType = null;

        if(block.getType() == Material.WHEAT){
            cropBlockType = Material.WHEAT;
        }

        if(cropBlockType != null && isFullyGrown(block)){
            e.setCancelled(true);
            resetCropAge(e.getBlock().getLocation(), cropBlockType);
            p.getInventory().addItem(wheat);
        }
    }

    public void resetCropAge(Location location, Material cropBlockType){
        location.getBlock().setType(cropBlockType);
    }

    public boolean isFullyGrown(Block block){
        Ageable ageable = (org.bukkit.block.data.Ageable) block.getBlockData();

        return ageable.getAge() == 7;
    }

}
