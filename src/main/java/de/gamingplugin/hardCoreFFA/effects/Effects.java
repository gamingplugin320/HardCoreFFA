package de.gamingplugin.hardCoreFFA.effects;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.*;

public class Effects {

    public static void spawnParticleCircle(Location center, double radius, int points) {

        World world = center.getWorld();

        double increment = (2 * Math.PI) / points;

        for (int i = 0; i < points; i++) {

            double angle = i * increment;

            double x = center.getX() + radius * Math.cos(angle);
            double z = center.getZ() + radius * Math.sin(angle);

            Location particleLoc = new Location(
                    world,
                    x,
                    center.getY() + 0.1,
                    z
            );

            world.spawnParticle(
                    Particle.ENTITY_EFFECT,
                    particleLoc,
                    1,
                    0, 0, 0,
                    0,
                    Color.WHITE
            );
        }
    }


    public static void startParticle(final Location location) {

        Bukkit.getScheduler().runTaskTimer(HardCoreFFA.getInstance(), () -> {

            Effects.spawnParticleCircle(location, 1.3, 70);

        }, 20, 30);

    }
}