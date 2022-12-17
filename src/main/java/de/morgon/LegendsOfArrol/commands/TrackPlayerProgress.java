package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrackPlayerProgress implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(args.length == 0) {
                p.sendMessage("Progress: " + PlayerProgressConfig.get().getString(p.getName()));
            }else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                p.sendMessage("Progress: " + PlayerProgressConfig.get().getString(target.getName()));
            }
        }
        return false;
    }
}
