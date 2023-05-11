package de.morgon.LegendsOfArrol;

import de.morgon.LegendsOfArrol.commands.*;
import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.items.swords;
import de.morgon.LegendsOfArrol.mechanics.SavePlayerCoordinates;
import de.morgon.LegendsOfArrol.mechanics.ControlBlockBreak;
import de.morgon.LegendsOfArrol.mechanics.FarmingWheat;
import de.morgon.LegendsOfArrol.mainquests.ADiffrentSide;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting up plugin...");

        System.out.println("Loading configs...");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        PlayerProgressConfig.setup();
        PlayerProgressConfig.save();
        PlayerProgressConfig.get().options().copyDefaults();

        PlayerCoordinatesConfig.setup();
        PlayerCoordinatesConfig.save();
        PlayerCoordinatesConfig.get().options().copyDefaults();

        System.out.println("Configs loaded up successfully");

        //commands
        System.out.println("Loading commands...");

        Objects.requireNonNull(getCommand("start")).setExecutor(new StartCommand());
        Objects.requireNonNull(getCommand("QuestProg")).setExecutor(new TrackPlayerProgress());
        Objects.requireNonNull(getCommand("Party")).setExecutor(new Party());
        Objects.requireNonNull(getCommand("P")).setExecutor(new Party());
        Objects.requireNonNull(getCommand("V")).setExecutor(new VanishCommand());
        Objects.requireNonNull(getCommand("Vanish")).setExecutor(new VanishCommand());
        Objects.requireNonNull(getCommand("cch")).setExecutor(new Clearchat());
        Objects.requireNonNull(getCommand("Clearchat")).setExecutor(new Clearchat());
        Objects.requireNonNull(getCommand("lobby")).setExecutor(new LobbyCommand());
        Objects.requireNonNull(getCommand("lgive")).setExecutor(new swords());
        Objects.requireNonNull(getCommand("wand")).setExecutor(new wand());

        System.out.println("Commands loaded successfully");

        PluginManager pluginManager= Bukkit.getPluginManager();

        //Events

        System.out.println("Registering events...");

        //mainquests
        getServer().getPluginManager().registerEvents(new ADiffrentSide(this), this);

        //mechanics
        pluginManager.registerEvents(new FarmingWheat(),this);
        pluginManager.registerEvents(new ControlBlockBreak(), this);
        pluginManager.registerEvents(new SavePlayerCoordinates(), this);

        System.out.println("Events registered successfully");

        System.out.println("Plugin started successfully");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
