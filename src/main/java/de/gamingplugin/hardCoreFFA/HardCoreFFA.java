package de.gamingplugin.hardCoreFFA;

import de.gamingplugin.hardCoreFFA.commands.BuildCommand;
import de.gamingplugin.hardCoreFFA.commands.SpawnCommand;
import de.gamingplugin.hardCoreFFA.commands.setLocationCommand;
import de.gamingplugin.hardCoreFFA.listener.*;
import de.gamingplugin.hardCoreFFA.manager.ActionbarManager;
import de.gamingplugin.hardCoreFFA.manager.LocationManager;
import de.gamingplugin.hardCoreFFA.stats.Stats;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HardCoreFFA extends JavaPlugin {

    public static String PREFIX = "§6‧§e• HardcoreFFA §8| §7";
    public static String NO_PERMS = "§cDu hast keine Brechtigung!";

    private static HardCoreFFA instance;
    public static LocationManager locationManager = new LocationManager();
    public static ActionbarManager actionbarManager = new ActionbarManager();
    public static Stats stats = new Stats();

    @Override
    public void onEnable() {


        saveDefaultConfig();
        instance = this;


        Bukkit.getConsoleSender().sendMessage(PREFIX + "Das Plugin wurde §agestartet§8.");
        load(Bukkit.getPluginManager());
        getCommand("location").setExecutor(new setLocationCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());

    }


    private void load(PluginManager pluginManager) {

        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new FoodLVLListener(), this);
        pluginManager.registerEvents(new PlayerDeathListener(), this);

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "Das Plugin wurde §cgestoppt§8.");
    }

    public static HardCoreFFA getInstance() {
        return instance;
    }

    public static LocationManager getLocationManager() {
        return locationManager;
    }

    public static ActionbarManager getActionbarManager() {
        return actionbarManager;
    }

    public static Stats getStats() {
        return stats;
    }
}
