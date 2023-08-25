package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.Message;
import de.morgon.LegendsOfArrol.methods.Teleport;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {
    Message message = new Message();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Teleport teleport = new Teleport();

        if(commandSender instanceof Player){
            teleport.teleportToLobby((Player) commandSender);
        }else message.needsPlayerMessage(commandSender);
        return true;
    }
}
