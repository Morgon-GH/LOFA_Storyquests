package de.morgon.LegendsOfArrol.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class unstackables implements Listener{

    //weapons
    public static ItemStack daedalus_axe;
    public static ItemStack scylla;
    public static ItemStack hyperion;
    public static ItemStack valkyrie;
    public static ItemStack astraea;
    public static ItemStack restoria;
    public static ItemStack aspect_of_the_endest;
    public static ItemStack vorpal_katana;
    public static ItemStack sculk_waraxe;
    public static ItemStack atomrise_katana;
    public static ItemStack shadow_fury;
    public static ItemStack goldtwist_karambit;
    public static ItemStack diamondtwist_karambit;
    public static ItemStack netheritetwist_karambit;
    public static ItemStack helogon_altagos;
    public static ItemStack inferno_whip;
    public static ItemStack aegis_shieldbreaker;
    public static ItemStack astral_rapier;
    public static ItemStack cursed_blade_of_echoness;
    public static ItemStack dreamweaver_scythe;
    public static ItemStack reaper_scythe;
    public static ItemStack phoenix_talon_dagger;
    public static ItemStack pyrochaos_dagger;
    public static ItemStack firebreak_dagger;
    public static ItemStack pyrokinetic_dagger;
    public static ItemStack blazingeclipse_inferno_dagger;
    public static ItemStack spectral_whip_blade;
    //bows

    //arrows

    //armor

    public static void init() {
        //weapons
        createDaedalusAxe();
    }

    //weapons
    private static void createDaedalusAxe() {
        ItemStack item = new ItemStack(Material.GOLDEN_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        item.setItemMeta(meta);
        daedalus_axe = item;
    }
}
