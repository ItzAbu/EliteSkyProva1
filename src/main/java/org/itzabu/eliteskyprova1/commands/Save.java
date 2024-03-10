package org.itzabu.eliteskyprova1.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.itzabu.eliteskyprova1.listeners.AxeListener;
import org.itzabu.eliteskyprova1.listeners.ClaimListeners;
import org.itzabu.eliteskyprova1.utils.CustomConfig;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static org.itzabu.eliteskyprova1.utils.ChatColor.translateAlternateColorCodes;

public class Save implements CommandExecutor {

    static int numWorlds = CustomConfig.getSaveFileConfig().getInt("Mondi");

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender instanceof Player)) {
            String NoConsole = translateAlternateColorCodes(CustomConfig.getMessaggiCustomConfig().getString("Console"));
            assert NoConsole != null;
            commandSender.sendMessage(NoConsole);
        }
        Player player = (Player) commandSender;

        AxeListener.getAll();
        ArrayList<String> all = AxeListener.getCoords();
        if (all == null) {
            String error = translateAlternateColorCodes(CustomConfig.getMessaggiCustomConfig().getString("Errori.Coords"));
            if (error == null) {
                error = "&cErrore, Controlla i file di config";
            } else {
                player.sendMessage(error);
            }
            return true;
        }

        FileConfiguration file = CustomConfig.getSaveFileConfig();
        ArrayList<String> coords = new ArrayList<>();
        coords.add(all.get(0));
        coords.add(all.get(1));
        coords.add(all.get(2));
        coords.add(all.get(3));
        coords.add(all.get(4));
        coords.add(all.get(5));
        coords.add(all.get(6));
        file.set("Claim." + numWorlds + ".coords", coords);
        if (!coords.isEmpty()) {
            coords = new ArrayList<>();
        }

        file.set("Claim." + numWorlds + ".Anti-Explo.TNT", true);
        file.set("Claim." + numWorlds + ".Anti-Explo.Creeper", true);
        numWorlds++;
        CustomConfig.getSaveFileConfig().set("Mondi", numWorlds);
        CustomConfig.saveSaveFileConfig();
        ArrayList<World> worlds = (ArrayList<World>) player.getServer().getWorlds();
        ClaimListeners.Imports(worlds);


        return true;

    }
}
