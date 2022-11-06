package me.grenadinio.hardtasks;

import me.grenadinio.hardtasks.commands.CommandSetPos;
import me.grenadinio.hardtasks.commands.CommandSpawnSheep;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class HardTasksPlugin extends JavaPlugin {
    public ArrayList<Location> location = new ArrayList<>();

    @Override
    public void onEnable() {
        this.getCommand("setpos").setExecutor(new CommandSetPos(location));
        this.getCommand("spawnsheep").setExecutor(new CommandSpawnSheep(location));
        EventListener eventListener = new EventListener();
        getServer().getPluginManager().registerEvents(eventListener, this);
    }

    @Override
    public void onDisable(){

    }

}
