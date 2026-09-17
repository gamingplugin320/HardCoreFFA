package de.gamingplugin.hardCoreFFA.scoreboard;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {


    public static void setScoreboard(final Player player) {


        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("FFA", "dummy", "§6‧§e• HardcoreFFA §e•§6‧");
        int deaths = HardCoreFFA.getInstance().getConfig().getInt("players." + player.getUniqueId() + ".tode");
        int kills = HardCoreFFA.getInstance().getConfig().getInt("players." + player.getUniqueId() + ".kills");


        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore("§8§M----------------").setScore(10);
        objective.getScore("§1").setScore(9);
        objective.getScore("  §8‧§7• Name").setScore(8);
        objective.getScore("§8§l ➜ §e" + player.getName()).setScore(7);
        objective.getScore("§2").setScore(6);
        objective.getScore("  §8‧§7• Online").setScore(5);
        objective.getScore("§8§l ➜ §e" + Bukkit.getServer().getOnlinePlayers().size()).setScore(4);
        objective.getScore("§3").setScore(3);
        objective.getScore("  §8‧§7• §aKills §8| §cDeaths").setScore(2);
        objective.getScore("§8§l ➜ §a" + kills + " §8| §c" + deaths).setScore(1);
        objective.getScore("§8§M----------------§7").setScore(0);


        player.setScoreboard(scoreboard);
    }

    public static void updateScoreboardKiller(final Player player) {

        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.getObjective("FFA");

        String path = "players." + player.getUniqueId() + ".kills";
        int kills = HardCoreFFA.getInstance().getConfig().getInt(path);
        String pathDeath = "players." + player.getUniqueId() + ".tode";
        int deaths = HardCoreFFA.getInstance().getConfig().getInt(pathDeath);

        int oldKills = kills - 1;

        objective.getScore("§8§l ➜ §a" + oldKills + " §8| §c" + deaths).resetScore();

        objective.getScore("§8§l ➜ §a" + kills + " §8| §c" + deaths).setScore(1);

    }

    public static void updateScoreboardDeathPlayer(final Player player) {

        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.getObjective("FFA");

        String path = "players." + player.getUniqueId() + ".kills";
        int kills = HardCoreFFA.getInstance().getConfig().getInt(path);
        String pathDeath = "players." + player.getUniqueId() + ".tode";
        int deaths = HardCoreFFA.getInstance().getConfig().getInt(pathDeath);


        int oldDeath = deaths - 1;

        objective.getScore("§8§l ➜ §a" + kills + " §8| §c" + oldDeath).resetScore();

        objective.getScore("§8§l ➜ §a" + kills + " §8| §c" + deaths).setScore(1);

    }

}
