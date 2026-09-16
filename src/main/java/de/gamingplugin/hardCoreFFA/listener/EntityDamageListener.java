package de.gamingplugin.hardCoreFFA.listener;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onDamage(final EntityDamageEvent event){

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        final Player player = (Player) event.getEntity();

        if(player.getLocation().getY() >= HardCoreFFA.getInstance().getConfig().getInt("Locations.spawn.y")){
            event.setCancelled(true);
        }else  return;

    }


    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        event.setCancelled(true);
    }

}
