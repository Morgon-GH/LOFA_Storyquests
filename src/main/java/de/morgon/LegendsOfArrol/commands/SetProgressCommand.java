package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetProgressCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 2){
            commandSender.sendMessage("Please use /setprog <Playername> <Progress level>");
        }else {
            PlayerProgressConfig.get().set(strings[0], strings[1]);
        }
        return true;
    }
}
