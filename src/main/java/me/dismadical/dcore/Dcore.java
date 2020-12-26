package me.dismadical.dcore;

import lombok.Getter;
import me.dismadical.dcore.commands.*;
import me.dismadical.dcore.events.EffectsEvent;
import me.dismadical.dcore.events.PlayerJoin;
import me.dismadical.dcore.events.PlayerLeave;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Dcore extends JavaPlugin {
    @Getter
    private static Dcore instance;

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



    }
}
