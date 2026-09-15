package de.gamingplugin.hardCoreFFA;

import de.gamingplugin.hardCoreFFA.commands.BuildCommand;
import de.gamingplugin.hardCoreFFA.commands.setLocationCommand;
import de.gamingplugin.hardCoreFFA.listener.*;
import de.gamingplugin.hardCoreFFA.manager.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HardCoreFFA extends JavaPlugin {

   public static String PREFIX = "§6‧§e• HardcoreFFA §8| §7";
   public static String NO_PERMS = "§cDu hast keine Brechtigung!";

   private static HardCoreFFA instance;
   public static LocationManager locationManager = new LocationManager();

    @Override
    public void onEnable() {

        saveDefaultConfig();
        instance = this;


        Bukkit.getConsoleSender().sendMessage(PREFIX + "Das Plugin wurde §agestartet§8.");
        load(Bukkit.getPluginManager());
        getCommand("location").setExecutor(new setLocationCommand());
        getCommand("build").setExecutor(new BuildCommand());

    }


    private void load(PluginManager pluginManager){

        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new FoodLVLListener(), this);
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
}
