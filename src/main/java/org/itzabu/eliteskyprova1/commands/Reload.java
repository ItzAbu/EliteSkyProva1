package org.itzabu.eliteskyprova1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.itzabu.eliteskyprova1.utils.CustomConfig;

public class Reload implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender,  Command command, String s,  String[] label) {
        CustomConfig.reload();
        return true;
    }
}
