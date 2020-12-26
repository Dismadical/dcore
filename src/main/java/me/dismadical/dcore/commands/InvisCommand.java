package me.dismadical.dcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InvisCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

       if (sender instanceof Player){
           Player senderPlayer = (Player) sender;
           if (senderPlayer.hasPermission("dcore.invis")) {

               if (senderPlayer.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                   senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Invisibility disabled!");
                   senderPlayer.removePotionEffect(PotionEffectType.INVISIBILITY);
               } else {
                   senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Invisibility enabled!");
                   senderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, 0));
               }

           }else{
               senderPlayer.sendMessage(ChatColor.DARK_RED + "No permission.");
           }


       }else{
           System.out.println("You need to be a player to do this command!");
       }



        return true;
    }
}
