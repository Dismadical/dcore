package me.dismadical.dcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player senderPlayer = (Player) sender;
        if (args.length <2){
            senderPlayer.sendMessage(ChatColor.AQUA + "Correct usage: /msg (Player) (Message)");

        }else{
            Player target = Bukkit.getPlayerExact(args[0]);
            StringBuilder message = new StringBuilder();
            for (String arg : args) {
                message.append(" ").append(arg);
            }
            if (target != null){
                target.sendMessage(ChatColor.GRAY + "(From " + senderPlayer.getDisplayName() + ") " + ChatColor.AQUA + message);
                senderPlayer.sendMessage(ChatColor.GRAY + "(To " + target.getDisplayName() + ") " + ChatColor.AQUA + message);
            }else{
                senderPlayer.sendMessage(ChatColor.AQUA + "That player does not exist.");
            }
        }







        return true;
    }
}
