package de.gamingplugin.hardCoreFFA.listener;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import de.gamingplugin.hardCoreFFA.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.net.http.WebSocket;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        Bukkit.getScheduler().runTask(HardCoreFFA.getInstance(), () -> {

            for (Player all : Bukkit.getOnlinePlayers()) {
                ScoreboardManager.updateOnlinePlayers(all);
            }

        });

        if (HardCoreFFA.getInstance().getConfig().contains("QUIT_MESSAGE")) {

            if (HardCoreFFA.getInstance().getConfig().getBoolean("QUIT_MESSAGE") == true) {

                event.setQuitMessage("§8[§c-§8] §e" + player.getName());

            } else event.setQuitMessage(null);

        } else {
            HardCoreFFA.getInstance().getConfig().set("QUIT_MESSAGE", true);
            HardCoreFFA.getInstance().saveConfig();

            if (HardCoreFFA.getInstance().getConfig().getBoolean("QUIT_MESSAGE") == true) {

                event.setQuitMessage("§8[§c-§8] §e" + player.getName());

            } else event.setQuitMessage(null);

        }

    }

}
