package me.dismadical.dcore.events;

import me.dismadical.dcore.Dcore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        boolean joinmessage = Dcore.getInstance().getConfig().getBoolean("Player-Join-Message");
        Player senderPlayer = event.getPlayer();
        if (joinmessage)
            event.setQuitMessage(ChatColor.GREEN + "Goodbye " + ChatColor.AQUA + senderPlayer.getDisplayName() + "!");
    }

}
