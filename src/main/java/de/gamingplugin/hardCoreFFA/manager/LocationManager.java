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





    public void setLocation(Location location, String name){

        HardCoreFFA.getInstance().getConfig().set("locations." + name + ".world", location.getWorld().getName());
        HardCoreFFA.getInstance().getConfig().set("locations." + name + ".x", location.getX());
        HardCoreFFA.getInstance().getConfig().set("locations." + name + ".y", location.getY());
        HardCoreFFA.getInstance().getConfig().set("locations." + name + ".z", location.getZ());
        HardCoreFFA.getInstance().getConfig().set("locations." + name + ".yaw", location.getYaw());
        HardCoreFFA.getInstance().getConfig().set("locations." + name + ".pitch", location.getPitch());
        HardCoreFFA.getInstance().saveConfig();

    }

    public Location getLocation(String name){

        World world = Bukkit.getWorld(HardCoreFFA.getInstance().getConfig().getString("locations." + name + ".world"));
        double x = HardCoreFFA.getInstance().getConfig().getDouble("locations." + name + ".x");
        double y = HardCoreFFA.getInstance().getConfig().getDouble("locations." + name + ".y");
        double z = HardCoreFFA.getInstance().getConfig().getDouble("locations." + name + ".z");
        float yaw = (float) HardCoreFFA.getInstance().getConfig().getDouble("locations." + name + ".yaw");
        float ptich = (float) HardCoreFFA.getInstance().getConfig().getDouble("locations." + name + ".ptich");

        final Location location = new Location(world, x, y, z, yaw, ptich);

        return location;
    }
}
