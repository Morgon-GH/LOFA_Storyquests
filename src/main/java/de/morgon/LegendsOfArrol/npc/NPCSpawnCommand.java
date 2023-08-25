package de.morgon.LegendsOfArrol.npc;

import com.mojang.authlib.GameProfile;
import net.minecraft.network.protocol.game.ClientboundAddPlayerPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import de.morgon.LegendsOfArrol.Message;

import java.util.UUID;

public class NPCSpawnCommand implements CommandExecutor {

    Message message = new Message();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            CraftPlayer craftPlayer = (CraftPlayer) commandSender;
            ServerPlayer sp = (ServerPlayer) craftPlayer.getHandle();

            MinecraftServer server = sp.getServer();
            ServerLevel level = (ServerLevel) craftPlayer.getWorld();
            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "strings[0]");

            ServerPlayer npc = new ServerPlayer(server, level, gameProfile);
            npc.setPos(((CraftPlayer) commandSender).getLocation().getBlockX(), ((CraftPlayer) commandSender).getLocation().getBlockY(), ((CraftPlayer) commandSender).getLocation().getBlockZ());

            ServerGamePacketListenerImpl ps = sp.connection;

            ps.send(new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, npc));
            ps.send(new ClientboundAddPlayerPacket(npc));

        }else message.needsPlayerMessage(commandSender);

        return false;
    }
}
