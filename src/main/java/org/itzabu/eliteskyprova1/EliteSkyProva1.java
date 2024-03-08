package org.itzabu.eliteskyprova1;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.itzabu.eliteskyprova1.utils.CustomConfig;

import java.util.List;

import static org.itzabu.eliteskyprova1.utils.ChatColor.translateAlternateColorCodes;

public final class EliteSkyProva1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveConfig();

        CustomConfig.setup();
        CustomConfig.getMessaggiCustomConfig().addDefault("Reload", "&aConfigurazione ricaricata con successo!");

        List<World> Mondi = getServer().getWorlds();

        for (World mondo : Mondi) {
            CustomConfig.getMessaggiCustomConfig().addDefault("Anti-Explo." + mondo.getName() + ".Creeper", "true");
            CustomConfig.getMessaggiCustomConfig().addDefault("Anti-Explo." + mondo.getName() + ".TNT", "true");
        }
        CustomConfig.getMessaggiCustomConfig().options().copyDefaults(true);
        CustomConfig.getSaveFileConfig().options().copyDefaults(true);
        CustomConfig.saveMessaggiCustomConfig();
        CustomConfig.saveSaveFileConfig();

        getServer().getPluginManager().registerEvents(new org.itzabu.eliteskyprova1.listeners.AntiExplo(), this);
        getCommand("reload").setExecutor(new org.itzabu.eliteskyprova1.commands.Reload());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
