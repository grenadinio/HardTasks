package me.grenadinio.hardtasks.pathfinders;

import net.minecraft.server.v1_16_R3.EntityInsentient;
import net.minecraft.server.v1_16_R3.Navigation;
import net.minecraft.server.v1_16_R3.PathEntity;
import net.minecraft.server.v1_16_R3.PathfinderGoal;
import org.bukkit.Location;

public class PathfinderGoalWalkToLoc extends PathfinderGoal {
    private double speed;
    private EntityInsentient entity;
    private Location loc;
    private Navigation navigation;

    public PathfinderGoalWalkToLoc(EntityInsentient entity, Location loc, double speed) {
        this.entity = entity;
        this.loc = loc;
        this.navigation = (Navigation) this.entity.getNavigation();
        this.speed = speed;
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public void c() {
        PathEntity pathEntity = this.navigation.a(loc.getX(), loc.getY(), loc.getZ(), 0);
        this.navigation.a(pathEntity, speed);
    }

    @Override
    public void e() {
        if (Math.abs(entity.getPositionVector().x - loc.getX()) <= 1
                && Math.abs(entity.getPositionVector().y - loc.getY()) <= 1
                && Math.abs(entity.getPositionVector().z - loc.getZ()) <= 1) {
            entity.setHealth(0);

        }
    }
}
