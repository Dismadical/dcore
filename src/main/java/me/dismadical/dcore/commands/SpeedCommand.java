package me.dismadical.dcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if (sender instanceof Player){

            Player senderPlayer = (Player) sender;
            if (senderPlayer.hasPermission("dcore.sp")) {

                if (senderPlayer.hasPotionEffect(PotionEffectType.SPEED)) {
                    senderPlayer.removePotionEffect(PotionEffectType.SPEED);
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Speed has been disabled!");
                } else {
                    senderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1));
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Speed has been enabled!");
                }

            }else{
                senderPlayer.sendMessage(ChatColor.DARK_RED + "No permission.");
            }

        }else{
            System.out.println("You must be a player to do this command!");
        }

        return true;
    }
}
