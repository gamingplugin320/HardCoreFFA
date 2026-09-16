package de.gamingplugin.hardCoreFFA.commands;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import de.gamingplugin.hardCoreFFA.defaults.FFADefaults;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BuildCommand implements CommandExecutor {

    public static boolean build_mode;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        final Player player = (Player) sender;


        if(sender instanceof Player){

                   if(player.hasPermission("ffa.build")){

                       if(build_mode == false){
                           build_mode = true;
                           player.sendTitle(HardCoreFFA.PREFIX + "Build-Modus", "§aaktiviert");
                           player.getInventory().clear();
                           player.setGameMode(GameMode.CREATIVE);
                       }else {
                           player.sendTitle(HardCoreFFA.PREFIX + "Build-Modus", "§cdeaktiviert");
                           FFADefaults.spawnDefaults(player);
                       }
                   }else player.sendMessage(HardCoreFFA.NO_PERMS);

        }else Bukkit.getConsoleSender().sendMessage(HardCoreFFA.PREFIX + "Du bist kein Spieler! :-D");



        return false;
    }
}
