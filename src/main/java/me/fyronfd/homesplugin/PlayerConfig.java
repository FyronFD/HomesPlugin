package me.fyronfd.homesplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.UUID;

public class PlayerConfig implements Listener {
    private UUID user;
    private File userFile;
    private FileConfiguration userConfig;

    Plugin plugin = HomesPlugin.getPlugin(HomesPlugin.class);

    public PlayerConfig(UUID user){
        this.user = user;
        userFile = new File(plugin.getDataFolder(),user + ".yml");
        userConfig = YamlConfiguration.loadConfiguration(userFile);
    }

    public FileConfiguration getUserConfig(){
        return userConfig;
    }

    public void saveUserConfig(){
        try{
            getUserConfig().save(userFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
