package me.grenadinio.hardtasks.customentities;

import me.grenadinio.hardtasks.pathfinders.PathFinderGoalAttackNonOwnerPlayer;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityZombie;
import net.minecraft.server.v1_16_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_16_R3.World;
import org.bukkit.entity.Player;

public class CustomZombie extends EntityZombie {
    public CustomZombie(World world, Player player) {
        super(world);
        //Удаляем все цели
        this.targetSelector = new PathfinderGoalSelector(world.getMethodProfilerSupplier());
        //Добавляем в цели всех игроков кроме того, кто его заспаунил
        this.targetSelector.a(0, new PathFinderGoalAttackNonOwnerPlayer<>(this, EntityHuman.class, player, true));

    }
}
