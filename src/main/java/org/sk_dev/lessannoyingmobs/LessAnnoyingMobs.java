package org.sk_dev.lessannoyingmobs;

import org.bukkit.plugin.java.JavaPlugin;

public final class LessAnnoyingMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PhantomKillerListener(this), this);
        getServer().getPluginManager().registerEvents(new GuardianKillerListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
