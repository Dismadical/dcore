package me.dismadical.dcore.commands;

import me.dismadical.dcore.Dcore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class VanishCommand implements CommandExecutor {

    Dcore plugin;

    public VanishCommand(Dcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

       if (sender instanceof Player){
           Player senderPlayer = (Player) sender;
           if (senderPlayer.hasPermission("dcore.vanish")){
               if (plugin.getInvisible_list().contains(senderPlayer)) {
                   for (Player people : Bukkit.getOnlinePlayers())
                       people.showPlayer(senderPlayer);
                   plugin.getInvisible_list().remove(senderPlayer);
                   senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You are no longer vanished!");
               } else if (!plugin.getInvisible_list().contains(senderPlayer)) {
                   for (Player people : Bukkit.getOnlinePlayers())
                       people.hidePlayer(senderPlayer);
                   plugin.getInvisible_list().add(senderPlayer);
                   senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "You are now vanished!");

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
