package de.morgon.LegendsOfArrol.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clearchat implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = Bukkit.getPlayer(commandSender.getName());

        if (p.hasPermission("LegendsOfArrol.Modchat")) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage(" ");
                onlinePlayer.sendMessage("-------------Chat was Cleared by " + p.getName() + "-------------");
            }
        }
        return false;
    }
}
