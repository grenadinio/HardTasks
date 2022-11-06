package me.grenadinio.hardtasks.pathfinders;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Predicate;

public class PathFinderGoalAttackNonOwnerPlayer<T extends EntityLiving> extends PathfinderGoalTarget {
    protected final Class<T> targetClass;
    protected final int targetChance;
    protected EntityLiving nearestTarget;
    protected PathfinderTargetCondition targetEntitySelector;
    protected final Player owner;

    public PathFinderGoalAttackNonOwnerPlayer(EntityInsentient entityinsentient, Class<T> oclass, Player owner, boolean flag) {
        this(entityinsentient, oclass, owner, flag, false);
    }

    public PathFinderGoalAttackNonOwnerPlayer(EntityInsentient entityinsentient, Class<T> oclass, Player owner, boolean flag, boolean flag1) {
        this(entityinsentient, oclass, owner, 10, flag, flag1, null);
    }

    public PathFinderGoalAttackNonOwnerPlayer(EntityInsentient entityinsentient, Class<T> oclass, Player owner, int i, boolean flag, boolean flag1, @Nullable Predicate<EntityLiving> predicate) {
        super(entityinsentient, flag, flag1);
        this.targetClass = oclass;
        this.targetChance = i;
        this.a(EnumSet.of(Type.TARGET));
        this.targetEntitySelector = (new PathfinderTargetCondition()).a(this.k()).a(predicate);
        this.owner = owner;
    }

    public boolean a() {
        if (this.targetChance > 0 && this.e.getRandom().nextInt(this.targetChance) != 0) {
            return false;
        } else {
            this.findNearestTarget();
            return this.nearestTarget != null;
        }
    }

    protected void findNearestTarget() {
        if (this.targetClass == EntityHuman.class || this.targetClass == EntityPlayer.class) {
            this.nearestTarget = this.e.world.a(this.targetEntitySelector, this.e, this.e.locX(), this.e.getHeadY(), this.e.locZ());
        } else {
            this.nearestTarget = null;
        }

    }

    public void c() {
        if (!Objects.equals(nearestTarget.getUniqueID(), owner.getUniqueId())) {
            this.e.setGoalTarget(this.nearestTarget, EntityTargetEvent.TargetReason.CUSTOM, true);
        }
        super.c();
    }

}
