package de.gamingplugin.hardCoreFFA.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.ClockTimeSkipEvent;

public class WorldListener implements Listener {

    @EventHandler
    public void onTime(final ClockTimeSkipEvent event){event.setCancelled(true);}
    @EventHandler
    public void onWeather(final WeatherChangeEvent event){event.setCancelled(true);}
}
