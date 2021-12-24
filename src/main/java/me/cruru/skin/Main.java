package me.cruru.skin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("skin").setExecutor(new SkinChangerCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
