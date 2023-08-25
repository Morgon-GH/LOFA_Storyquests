package de.morgon.LegendsOfArrol;

import org.bukkit.command.CommandSender;

public class Message {

    public void needsPlayerMessage(CommandSender commandSender){
        commandSender.sendMessage("This command must be executed by a player");
    }

    public void wrongUsageMessage(CommandSender commandSender){
        commandSender.sendMessage("Sorry, but you're using this command the wrong way");
    }

}
