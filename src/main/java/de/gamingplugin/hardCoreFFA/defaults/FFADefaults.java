package de.gamingplugin.hardCoreFFA.defaults;

import de.gamingplugin.hardCoreFFA.HardCoreFFA;
import de.gamingplugin.hardCoreFFA.commands.BuildCommand;
import de.gamingplugin.hardCoreFFA.scoreboard.ScoreboardManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
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


        BuildCommand.build_mode = false;
        ScoreboardManager.setScoreboard(player);
        player.getInventory().setItem(0, sword);
        player.setGameMode(GameMode.SURVIVAL);
        player.setFoodLevel(20);
        player.setHealth(20);

    }

}
