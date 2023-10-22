package de.morgon.LegendsOfArrol.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Party implements CommandExecutor {
    public Party() {
    }
    private ArrayList<String>  Partylist = new ArrayList<>();
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length == 2) {
            if (strings[0].equals("invite")) {

                Player CalledPlayer = Bukkit.getPlayer(strings[1]);

                if (CalledPlayer != null) {
                    commandSender.sendMessage("invited " + strings[1]);
                    CalledPlayer.sendMessage("You have been invited by " + commandSender.getName());

                    if (!Partylist.contains(CalledPlayer.getName())) {


                    } else {
                        commandSender.sendMessage("Sorry Player is already in your party");
                    }

                }else{
                    commandSender.sendMessage("Sorry Player is not online");
                }
            }

            if (strings[0].equals("accept")) {
                Player CalledPlayer = Bukkit.getPlayer(strings[1]);
                if (CalledPlayer != null) {
                    commandSender.sendMessage("accepted invite " + CalledPlayer.getName());
                    if(!Partylist.contains(CalledPlayer.getName())) {
                        Partylist.add(commandSender.getName());
                    }else {
                        commandSender.sendMessage("Sorry you are already in this party");
                    }
                } else{
                    commandSender.sendMessage("Sorry Player is not online");
            }

                CalledPlayer.sendMessage(commandSender.getName() + " joined the Party");
            }
            if(strings[0].equals("leave")) {
                Player CalledPlayer = Bukkit.getPlayer(strings[1]);
                commandSender.sendMessage("You Left the Party from " + CalledPlayer.getName());
                Partylist.remove(commandSender.getName());
                CalledPlayer.sendMessage(commandSender.getName() + " left the Party");
            }

            if (strings[0].equals("list")) {
                commandSender.sendMessage("this has´t been implemented yet");
            }

            if (strings[0].equals("help")) {

                if(strings[1].equals("1")) {
                    commandSender.sendMessage("------------Party help------------");
                    commandSender.sendMessage("/party invite <Playername> <- Invites a Player to Party");
                    commandSender.sendMessage("/party list <- Lists Player in a Party");
                    commandSender.sendMessage("/party accept <Playername> <- Accept a invite from a Player");
                    commandSender.sendMessage("/party leave <- Leave a Party");
                    commandSender.sendMessage("/party help <- All Commands");
                    commandSender.sendMessage("----------------------------------");
                }else {
                    commandSender.sendMessage("Please do not forget the page!");
                }
            }
        } else
        {
            commandSender.sendMessage(  "Please use /party help <page>");
        }

        return false;
    }

    public boolean addToParty(String partyowner, String newmember) {
        return false;
    }
}
