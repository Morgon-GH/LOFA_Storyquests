package de.morgon.lofa_storyquests;

import de.morgon.lofa_storyquests.apis.ScoreBoardApi;
import de.morgon.lofa_storyquests.commands.StartingFirstQuestCommand;
import de.morgon.lofa_storyquests.quests.ADiffrentSide;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {


    @Override
    public void onEnable() {
        System.out.println("Starting up plugin");

        getCommand("start1quest").setExecutor(new StartingFirstQuestCommand());

        PluginManager pluginManager= Bukkit.getPluginManager();
        pluginManager.registerEvents(new ADiffrentSide(), this);

        this.getServer().getPluginManager().registerEvents(ScoreBoardApi, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
