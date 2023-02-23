package de.morgon.LegendsOfArrol;

import de.morgon.LegendsOfArrol.commands.P;
import de.morgon.LegendsOfArrol.commands.Party;
import de.morgon.LegendsOfArrol.commands.StartingFirstQuestCommand;
import de.morgon.LegendsOfArrol.commands.TrackPlayerProgress;
import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.mechanics.SavePlayerCoordinates;
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
        PlayerProgressConfig.get().options().copyDefaults();

        PlayerCoordinatesConfig.setup();
        PlayerCoordinatesConfig.save();
        PlayerCoordinatesConfig.get().options().copyDefaults();

        System.out.println("Starting up plugin");

        getCommand("start1quest").setExecutor(new StartingFirstQuestCommand());
        getCommand("QuestProg").setExecutor(new TrackPlayerProgress());
        getCommand("Party").setExecutor(new Party());
        getCommand("P").setExecutor(new Party());

        PluginManager pluginManager= Bukkit.getPluginManager();

        //mainquests
        getServer().getPluginManager().registerEvents(new ADiffrentSide(this), this);

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
