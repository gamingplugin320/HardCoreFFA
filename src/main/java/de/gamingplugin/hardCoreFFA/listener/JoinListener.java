package de.gamingplugin.hardCoreFFA.listener;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import de.gamingplugin.hardCoreFFA.defaults.FFADefaults;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener    {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event){

        final Player player = event.getPlayer();

        if(HardCoreFFA.getInstance().getConfig().contains("JOIN_MESSAGE")){

            if(HardCoreFFA.getInstance().getConfig().getBoolean("JOIN_MESSAGE") == true){

                event.setJoinMessage("§8[§a+§8] §e" + player.getName());

            }else event.setJoinMessage(null);

        }else {
            HardCoreFFA.getInstance().getConfig().set("JOIN_MESSAGE", true);
            HardCoreFFA.getInstance().saveConfig();

            if(HardCoreFFA.getInstance().getConfig().getBoolean("JOIN_MESSAGE") == true){

                event.setJoinMessage("§8[§a+§8] §e" + player.getName());

            }else event.setJoinMessage(null);
        }

        FFADefaults.spawnDefaults(player);
       if(HardCoreFFA.getInstance().getConfig().contains("Locations.spawn")){
           player.teleport(HardCoreFFA.getLocationManager().getLocation("spawn"));
       }else
           player.sendMessage(HardCoreFFA.PREFIX + "Bitte setzte erst den §eSpawn§7!");

    }




}
