package de.morgon.LegendsOfArrol.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        ArrayList V = new ArrayList<>();

        if (strings.length == 1) {
            for (Player onlinePlayers: Bukkit.getOnlinePlayers()) {
                Player pn = Bukkit.getPlayer(strings[0]);
                if (commandSender.hasPermission("LegendsOfArrol.vanish")) {
                    if (V.contains(pn)) {
                        pn.showPlayer((Plugin) this, onlinePlayers);
                        commandSender.sendMessage("Player " + strings[0] + " is now shown");
                    } else {
                        pn.hidePlayer((Plugin) this, onlinePlayers);
                        commandSender.sendMessage("Player " + strings[0] + " is now hidden");
                    }
                }
            }

        }else {
            for (Player onlinePlayers: Bukkit.getOnlinePlayers()) {
                Player p = Bukkit.getPlayer(commandSender.getName());
                if (commandSender.hasPermission("LegendsOfArrol.vanish")) {
                    if (V.contains(commandSender)) {
                        p.showPlayer((Plugin) this, onlinePlayers);
                        commandSender.sendMessage("Player is now shown");
                    }else {
                        p.hidePlayer((Plugin) this, onlinePlayers);
                        commandSender.sendMessage("Player is now hidden");
                    }
                }else{

                }
            }
        }



        return false;
    }
}
