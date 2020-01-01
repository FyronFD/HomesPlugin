package me.fyronfd.homesplugin.commands;

import me.fyronfd.homesplugin.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SetHome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        UUID playerID = player.getUniqueId();

        //Gets the user's config by creating an instance of the PlayerConfig class
        PlayerConfig playerConfig = new PlayerConfig(playerID);
        FileConfiguration configFile = playerConfig.getUserConfig();

        if(args.length == 1){//Saves the home with the given name
            Location homeLocation = player.getLocation();
            String homeName = args[0];//Name of home is only arg

            //The home name is used as the path name
            configFile.set(homeName, homeLocation);
            playerConfig.saveUserConfig();

            player.sendMessage(ChatColor.BLUE + "Your home (" + homeName + ") has been set!");

        }else{
            player.sendMessage(ChatColor.RED + "Please indicate a home name as a single word. ");
            player.sendMessage(command.getUsage());
        }
        return false;
    }
}
