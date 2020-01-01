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

public class Home implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(args.length == 1){
            UUID playerID = player.getUniqueId();
            PlayerConfig playerConfig = new PlayerConfig(playerID);
            FileConfiguration config =  playerConfig.getUserConfig();

            String homeName = args[0];

            if(config.contains(homeName)){
                Location home = (Location) config.get(homeName);
                player.sendMessage(ChatColor.BLUE + "You have been sent to your home!");
                player.teleport(home);
            }else{
                player.sendMessage(ChatColor.RED + "You do not have a home named \"" + homeName + "\"");
            }
        }else{
            player.sendMessage("Please indicate the name of the home you would like to teleport to. Do /homes if you are unsure of the name. ");
            player.sendMessage(command.getUsage());
        }

        return false;
    }
}
