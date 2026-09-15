package de.gamingplugin.hardCoreFFA.commands;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setLocationCommand implements CommandExecutor {


    @Override
    public boolean onCommand( CommandSender sender,  Command command, String label,  String  [] args) {

        final Player player = (Player) sender;

        if(player.hasPermission("ffa.location")){

            if(args.length == 2){

                if(args[0].equalsIgnoreCase("set")){

                    switch (args[1]){
                        case "spawn":
                            player.sendMessage(HardCoreFFA.PREFIX + "Du hast die Location §eSpawn §aerfolgriech §7gesetzt§8!");
                            HardCoreFFA.getLocationManager().setLocation(player.getLocation(), "spawn");
                            break;
                    }

                }else player.sendMessage(HardCoreFFA.PREFIX + "Bitte benutze §e/location set §8(§eSpawn§8).");
            }else player.sendMessage(HardCoreFFA.PREFIX + "Bitte benutze §e/location set §8(§eSpawn§8).");


        }else player.sendMessage(HardCoreFFA.NO_PERMS);


        return false;
    }
}
