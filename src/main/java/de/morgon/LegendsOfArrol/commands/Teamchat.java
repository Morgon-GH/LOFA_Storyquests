package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import de.morgon.LegendsOfArrol.configs.TeammitgliederConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Teamchat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length == 0) {
            if (commandSender.hasPermission("LegendsOfArrol.teamchat")) {

            }else {
                commandSender.sendMessage("Sorry you have no Permissions");
            }

        }else {
            commandSender.sendMessage("Please use /tc or /teamchat <message>");
        }





        return false;
    }




}
