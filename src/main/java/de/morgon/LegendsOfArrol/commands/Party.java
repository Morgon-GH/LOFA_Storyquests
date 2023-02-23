package de.morgon.LegendsOfArrol.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Party implements CommandExecutor {
    public Party() {
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 2) {
            if (strings[0].equals("invite")) {

                Player CalledPlayer = Bukkit.

                commandSender.sendMessage("invited " + strings[1]);

            }
            if (strings[0].equals("list")) {
                commandSender.sendMessage();
            }
        } else
        {
            commandSender.sendMessage(  "Please use /party help");
        }

        return false;
    }

    public boolean addToParty(String partyowner, String newmember) {
        return false;
    }
}
