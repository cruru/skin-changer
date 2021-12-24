package me.cruru.skin;

import me.cruru.skin.skin.SkinChanger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkinChangerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) return true;

        if(args.length == 2) {
            if(args[0].equals("reset")) {
                if(Bukkit.getPlayer(args[1]) == null) return true;

                Player target = Bukkit.getPlayer(args[1]);
                SkinChanger.changeSkin(target, target.getName());

            }
        }
        else if(args.length == 3) {
            if(args[0].equals("set")) {
                if(Bukkit.getPlayer(args[1]) == null) return true;

                Player target = Bukkit.getPlayer(args[1]);
                String skin = args[2];

                SkinChanger.changeSkin(target, skin);
            }
        }

        return false;
    }
}
