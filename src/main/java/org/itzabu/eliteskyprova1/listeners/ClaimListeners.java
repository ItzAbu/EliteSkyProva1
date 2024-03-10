package org.itzabu.eliteskyprova1.listeners;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.itzabu.eliteskyprova1.EliteSkyProva1;
import org.itzabu.eliteskyprova1.utils.CustomConfig;

import java.util.ArrayList;

public class ClaimListeners implements Listener {

    public static void Imports(ArrayList<World> worlds) {
        int terr = CustomConfig.getSaveFileConfig().getInt("Mondi");
        if(terr == 0) {
            return;
        }
        for(World world : worlds) {
            for(int i = 1; i <= terr; i++) {
                ArrayList<ArrayList<String>> coords = (ArrayList<ArrayList<String>>) CustomConfig.getSaveFileConfig().getList("Claim."+ i + ".coords");
                if(coords == null) {
                    continue;
                }
                EliteSkyProva1.addTerritori(coords);
            }
        }
    }



}
