package de.gamingplugin.hardCoreFFA.listener;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.Bukkit;
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
        HardCoreFFA.getStats().addKill(killerPlayer.getUniqueId());

        deathPlayer.teleport(HardCoreFFA.getLocationManager().getLocation("spawn"));




    }

}
