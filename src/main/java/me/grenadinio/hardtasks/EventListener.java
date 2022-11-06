package me.grenadinio.hardtasks;

import me.grenadinio.hardtasks.customentities.CustomZombie;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.Location;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerInteractWithLeaves(PlayerInteractEvent event) {
        if (!event.hasBlock()) return;
        if (!(event.getClickedBlock().getBlockData() instanceof Leaves)) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        // Чтобы не спаунились два зомби (ивент на каждую руку)
        if (event.getHand().equals(EquipmentSlot.OFF_HAND)) return;

        Location playerLocation = event.getPlayer().getLocation();
        WorldServer worldServer = ((CraftWorld) event.getPlayer().getWorld()).getHandle();

        CustomZombie customZombie = new CustomZombie(worldServer, event.getPlayer());
        customZombie.setPosition(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ());

        worldServer.addEntity(customZombie);

    }

}
