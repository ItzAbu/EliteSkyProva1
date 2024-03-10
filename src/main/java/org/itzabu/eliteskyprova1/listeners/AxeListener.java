package org.itzabu.eliteskyprova1.listeners;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.itzabu.eliteskyprova1.utils.CustomConfig;
import org.itzabu.eliteskyprova1.utils.items.SelectorAxe;

import java.util.ArrayList;

import static org.itzabu.eliteskyprova1.utils.ChatColor.translateAlternateColorCodes;





public class AxeListener implements Listener {

    static int x1;
    static int y1;
    static int z1;
    static int x2;
    static int y2;
    static int z2;

    static World world1;
    static World world2;

    static ArrayList<String> all = new ArrayList<>();

    @EventHandler
    public void onAxeUse(PlayerInteractEvent e) {
        if(e.getItem() == null) return;
        ItemMeta meta = e.getItem().getItemMeta();
        if(meta == null) return;
        if(!(meta.getDisplayName().equals(SelectorAxe.getSelectorAxeMeta().getDisplayName())) ){
            return;
        }
        e.setCancelled(true);
        if(e.getAction().isRightClick()) {
            world1 = e.getPlayer().getWorld();
            x1 = e.getPlayer().getLocation().getBlockX();
            y1 = e.getPlayer().getLocation().getBlockY();
            z1 = e.getPlayer().getLocation().getBlockZ();
            e.getPlayer().sendMessage("X: " + x1 + " Y: " + y1 + " Z: " + z1);
        }
        if(e.getAction().isLeftClick()) {
            world2 = e.getPlayer().getWorld();
            x2 = e.getPlayer().getLocation().getBlockX();
            y2 = e.getPlayer().getLocation().getBlockY();
            z2 = e.getPlayer().getLocation().getBlockZ();
            e.getPlayer().sendMessage("X: " + x2 + " Y: " + y2 + " Z: " + z2);
        }

    }

    public static void getAll() {
        if(world1 == null || world2 == null && world1 != world2) {
            return ;
        }
        if(all.size() != 6) {
            all.add(world1.getName());
            all.add(String.valueOf(x1));
            all.add(String.valueOf(y1));
            all.add(String.valueOf(z1));
            all.add(String.valueOf(x2));
            all.add(String.valueOf(y2));
            all.add(String.valueOf(z2));
            return;
        }
        all.set(0 ,world1.getName());
        all.set(1, String.valueOf(x1));
        all.set(2, String.valueOf(y1));
        all.set(3, String.valueOf(z1));
        all.set(4, String.valueOf(x2));
        all.set(5, String.valueOf(y2));
        all.set(6, String.valueOf(z2));
    }

    public static ArrayList<String> getCoords() {
        return all;
    }


}

