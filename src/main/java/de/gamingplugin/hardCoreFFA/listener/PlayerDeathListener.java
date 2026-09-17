package de.gamingplugin.hardCoreFFA.listener;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import de.gamingplugin.hardCoreFFA.defaults.FFADefaults;
import de.gamingplugin.hardCoreFFA.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onKill(final PlayerDeathEvent event) {

        final Player deathPlayer = event.getEntity();
        final Player killerPlayer = deathPlayer.getKiller();

        HardCoreFFA.getStats().addDeath(deathPlayer.getUniqueId());
        ScoreboardManager.updateScoreboardDeathPlayer(deathPlayer);
        HardCoreFFA.getStats().addKill(killerPlayer.getUniqueId());
        ScoreboardManager.updateScoreboardKiller(killerPlayer);

        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(HardCoreFFA.PREFIX + "Der Spieler §e" + deathPlayer.getName() + "§7 wurde von §e" +
                    killerPlayer.getName() + "§7 gekillt!");
        }

        killerPlayer.playSound(killerPlayer, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

        if (deathPlayer.getHealth() < 1) {
            deathPlayer.getInventory().clear();

            Bukkit.getScheduler().runTask(HardCoreFFA.getInstance(), () -> {
               deathPlayer.teleport(HardCoreFFA.getLocationManager().getLocation("spawn"));
            });

            deathPlayer.setHealth(20);
            FFADefaults.spawnItems(deathPlayer);
            event.setCancelled(true);
        }


    }

}
