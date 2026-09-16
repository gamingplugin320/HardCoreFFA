package de.gamingplugin.hardCoreFFA.defaults;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import de.gamingplugin.hardCoreFFA.commands.BuildCommand;
import de.gamingplugin.hardCoreFFA.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;

public class FFADefaults {

    public static void spawnDefaults(final Player player){

        ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(HardCoreFFA.PREFIX + "Schwert");
        swordMeta.isUnbreakable();

        for(Player all : Bukkit.getOnlinePlayers()){
            HardCoreFFA.getActionbarManager().sendAction(all, "§2‧§a• Kills §8§l➜ §a" +
                    HardCoreFFA.getInstance().getConfig().getInt("players." + player.getUniqueId() + ".kills") +
                    " §8| §4‧§c• Tode §8§l➜ §c" +
                    HardCoreFFA.getInstance().getConfig().getInt("players." + player.getUniqueId() + ".tode"));
        }


        BuildCommand.build_mode = false;
        ScoreboardManager.setScoreboard(player);
        player.getInventory().setItem(0, sword);
        player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1,1);
        player.setGameMode(GameMode.SURVIVAL);
        player.setFoodLevel(20);
        player.setHealth(20);

    }

}
