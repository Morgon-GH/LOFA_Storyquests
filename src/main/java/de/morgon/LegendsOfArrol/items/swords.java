package de.morgon.LegendsOfArrol.items;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class swords implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        if(s instanceof Player){

            Player p = (Player) s;

            //Not Stackable Items
            if(args.length == 1){
                //Dwarf Battleblade
                if(args[0].equals("dwarf_battleblade")){
                    ItemStack i = new ItemStack(Material.IRON_AXE);

                    ItemMeta m = i.getItemMeta();
                    m.setDisplayName("§Dwarf Battleblade");
                    m.setUnbreakable(true);
                    m.addEnchant(Enchantment.FROST_WALKER, 1, false);
                    m.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
                    ArrayList lore = new ArrayList();
                    lore.add(" ");
                    lore.add("§7A rare battleaxe");
                    lore.add("§7forged out of the");
                    lore.add("§7purest dwarf metals.");
                    m.setLore(lore);
                    i.setItemMeta(m);

                    p.getInventory().addItem(i);

                }else
                if(args[0].equals("demon_ash")){
                    ItemStack i = new ItemStack(Material.CHARCOAL);
                    i.setAmount(64);

                    ItemMeta m = i.getItemMeta();
                    m.setDisplayName("§0Demon Ash");
                    i.setItemMeta(m);

                    p.getInventory().addItem(i);

                }
            }
        }
        return false;
    }
}
