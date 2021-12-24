package me.cruru.skin.skin;

import com.mojang.authlib.GameProfile;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.server.network.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SkinChanger {

    public static boolean changeSkin(Player player, String name) {
        if(Skin.getSkin(name) == null) return false;

        GameProfile profile = ((CraftPlayer)player).getHandle().fp();

        for(Player p : Bukkit.getOnlinePlayers()) {
            PlayerConnection connection = ((CraftPlayer)p).getHandle().b;
            connection.a(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.e, ((CraftPlayer)player).getHandle()));
            profile.getProperties().removeAll("textures");
            profile.getProperties().put("textures", Skin.getSkin(name));
            connection.a(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, ((CraftPlayer)player).getHandle()));
        }
        return true;
    }

}
