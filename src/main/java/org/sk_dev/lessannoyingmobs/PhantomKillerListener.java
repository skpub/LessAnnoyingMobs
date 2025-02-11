package org.sk_dev.lessannoyingmobs;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Phantom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PhantomKillerListener implements Listener {
    private final JavaPlugin pluginInstance;

    public PhantomKillerListener(JavaPlugin instance) {
        this.pluginInstance = instance;
    }
    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() != EntityType.PHANTOM) {
            return;
        } else {
            killLoop((Phantom)event.getEntity(), event);
        }
    }
    private void killLoop(final Phantom phantom, CreatureSpawnEvent event) {
        phantom.setGlowing(true);
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                if (!phantom.isDead()) {
                    Location phantomLocation = phantom.getLocation();
                    phantom.getWorld().strikeLightningEffect(phantomLocation);
                    phantom.getWorld().createExplosion(phantomLocation, 0F, false, false);
                    phantom.damage(3.0);
                } else {
                    cancel();
                }
            }
        };
        task.runTaskTimer(this.pluginInstance, 0, 20);
    }
}
