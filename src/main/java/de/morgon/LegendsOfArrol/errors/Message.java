package de.morgon.LegendsOfArrol.errors;

import org.bukkit.command.CommandSender;

public class Message {

    public void needsPlayerMessage(CommandSender commandSender){
        commandSender.sendMessage("This command must be executed by a player");
    }

}
