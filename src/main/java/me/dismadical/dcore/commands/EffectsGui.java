package me.dismadical.dcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EffectsGui implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player senderPlayer = (Player) sender;

       if (sender instanceof Player){

           Inventory EffectsGui = Bukkit.createInventory(senderPlayer, 9, ChatColor.AQUA + "Effects");

           if (senderPlayer.hasPermission("dcore.effects")) {

               ItemStack Speed = new ItemStack(Material.SUGAR);
               ItemStack FireRes = new ItemStack(Material.MAGMA_CREAM);
               ItemStack Invis = new ItemStack(Material.INK_SACK);

               ItemMeta SpeedMeta = Speed.getItemMeta();
               SpeedMeta.setDisplayName(ChatColor.AQUA + "Speed");
               ArrayList<String> SpeedLore = new ArrayList<>();
               SpeedLore.add(ChatColor.WHITE + "Toggle your speed!");
               SpeedMeta.setLore(SpeedLore);
               Speed.setItemMeta(SpeedMeta);

               ItemMeta FireResMeta = FireRes.getItemMeta();
               FireResMeta.setDisplayName(ChatColor.GOLD + "Fire Resistance");
               ArrayList<String> FireResLore = new ArrayList<>();
               FireResLore.add(ChatColor.WHITE + "Toggle your fire resistance!");
               FireResMeta.setLore(FireResLore);
               FireRes.setItemMeta(FireResMeta);

               ItemMeta InvisMeta = Invis.getItemMeta();
               InvisMeta.setDisplayName(ChatColor.GRAY + "Invisibility");
               ArrayList<String> InvisLore = new ArrayList<>();
               InvisLore.add(ChatColor.WHITE + "Toggle your invisibility!");
               InvisMeta.setLore(InvisLore);
               Invis.setItemMeta(InvisMeta);

              EffectsGui.setItem(0, Speed);
              EffectsGui.setItem(4, FireRes);
              EffectsGui.setItem(8, Invis);

               senderPlayer.openInventory(EffectsGui);

           }else{
               senderPlayer.sendMessage(ChatColor.DARK_RED + "No permission.");
           }

       }else{
          System.out.println("You have to be a player to do this command!");
       }







        return true;
    }
}
