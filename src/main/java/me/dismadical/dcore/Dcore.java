package me.dismadical.dcore;

import lombok.Getter;
import me.dismadical.dcore.commands.*;
import me.dismadical.dcore.events.EffectsEvent;
import me.dismadical.dcore.events.PlayerJoin;
import me.dismadical.dcore.events.PlayerLeave;
import me.dismadical.dcore.events.VanishJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

@Getter
public final class Dcore extends JavaPlugin {
    @Getter
    private static Dcore instance;

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        System.out.println("DCore is starting!");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        ;
        // Events
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new VanishJoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new EffectsEvent(), this);
        // Commands
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("gmc").setExecutor(new gmcCommand());
        getCommand("gms").setExecutor(new gmsCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("sp").setExecutor(new SpeedCommand());
        getCommand("fr").setExecutor(new FireResCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("invis").setExecutor(new InvisCommand());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("effects").setExecutor(new EffectsGui());
        getCommand("v").setExecutor(new VanishCommand(this));
        getCommand("vanish").setExecutor(new VanishCommand(this));



    }
}
