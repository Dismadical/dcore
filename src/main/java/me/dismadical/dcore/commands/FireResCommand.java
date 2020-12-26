package me.dismadical.dcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireResCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if (sender instanceof Player){
            Player senderPlayer = (Player) sender;
            if (senderPlayer.hasPermission("dcore.fr")) {

                if (senderPlayer.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                    senderPlayer.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Fire Resistance has been disabled!");
                } else {
                    senderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0));
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Fire Resistance has been enabled!");
                }
            }else{
                senderPlayer.sendMessage(ChatColor.DARK_RED + "No permission.");
            }

        }else{
            System.out.println("You have to be a player to do this command!");
        }

        return true;
    }
}
