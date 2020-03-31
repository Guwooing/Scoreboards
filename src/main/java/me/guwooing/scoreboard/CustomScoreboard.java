package me.guwooing.scoreboard;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomScoreboard extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        saveDefaultConfig();
    }
}