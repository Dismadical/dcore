package me.dismadical.dcore.events;

import me.dismadical.dcore.Dcore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VanishJoinEvent implements Listener {

    Dcore plugin;

    public VanishJoinEvent(Dcore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event){
        Player senderPlayer = event.getPlayer();
        for (int i = 0;i < plugin.getInvisible_list().size(); i++){
            senderPlayer.hidePlayer(plugin.getInvisible_list().get(i));
        }
    }


}
