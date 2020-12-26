package me.dismadical.dcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

       if (sender instanceof Player){
            Player senderPlayer = (Player) sender;
           if (senderPlayer.hasPermission("dcore.kill")) {

               if (args.length == 0) {
                   senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You have been killed!");
                   senderPlayer.setHealth(0);
               } else {
                   Player target = Bukkit.getPlayerExact(args[0]);
                   if (target != null) {
                       target.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You have been killed!");
                       target.setHealth(0);
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You have killed " + target.getDisplayName() + "!");

                   } else {
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "That player does not exist.");
                   }
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
