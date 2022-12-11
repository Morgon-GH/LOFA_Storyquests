package de.morgon.LegendsOfArrol;

import de.morgon.LegendsOfArrol.commands.StartingFirstQuestCommand;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.quests.ADiffrentSide;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        PlayerProgressConfig.setup();
        PlayerProgressConfig.get().options().copyDefaults(true);
        PlayerProgressConfig.save();

        //TODO CoordinatsConfig

        System.out.println("Starting up plugin");

        getCommand("start1quest").setExecutor(new StartingFirstQuestCommand());

        PluginManager pluginManager= Bukkit.getPluginManager();
        pluginManager.registerEvents(new ADiffrentSide(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
