package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import de.morgon.LegendsOfArrol.configs.PlayerProgressConfig;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoordinatsSaveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        Player p = (Player) s;
        Location loc = p.getLocation();

        PlayerProgressConfig.get().addDefault(p.getName(), loc);
        PlayerProgressConfig.save();

        return false;
    }
}
