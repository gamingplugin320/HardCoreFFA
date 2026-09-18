package de.gamingplugin.hardCoreFFA.manager;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class LocationManager {





    public void setLocation(Location location, String name) {

        HardCoreFFA.getInstance().getConfig().set("Locations." + name + ".world", location.getWorld().getName());
        HardCoreFFA.getInstance().getConfig().set("Locations." + name + ".x", location.getX());
        HardCoreFFA.getInstance().getConfig().set("Locations." + name + ".y", location.getY());
        HardCoreFFA.getInstance().getConfig().set("Locations." + name + ".z", location.getZ());
        HardCoreFFA.getInstance().getConfig().set("Locations." + name + ".yaw", location.getYaw());
        HardCoreFFA.getInstance().getConfig().set("Locations." + name + ".pitch", location.getPitch());
        HardCoreFFA.getInstance().saveConfig();

    }

    public Location getLocation(String name) {

        World world = Bukkit.getWorld(HardCoreFFA.getInstance().getConfig().getString("Locations." + name + ".world"));
        double x =  HardCoreFFA.getInstance().getConfig().getDouble("Locations." + name + ".x");
        double y =  HardCoreFFA.getInstance().getConfig().getDouble("Locations." + name + ".y");
        double z =  HardCoreFFA.getInstance().getConfig().getDouble("Locations." + name + ".z");
        float yaw = (float)  HardCoreFFA.getInstance().getConfig().getDouble("Locations." + name + ".yaw");
        float ptich = (float)  HardCoreFFA.getInstance().getConfig().getDouble("Locations." + name + ".ptich");

        final Location location = new Location(world, x, y, z, yaw, ptich);

        return location;
    }

}

