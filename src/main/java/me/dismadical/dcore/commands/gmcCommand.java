package me.dismadical.dcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if (sender instanceof Player){

            Player senderPlayer = (Player) sender;
            if (senderPlayer.hasPermission("dcore.gmc")) {
                if (senderPlayer.getGameMode() == GameMode.CREATIVE) {
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You are already in creative mode!");

                } else {
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Creative mode activated!");
                    senderPlayer.setGameMode(GameMode.CREATIVE);
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
