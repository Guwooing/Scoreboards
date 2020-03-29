package me.guwooing.scoreboard;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomScoreboard extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new playerJoin(), this);
        saveDefaultConfig();
    }
}