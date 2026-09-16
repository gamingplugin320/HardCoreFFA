package de.gamingplugin.hardCoreFFA.stats;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Stats {


    public void addKill(final UUID uuid) {

        final Player player = Bukkit.getPlayer(uuid);

        int kills = HardCoreFFA.getInstance().getConfig().getInt("players." + uuid.toString() + ".kills");

        int newkills = kills + 1;

        HardCoreFFA.getInstance().getConfig().set("players." + uuid.toString() + ".kills", newkills);

        HardCoreFFA.getInstance().saveConfig();

    }

    public void addDeath(final UUID uuid) {

        final Player player = Bukkit.getPlayer(uuid);

        String path = "players." + uuid.toString() + ".tode";

        int deaths = HardCoreFFA.getInstance().getConfig().getInt(path);

        int newDeaths = deaths + 1;

        HardCoreFFA.getInstance().getConfig().set(path, newDeaths);

        HardCoreFFA.getInstance().saveConfig();



    }
}
