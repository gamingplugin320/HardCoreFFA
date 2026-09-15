package de.gamingplugin.hardCoreFFA.listener;

import de.gamingplugin.hardCoreFFA.commands.BuildCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener  {

    @EventHandler
    public void onBreak(final BlockBreakEvent event){
        if(BuildCommand.build_mode == false){
            event.setCancelled(true);
        }else event.setCancelled(false);
    }
    

}
