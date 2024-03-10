package org.itzabu.eliteskyprova1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.itzabu.eliteskyprova1.utils.CustomConfig;
import org.itzabu.eliteskyprova1.utils.items.SelectorAxe;
import org.jetbrains.annotations.NotNull;

import static org.itzabu.eliteskyprova1.utils.ChatColor.translateAlternateColorCodes;

public class GiveAxe implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            String NoConsole = CustomConfig.getMessaggiCustomConfig().getString("Console");
            assert NoConsole != null;
            sender.sendMessage(translateAlternateColorCodes(NoConsole));
            return true;
        }
        Player player = (Player) sender;
        player.getInventory().addItem(new SelectorAxe().getSelectorAxe());
        return true;
    }
}
