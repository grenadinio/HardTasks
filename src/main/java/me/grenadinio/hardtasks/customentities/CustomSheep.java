package me.grenadinio.hardtasks.customentities;

import me.grenadinio.hardtasks.pathfinders.PathfinderGoalWalkToLoc;
import net.minecraft.server.v1_16_R3.EntitySheep;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_16_R3.World;
import org.bukkit.Location;

public class CustomSheep extends EntitySheep {
    Location location;

    public CustomSheep(World world, Location location) {
        super(EntityTypes.SHEEP, world);
        this.location = location;

        this.goalSelector = new PathfinderGoalSelector(world.getMethodProfilerSupplier());
        this.targetSelector = new PathfinderGoalSelector(world.getMethodProfilerSupplier());

        this.goalSelector.a(0, new PathfinderGoalWalkToLoc(this, location, 1));

    }


}
