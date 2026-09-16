package de.gamingplugin.hardCoreFFA.manager;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ActionbarManager {


    public void sendAction(final Player player, String actionbar){

        Bukkit.getScheduler().runTaskTimer(HardCoreFFA.getInstance(), () -> {
            player.sendActionBar(actionbar);
        },0,20);
    }


}
