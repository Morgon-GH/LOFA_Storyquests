package de.morgon.LegendsOfArrol;

import de.morgon.LegendsOfArrol.Logs.Log;
import de.morgon.LegendsOfArrol.commands.*;
import de.morgon.LegendsOfArrol.configs.LogConfig;
import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.mechanics.SavePlayerCoordinates;
import de.morgon.LegendsOfArrol.mechanics.ControlBlockBreak;
import de.morgon.LegendsOfArrol.mechanics.FarmingWheat;
import de.morgon.LegendsOfArrol.mainquests.ADiffrentSide;
import de.morgon.LegendsOfArrol.npc.NPCSpawnCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();

        logger.info("Starting up plugin...");

        logger.info("Loading configs...");


        PlayerProgressConfig.setup();
        PlayerProgressConfig.save();
        PlayerProgressConfig.get().options().copyDefaults();

        PlayerCoordinatesConfig.setup();
        PlayerCoordinatesConfig.save();
        PlayerCoordinatesConfig.get().options().copyDefaults();

        LogConfig.setup();
        LogConfig.save();
        LogConfig.get().options().copyDefaults();

        logger.info("Configs loaded up successfully");

        //commands
        logger.info("Loading commands...");

        Objects.requireNonNull(getCommand("start")).setExecutor(new StartCommand());
        Objects.requireNonNull(getCommand("QuestProg")).setExecutor(new TrackPlayerProgress());
        Objects.requireNonNull(getCommand("Party")).setExecutor(new Party());
        Objects.requireNonNull(getCommand("P")).setExecutor(new Party());
        Objects.requireNonNull(getCommand("V")).setExecutor(new VanishCommand());
        Objects.requireNonNull(getCommand("Vanish")).setExecutor(new VanishCommand());
        Objects.requireNonNull(getCommand("cch")).setExecutor(new Clearchat());
        Objects.requireNonNull(getCommand("Clearchat")).setExecutor(new Clearchat());
        Objects.requireNonNull(getCommand("lobby")).setExecutor(new LobbyCommand());
//        Objects.requireNonNull(getCommand("lgive")).setExecutor(new swords());
        Objects.requireNonNull(getCommand("wand")).setExecutor(new wand());
        Objects.requireNonNull(getCommand("npc")).setExecutor(new NPCSpawnCommand());

        logger.info("Commands loaded successfully");

        PluginManager pluginManager = Bukkit.getPluginManager();

        //Events
        logger.info("Registering events...");

        //mainquests
        getServer().getPluginManager().registerEvents(new ADiffrentSide(this), this);

        //mechanics
        pluginManager.registerEvents(new FarmingWheat(),this);
        pluginManager.registerEvents(new ControlBlockBreak(), this);
        pluginManager.registerEvents(new SavePlayerCoordinates(), this);
        pluginManager.registerEvents(new Log(), this);

        logger.info("Events registered successfully");

        logger.info("Plugin started successfully");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
