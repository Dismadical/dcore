package me.dismadical.dcore.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectsEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        Player senderPlayer = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Effects")){

           switch (e.getCurrentItem().getType()){
               case SUGAR:
                   senderPlayer.closeInventory();
                   if (senderPlayer.hasPotionEffect(PotionEffectType.SPEED)){
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Speed has been disabled!");
                       senderPlayer.removePotionEffect(PotionEffectType.SPEED);
                   }else{
                       senderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1));
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Speed has been enabled!");
                   }
                   break;
               case MAGMA_CREAM:
                   senderPlayer.closeInventory();
                   if (senderPlayer.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                       senderPlayer.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Fire Resistance has been disabled!");
                   } else {
                       senderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0));
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Fire Resistance has been enabled!");
                   }
                   break;
               case INK_SACK:
                   senderPlayer.closeInventory();
                   if (senderPlayer.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Invisibility disabled!");
                       senderPlayer.removePotionEffect(PotionEffectType.INVISIBILITY);
                   } else {
                       senderPlayer.sendMessage(ChatColor.BLUE + "» " + ChatColor.AQUA + "Invisibility enabled!");
                       senderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, 0));
                   }


            e.setCancelled(true);
        }




    }


    }


}






