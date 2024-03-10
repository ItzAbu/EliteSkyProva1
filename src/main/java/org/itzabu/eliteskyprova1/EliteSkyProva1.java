package org.itzabu.eliteskyprova1;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.itzabu.eliteskyprova1.commands.GiveAxe;
import org.itzabu.eliteskyprova1.commands.Reload;
import org.itzabu.eliteskyprova1.commands.Save;
import org.itzabu.eliteskyprova1.listeners.AntiExplo;
import org.itzabu.eliteskyprova1.listeners.AxeListener;
import org.itzabu.eliteskyprova1.listeners.ClaimListeners;
import org.itzabu.eliteskyprova1.utils.CustomConfig;
import org.itzabu.eliteskyprova1.utils.items.SelectorAxe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.itzabu.eliteskyprova1.utils.ChatColor.translateAlternateColorCodes;

public final class EliteSkyProva1 extends JavaPlugin {

    static ArrayList<ArrayList<ArrayList<String>>> Territori = new ArrayList<>();




    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveConfig();

        CustomConfig.setup();
        CustomConfig.getMessaggiCustomConfig().addDefault("Reload", "&aConfigurazione ricaricata con successo!");
        CustomConfig.getMessaggiCustomConfig().addDefault("Console", "&cNon puoi usare questo comando da console");
        CustomConfig.getMessaggiCustomConfig().addDefault("Errori.world" , "&cHai selezionaro mondi diversi");
        CustomConfig.getMessaggiCustomConfig().addDefault("#NotNullable (Dovete scriverci un nome oppure da errore)", "");
        CustomConfig.getMessaggiCustomConfig().addDefault("SelectorAxe.Nome" , "&aSelector Axe");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("&aUsa questo per selezionare un'area");

        CustomConfig.getMessaggiCustomConfig().addDefault("SelectorAxe.Lore", lore);

        CustomConfig.getSaveFileConfig().addDefault("Mondi", 0);

        CustomConfig.getMessaggiCustomConfig().options().copyDefaults(true);
        CustomConfig.getSaveFileConfig().options().copyDefaults(true);
        CustomConfig.saveMessaggiCustomConfig();
        CustomConfig.saveSaveFileConfig();

        ArrayList<World> worlds = (ArrayList<World>) getServer().getWorlds();
        ClaimListeners.Imports(worlds);


        getServer().getPluginManager().registerEvents(new AntiExplo(), this);
        getServer().getPluginManager().registerEvents(new AxeListener(), this);
        getCommand("reload").setExecutor(new Reload());
        getCommand("Axe").setExecutor(new GiveAxe());
        getCommand("AxeSave").setExecutor(new Save());




    }

    public static void addTerritori(ArrayList<ArrayList<String>> territorio) {
        Territori.add(territorio);
    }

    public static ArrayList<ArrayList<ArrayList<String>>> getTerritori() {
        return Territori;
    }

    public static EliteSkyProva1 getPlugin() {
        return (EliteSkyProva1) Bukkit.getServer().getPluginManager().getPlugin("EliteSkyProva1");
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
