package de.gamingplugin.hardCoreFFA.listener;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import de.gamingplugin.hardCoreFFA.defaults.FFADefaults;
import de.gamingplugin.hardCoreFFA.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();
        createPlayerIfMissing(player);
            for (Player all : Bukkit.getOnlinePlayers()){
                ScoreboardManager.updateOnlinePlayers(all);
            }

        if (HardCoreFFA.getInstance().getConfig().contains("JOIN_MESSAGE")) {

            if (HardCoreFFA.getInstance().getConfig().getBoolean("JOIN_MESSAGE") == true) {

                event.setJoinMessage("§8[§a+§8] §e" + player.getName());

            } else event.setJoinMessage(null);

        } else {
            HardCoreFFA.getInstance().getConfig().set("JOIN_MESSAGE", true);
            HardCoreFFA.getInstance().saveConfig();

            if (HardCoreFFA.getInstance().getConfig().getBoolean("JOIN_MESSAGE") == true) {

                event.setJoinMessage("§8[§a+§8] §e" + player.getName());

            } else event.setJoinMessage(null);
        }

        FFADefaults.spawnDefaults(player);
        if (HardCoreFFA.getInstance().getConfig().contains("Locations.spawn")) {
            player.teleport(HardCoreFFA.getLocationManager().getLocation("spawn"));
        } else
            player.sendMessage(HardCoreFFA.PREFIX + "Bitte setzte erst den §eSpawn§7!");


    }

    public void createPlayerIfMissing(Player player) {

        String path = "players." + player.getUniqueId().toString();

        if (!HardCoreFFA.getInstance().getConfig().contains(path)) {
            HardCoreFFA.getInstance().getConfig().set(path + ".name", player.getName());
            HardCoreFFA.getInstance().getConfig().set(path + ".kills", 0);
            HardCoreFFA.getInstance().getConfig().set(path + ".tode", 0);
            HardCoreFFA.getInstance().saveConfig();
        }
    }


}
