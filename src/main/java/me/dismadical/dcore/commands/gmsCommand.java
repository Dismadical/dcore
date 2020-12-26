package me.dismadical.dcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        if (sender instanceof Player){

            Player senderPlayer = (Player) sender;
            if (senderPlayer.hasPermission("dcore.gms")) {


                if (senderPlayer.getGameMode() == GameMode.SURVIVAL) {
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You are already in survival mode!");
                } else {
                    senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Survival mode activated!");
                    senderPlayer.setGameMode(GameMode.SURVIVAL);
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
