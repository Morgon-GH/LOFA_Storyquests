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

                Player CalledPlayer = Bukkit.getPlayer(strings[1]);
                commandSender.sendMessage("invited " + strings[1]);
                CalledPlayer.sendMessage("You have been invited by " + commandSender.getName());

            }
            if (strings[0].equals("list")) {
                commandSender.sendMessage();
            }

            if (strings[0].equals("accept")){
                Player CalledPlayer = Bukkit.getPlayer(strings[1]);

                commandSender.sendMessage("accepted invite " + CalledPlayer.getName());
                CalledPlayer.sendMessage(commandSender.getName() + " joined the Party");
            }
        } else
        {
            commandSender.sendMessage(  "Please use /party help");
        }
        if (strings.length == 1) {
            if (strings[0].equals("help")) {

                commandSender.sendMessage("------------Partyhelp------------");
                commandSender.sendMessage("/party invite <Playername> <- Invites a Player to Party");
                commandSender.sendMessage("/party list <- Lists Player in a Party");
                commandSender.sendMessage("/party accept <Playername> <- Accept a invite from a Player");
                commandSender.sendMessage("");


            }
        }

        return false;
    }

    public boolean addToParty(String partyowner, String newmember) {
        return false;
    }
}
