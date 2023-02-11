package de.morgon.LegendsOfArrol.mainquests;

/*
This quest immediately starts when the player joins the game
*/

import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.event.entity.EntityMountEvent;

public class ADiffrentSide implements Listener {

    @EventHandler
    public void onWheatBreak(BlockBreakEvent e) {

        Player p = e.getPlayer();

        if (PlayerProgressConfig.get().getDouble(p.getName()) == 1.1 && e.getBlock().getType() == Material.WHEAT) {

            PlayerProgressConfig.get().set(p.getName(), 1.2);
            p.sendMessage("§4Sehr gut!");
            p.sendMessage("§4Mach dir einen Weizenblock, nimm ihn in die Hand und bringe ihn zur Hafenstadt. Du findest sie, wenn du dem Weg hinter dem Haus folgst");
        }
    }

    @EventHandler
    public void onGetHay(CraftItemEvent e) {

        Player p = (Player) e.getViewers();

        if (PlayerProgressConfig.get().getDouble(p.getName()) == 1.2) {

            PlayerProgressConfig.get().set(p.getName(), 1.3);
            p.sendMessage("§aSehr gut. Nun kannst du dem Weg in die Hafenstadt folgen.");
            p.sendMessage("§aDein Wagen ist momentan leider kaputt. Aber du kannst dein Pferd nehmen.");

        }
    }


    @EventHandler
    public void onEnterPath(PlayerInteractEntityEvent e){

        Player p = e.getPlayer();
        Entity entity = e.getRightClicked();

        if(PlayerProgressConfig.get().getDouble(p.getName()) == 1.3 && p.getInventory().contains(Material.HAY_BLOCK) && entity instanceof Horse){

            Location house = new Location(Bukkit.getWorld("world"), -3583.28, 112.04, -4089.05, 165, 33);

            PlayerProgressConfig.get().set(p.getName(), 1.4);
            p.setGameMode(GameMode.SPECTATOR);
            p.teleport(house);
            p.sendTitle("§4Die Legenden von Arrol", "");

        }
    }
}

