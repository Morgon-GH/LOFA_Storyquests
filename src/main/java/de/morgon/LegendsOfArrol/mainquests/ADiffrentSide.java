package de.morgon.LegendsOfArrol.mainquests;

/*
This quest ist started by the StartingFirstQuestCommand
*/

import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class ADiffrentSide implements Listener {

    main plugin;

    public ADiffrentSide(main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWheatBreak(BlockBreakEvent e) {

        Player p = e.getPlayer();

        if (PlayerProgressConfig.get().getDouble(p.getName()) == 1.1 && e.getBlock().getType() == Material.WHEAT) {

            PlayerProgressConfig.get().set(p.getName(), 1.2);
            PlayerProgressConfig.save();
            p.sendMessage("§4Sehr gut!");
            p.sendMessage("§4Mach dir einen Weizenblock, nimm ihn in die Hand und bringe ihn zur Hafenstadt. Du findest sie, wenn du dem Weg hinter dem Haus folgst");
        }
    }

    @EventHandler
    public void onGetHay(CraftItemEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (PlayerProgressConfig.get().getDouble(p.getName()) == 1.2) {

            PlayerProgressConfig.get().set(p.getName(), 1.3);
            PlayerProgressConfig.save();
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
            PlayerProgressConfig.save();
            p.setGameMode(GameMode.SPECTATOR);
            p.teleport(house);
            p.sendTitle("§4Die Legenden von Arrol", "", 5, 60, 5);

            new BukkitRunnable(){

                @Override
                public void run() {

                    Location city = new Location(Bukkit.getWorld("world"), -3111.654, 67, -1740.243, -36, -5);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.teleport(city);

                    p.sendMessage("§aGut. Nach einem kurzen Ritt, bist du in der Stadt angekommen!");
                    p.sendMessage("§aBringe nun das Heu zu dem letzten Lagerhaus am Hafen und");
                    p.sendMessage("§aplaziere es in die Mahlrinne.");
                }
            }.runTaskLater(plugin, 20 * 4);

        }
    }

    @EventHandler
    public void onWheatGrind(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Block b = e.getClickedBlock();

        if(PlayerProgressConfig.get().getDouble(p.getName()) == 1.4 && e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && p.getInventory().contains(Material.HAY_BLOCK) && Objects.requireNonNull(b).getType().equals(Material.LODESTONE)) {

            PlayerProgressConfig.get().set(p.getName(), 1.5);
            PlayerProgressConfig.save();

            ItemStack h = new ItemStack(Material.HAY_BLOCK);
            p.getInventory().removeItem(h);

            p.sendMessage("§aPerfekt, das Heu wird nun verarbeitet und ist bald bereit");
            p.sendMessage("§ains Kerngebirge transportiert zu werden...");
            p.sendMessage("");
            p.sendMessage("§aDie Mahlsteine brauchen normalerweise um die 20 Sekunden um einen Heublock zu verarbeiten.");


            new BukkitRunnable(){

                @Override
                public void run() {

                    p.sendMessage("§aEndlich! Das Weizen ist fertig!");

                    ItemStack w = new ItemStack(Material.WHEAT);
                    ItemMeta wm = w.getItemMeta();
                    Objects.requireNonNull(wm).setDisplayName("§eVerarbeitetes Weizen");
                    w.setItemMeta(wm);
                    w.setAmount(5);

                    p.getInventory().addItem(w);

                    p.sendMessage("§aBringe nun das Weizen auf das Schiff und lass es");
                    p.sendMessage("§ains Kerngebirge verschiffen...");
                }
            }.runTaskLater(plugin, 20 * 20);

        }
    }

}

