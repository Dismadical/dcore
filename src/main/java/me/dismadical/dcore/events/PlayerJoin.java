package me.dismadical.dcore.events;

import me.dismadical.dcore.Dcore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        boolean joinmessage = Dcore.getInstance().getConfig().getBoolean("Player-Join-Message");
        Player senderPlayer = event.getPlayer();
        if (joinmessage)
            event.setJoinMessage(ChatColor.GREEN + "Welcome back " + ChatColor.AQUA + senderPlayer.getDisplayName() + "!");
    }

}
