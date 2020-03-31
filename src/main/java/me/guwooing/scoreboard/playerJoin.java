package me.guwooing.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class PlayerJoin implements Listener {

    private CustomScoreboard plugin;

    public PlayerJoin(CustomScoreboard plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        createScoreboard(e.getPlayer());
        updateScoreboard();
    }

    public void createScoreboard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Server", "dummy");
        objective.setDisplayName(Utils.chat(plugin.getConfig().getString("server_name")));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score user = objective.getScore(Utils.chat(plugin.getConfig().getString("line8")));
        user.setScore(8);

        Score onlineplayer = objective.getScore(Utils.chat(plugin.getConfig().getString("line7")));
        onlineplayer.setScore(7);


        Score blue = objective.getScore(Utils.chat(plugin.getConfig().getString("line6")));
        blue.setScore(6);

        Score blueinfo = objective.getScore(Utils.chat(plugin.getConfig().getString("line5")));
        blueinfo.setScore(5);


        Score pink = objective.getScore(Utils.chat(plugin.getConfig().getString("line4")));
        pink.setScore(4);

        Score pinkinfo = objective.getScore(Utils.chat(plugin.getConfig().getString("line3")));
        pinkinfo.setScore(3);

        Score server = objective.getScore(Utils.chat(plugin.getConfig().getString("line2")));
        server.setScore(2);

        Score ip = objective.getScore(Utils.chat(plugin.getConfig().getString("line1")));
        ip.setScore(1);

        Score version = objective.getScore(Utils.chat(plugin.getConfig().getString("line0")));
        version.setScore(0);


        p.setScoreboard(board);
    }

    public void updateScoreboard() {
        for(Player online : Bukkit.getOnlinePlayers()) {
            Score onlineplayer = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§a§l » " + "§7Online§8: §f" + Bukkit.getOnlinePlayers().size());
        }
    }
}
