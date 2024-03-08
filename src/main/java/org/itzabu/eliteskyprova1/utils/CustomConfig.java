package org.itzabu.eliteskyprova1.utils;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class CustomConfig {

    private static File messaggiCustom;
    private static File saveFile;
    private static FileConfiguration messaggiCustomConfig;
    private static FileConfiguration saveFileConfig;


    public static void setup() {
        messaggiCustom = new File("plugins/EliteSkyProva1/messaggiCustom.yml");
        saveFile = new File("plugins/EliteSkyProva1/saveFile.yml");
        messaggiCustomConfig = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(messaggiCustom);
        saveFileConfig = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(saveFile);
    }

    public static FileConfiguration getMessaggiCustomConfig() {
        return messaggiCustomConfig;
    }

    public static FileConfiguration getSaveFileConfig() {
        return saveFileConfig;
    }

    public static void saveMessaggiCustomConfig() {
        try {
            messaggiCustomConfig.save(messaggiCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveSaveFileConfig() {
        try {
            saveFileConfig.save(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        messaggiCustomConfig = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(messaggiCustom);
        saveFileConfig = org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(saveFile);
    }
}
