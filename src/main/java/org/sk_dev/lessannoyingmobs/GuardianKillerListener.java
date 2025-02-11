package org.sk_dev.lessannoyingmobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.net.http.WebSocket;

public class GuardianKillerListener implements Listener  {
    @EventHandler
    public void onPlayerHurtByGuardian(EntityDamageByEntityEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.GUARDIAN) {
            Entity guardian = e.getDamager();
            Location guadianLocation = guardian.getLocation();
            guardian.getWorld().createExplosion(guadianLocation, 4, false, false);
        } else {
            return;
        }
    }
}
