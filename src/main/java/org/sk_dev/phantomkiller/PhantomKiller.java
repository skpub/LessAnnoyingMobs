package org.sk_dev.phantomkiller;

import org.bukkit.plugin.java.JavaPlugin;

public final class PhantomKiller extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PhantomKillerListener(this), this);
    }

    @Override
    public void onDisable() {
    }
}
