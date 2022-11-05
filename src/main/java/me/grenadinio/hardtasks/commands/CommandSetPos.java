package me.grenadinio.hardtasks.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandSetPos implements CommandExecutor {
    ArrayList<Location> location;

    public CommandSetPos(ArrayList<Location> location) {
        this.location = location;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command is only for players!");
            return true;
        }
        Player player = (Player) sender;
        if (!location.isEmpty()) {
            location.set(0, player.getLocation());
        } else {
            location.add(player.getLocation());
        }
        return true;
    }
}
