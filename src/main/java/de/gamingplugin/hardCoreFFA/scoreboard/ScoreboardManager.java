package de.gamingplugin.hardCoreFFA.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {


    public static void setScoreboard(final Player player ){


         Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
         Objective objective = scoreboard.registerNewObjective("FFA" , "dummy", "§6‧§e• HardcoreFFA §e•§6‧");


        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore("§8§M----------------").setScore(10);
        objective.getScore("§1").setScore(9);
        objective.getScore("  §8‧§7• Name").setScore(8);
        objective.getScore("§8§l ➜ §e" + player.getName()).setScore(7);
        objective.getScore("§2").setScore(6);
        objective.getScore("  §8‧§7• Online").setScore(5);
        objective.getScore("§8§l ➜ §e" + Bukkit.getServer().getOnlinePlayers().size()).setScore(4);
        objective.getScore("§3").setScore(3);
        objective.getScore("  §8‧§7• Teamspeak").setScore(2);
        objective.getScore("§8§l ➜ §eDeinServer.de").setScore(1);
        objective.getScore("§8§M----------------§7").setScore(0);


        player.setScoreboard(scoreboard);
    }

}
