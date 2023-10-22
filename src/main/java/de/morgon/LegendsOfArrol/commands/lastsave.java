package de.morgon.LegendsOfArrol.commands;

import de.morgon.LegendsOfArrol.configs.PlayerCoordinatesConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class lastsave implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        double x = PlayerCoordinatesConfig.get().getDouble(commandSender.getName() + ".X");
        double y = PlayerCoordinatesConfig.get().getDouble(commandSender.getName() + ".Y");
        double z = PlayerCoordinatesConfig.get().getDouble(commandSender.getName() + ".Z");

        commandSender.sendMessage("Your last saved position is: " + x + ", " + y + ", " + z);







        return false;
    }
}
