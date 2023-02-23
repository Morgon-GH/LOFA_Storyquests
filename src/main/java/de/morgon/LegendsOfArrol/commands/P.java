package de.morgon.LegendsOfArrol.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class P implements CommandExecutor {
    public P() {
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 2) {
            if (strings[0].equals("invite")) {
                commandSender.sendMessage("invited " + strings[1]);
            }
            if (strings[0].equals("list")) {
                commandSender.sendMessage(new String[0]);
            }
        } else
        {
            commandSender.sendMessage(  "Please use /p help");
        }

        return false;
    }

    public boolean addToParty(String partyowner, String newmember) {
        return false;
    }
}