package de.morgon.LegendsOfArrol;

import de.morgon.LegendsOfArrol.commands.StartingFirstQuestCommand;
import de.morgon.LegendsOfArrol.commands.TrackPlayerProgress;
import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.configs.SavePlayerCoordinates;
import de.morgon.LegendsOfArrol.mechanics.ControlBlockBreak;
import de.morgon.LegendsOfArrol.mechanics.FarmingWheat;
import de.morgon.LegendsOfArrol.mainquests.ADiffrentSide;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        PlayerProgressConfig.setup();
        PlayerProgressConfig.save();

        PlayerCoordinatesConfig.setup();
        PlayerCoordinatesConfig.save();

        System.out.println("Starting up plugin");

        getCommand("start1quest").setExecutor(new StartingFirstQuestCommand());
        getCommand("trackProg").setExecutor(new TrackPlayerProgress());

        PluginManager pluginManager= Bukkit.getPluginManager();

        //mainquests
        pluginManager.registerEvents(new ADiffrentSide(), this);

        //mechanics
        pluginManager.registerEvents(new FarmingWheat(),this);
        pluginManager.registerEvents(new ControlBlockBreak(), this);
        pluginManager.registerEvents(new SavePlayerCoordinates(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
