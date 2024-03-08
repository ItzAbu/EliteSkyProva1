package org.itzabu.eliteskyprova1.listeners;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.itzabu.eliteskyprova1.utils.CustomConfig;

public class AntiExplo implements Listener {

    @EventHandler
    public void onExplosion(ExplosionPrimeEvent e) {
        World mondo = e.getEntity().getWorld();
        boolean creeper = Boolean.parseBoolean(CustomConfig.getMessaggiCustomConfig().getString("Anti-Explo."+ mondo.getName() + ".Creeper"));
        boolean tnt = Boolean.parseBoolean(CustomConfig.getMessaggiCustomConfig().getString("Anti-Explo." + mondo.getName() + ".TNT"));
        if(e.getEntity().getType().toString().equals("CREEPER") && creeper) {
            e.setCancelled(true);
        }
        if(e.getEntity().getType().toString().equals("PRIMED_TNT") && tnt) {
            e.setCancelled(true);
        }
    }

}
