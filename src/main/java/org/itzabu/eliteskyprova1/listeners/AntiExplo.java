package org.itzabu.eliteskyprova1.listeners;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.itzabu.eliteskyprova1.EliteSkyProva1;
import org.itzabu.eliteskyprova1.utils.CustomConfig;

import java.util.ArrayList;

public class AntiExplo implements Listener {


    @EventHandler
    public void onExplosion(ExplosionPrimeEvent e) {
        World mondocorrente = e.getEntity().getWorld();
        int numMondi = CustomConfig.getSaveFileConfig().getInt("Mondi");
        for(int i = 0; i < numMondi; i++) {
            ArrayList<String> coords = (ArrayList<String>) CustomConfig.getSaveFileConfig().get("Claim." + i + ".coords");
            if(coords == null) {
                continue;
            }
            World mondo = EliteSkyProva1.getPlugin().getServer().getWorld(coords.get(0));
            if(mondo == mondocorrente) {
                boolean TNT = CustomConfig.getSaveFileConfig().getBoolean("Claim." + i + ".Anti-Explo.TNT");
                boolean Creeper = CustomConfig.getSaveFileConfig().getBoolean("Claim." + i + ".Anti-Explo.Creeper");
                int x1 = Integer.parseInt(coords.get(1));
                int y1 = Integer.parseInt(coords.get(2));
                int z1 = Integer.parseInt(coords.get(3));
                int x2 = Integer.parseInt(coords.get(4));
                int y2 = Integer.parseInt(coords.get(5));
                int z2 = Integer.parseInt(coords.get(6));
                if(Math.min(x1, x2) <= e.getEntity().getLocation().getBlockX() && Math.max(x1, x2) >= e.getEntity().getLocation().getBlockX() && Math.min(y1, y2) <= e.getEntity().getLocation().getBlockY() && Math.max(y1, y2) >= e.getEntity().getLocation().getBlockY() && Math.min(z1, z2) <= e.getEntity().getLocation().getBlockZ() && Math.max(z1, z2) >= e.getEntity().getLocation().getBlockZ()) {
                    if (TNT && (e.getEntityType() == EntityType.PRIMED_TNT)) {
                        e.setCancelled(true);
                        return;
                    }
                    if (Creeper && (e.getEntityType() == EntityType.CREEPER)) {
                        e.setCancelled(true);
                        return;
                    }
                }
            }
        }
    }

}
