package me.fyronfd.homesplugin.commands;

import me.fyronfd.homesplugin.PlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;


public class Homes implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        UUID playerID = player.getUniqueId();
        PlayerConfig playerConfig = new PlayerConfig(playerID);
        FileConfiguration config = playerConfig.getUserConfig();

        player.sendMessage(ChatColor.DARK_GREEN + "Here is a list of your homes: ");
        Set<String> homes = config.getKeys(false);
        if(homes.size() != 0){
            for (String home : homes) {
                player.sendMessage(ChatColor.BLUE + "  " + home);
            }
        }else{
            player.sendMessage(ChatColor.RED + "You do not have any homes set. Please use /sethome (home name)");
        }

        return false;
    }
}
