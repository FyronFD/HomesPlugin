package me.fyronfd.homesplugin;

import me.fyronfd.homesplugin.commands.Home;
import me.fyronfd.homesplugin.commands.Homes;
import me.fyronfd.homesplugin.commands.SetHome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomesPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(this, this);

        getCommand("SetHome").setExecutor(new SetHome());
        getCommand("Home").setExecutor(new Home());
        getCommand("Homes").setExecutor(new Homes());
    }

    //Every user that joins will be given a config file, initially blank
    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event){
        PlayerConfig playerConfig = new PlayerConfig(event.getPlayer().getUniqueId());
    }
}
