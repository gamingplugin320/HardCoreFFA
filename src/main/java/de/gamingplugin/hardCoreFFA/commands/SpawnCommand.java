package de.gamingplugin.hardCoreFFA.commands;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        final Player player = (Player) sender;

        if(sender instanceof Player){

            if(args.length == 0){

                player.sendMessage(HardCoreFFA.PREFIX + "Du bist nun am Spawn.");
                player.teleport(HardCoreFFA.getLocationManager().getLocation("spawn"));
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
            }else player.sendMessage(HardCoreFFA.PREFIX + "Bitte verwende §e/spawn§8!");

        }else Bukkit.getConsoleSender().sendMessage(HardCoreFFA.PREFIX + "Du bist kein Spieler");

        return false;
    }
}
