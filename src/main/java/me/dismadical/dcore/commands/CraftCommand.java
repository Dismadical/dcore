package me.dismadical.dcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player senderPlayer = (Player) sender;
        if (sender != null){

            if (senderPlayer.hasPermission("dcore.craft")){
                senderPlayer.openWorkbench(senderPlayer.getLocation(), true);
            }else{
                senderPlayer.sendMessage(ChatColor.DARK_RED + "No permission.");
            }




        }else{
            System.out.println("You have to be a player to do this command!");
        }







        return true;
    }
}
