package de.morgon.LegendsOfArrol.npc;

import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ServerPlayer sp = ((CraftPlayer)sender).getHandle();

        ServerGamePacketListenerImpl listener = sp.connection;

        ClientboundGameEventPacket packet = new ClientboundGameEventPacket(ClientboundGameEventPacket.START_RAINING, 0.0F);
        listener.send(packet);

        return false;
    }
}
