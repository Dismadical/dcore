package me.dismadical.dcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player senderPlayer = (Player) sender;
        if (sender != null) {
            if (senderPlayer.hasPermission("dcore.feed")) {



            if (args.length == 0) {
                senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You have been feed!");
                senderPlayer.setFoodLevel(20);

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                target.setFoodLevel(20);
                target.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You have been fed by " + senderPlayer.getDisplayName() + "!");
                senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You have fed " + target.getDisplayName() + "!");
            }
        }else{
                senderPlayer.sendMessage(ChatColor.DARK_RED + "No permission.");
            }

        }else{
            System.out.println("You have to be a player to do this command.");
        }






        return true;
    }
}
