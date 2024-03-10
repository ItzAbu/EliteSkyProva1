package org.itzabu.eliteskyprova1.utils.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.itzabu.eliteskyprova1.utils.ChatColor;
import org.itzabu.eliteskyprova1.utils.CustomConfig;

import java.util.ArrayList;


import static org.itzabu.eliteskyprova1.utils.ChatColor.translateAlternateColorCodes;

public class SelectorAxe {
    static ItemStack selectorAxe = new ItemStack(Material.WOODEN_AXE, 1);
    static ItemMeta selectorAxeMeta = selectorAxe.getItemMeta();
    ArrayList<String> Selectorlore;

    public SelectorAxe() {
        String nome = CustomConfig.getMessaggiCustomConfig().getString("SelectorAxe.Nome");
        String error = "&cErrore, Controlla i file di config";
        if(nome != null)
        selectorAxeMeta.setDisplayName(translateAlternateColorCodes(nome));
        else {
            selectorAxeMeta.setDisplayName(translateAlternateColorCodes(error));
        }

        Selectorlore = (ArrayList<String>) CustomConfig.getMessaggiCustomConfig().getList("SelectorAxe.Lore");
        assert Selectorlore != null;
        Selectorlore.replaceAll(ChatColor::translateAlternateColorCodes);

        selectorAxeMeta.setLore(Selectorlore);
        selectorAxeMeta.setUnbreakable(true);
        selectorAxe.setItemMeta(selectorAxeMeta);
    }

    public ItemStack getSelectorAxe() {
        return selectorAxe;
    }
    public static ItemMeta getSelectorAxeMeta() {
        return selectorAxeMeta;
    }
}
