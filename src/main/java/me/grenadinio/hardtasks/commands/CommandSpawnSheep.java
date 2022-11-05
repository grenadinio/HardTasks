package me.grenadinio.hardtasks.commands;

import me.grenadinio.hardtasks.customentities.CustomSheep;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandSpawnSheep implements CommandExecutor {
    ArrayList<Location> location;

    public CommandSpawnSheep(ArrayList<Location> location) {
        this.location = location;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command is only for players!");
            return true;
        }
        if (location.isEmpty()) {
            sender.sendMessage("Вы не указали позицию. Используйте /setpos");
            return true;
        }
        Player player = (Player) sender;
        Location playerLocation = player.getLocation();

        CustomSheep customSheep = new CustomSheep(((CraftWorld) player.getWorld()).getHandle(), location.get(0));
        customSheep.setPosition(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ());
        ((CraftWorld) player.getWorld()).getHandle().addEntity(customSheep);

        return true;
    }
}
