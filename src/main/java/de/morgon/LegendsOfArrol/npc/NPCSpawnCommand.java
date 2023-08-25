package de.morgon.LegendsOfArrol.npc;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.network.protocol.game.ClientboundAddPlayerPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import de.morgon.LegendsOfArrol.Message;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class NPCSpawnCommand implements CommandExecutor {

    Message message = new Message();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;

            CraftPlayer craftPlayer = (CraftPlayer) p;
            ServerPlayer sp = (ServerPlayer) craftPlayer.getHandle();

            MinecraftServer server = sp.getServer();
            ServerLevel level = ((CraftWorld)p.getWorld()).getHandle();
            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), strings[0]);

            Player skinPlayer = Bukkit.getPlayer(strings[1]);
            ServerPlayer skinServerPlayer = ((CraftPlayer)skinPlayer).getHandle();
            Collection<Property> skinCollection = skinServerPlayer.getGameProfile().getProperties().get("textures");
            Property skin = skinCollection.stream().findFirst().get();

            gameProfile.getProperties().put("textures", skin);

            ServerPlayer npc = new ServerPlayer(server, level, gameProfile);
            npc.setPos(((CraftPlayer) commandSender).getLocation().getBlockX(), ((CraftPlayer) commandSender).getLocation().getBlockY(), ((CraftPlayer) commandSender).getLocation().getBlockZ());

            ServerGamePacketListenerImpl ps = sp.connection;

            ps.send(new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, npc));
            ps.send(new ClientboundAddPlayerPacket(npc));

        }else message.needsPlayerMessage(commandSender);

        return false;
    }
}
