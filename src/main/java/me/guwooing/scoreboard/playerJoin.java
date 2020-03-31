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

        Score s8 = objective.getScore(Utils.chat(plugin.getConfig().getString("line8")));
        s8.setScore(8);

        Score s7 = objective.getScore(Utils.chat(plugin.getConfig().getString("line7").replace("<online>", String.valueOf(Bukkit.getOnlinePlayers().size()))));
        s7.setScore(7);


        Score s6 = objective.getScore(Utils.chat(plugin.getConfig().getString("line6")));
        s6.setScore(6);

        Score s5 = objective.getScore(Utils.chat(plugin.getConfig().getString("line5")));
        s5.setScore(5);


        Score s4 = objective.getScore(Utils.chat(plugin.getConfig().getString("line4")));
        s4.setScore(4);

        Score s3 = objective.getScore(Utils.chat(plugin.getConfig().getString("line3")));
        s3.setScore(3);

        Score s2 = objective.getScore(Utils.chat(plugin.getConfig().getString("line2")));
        s2.setScore(2);

        Score s1 = objective.getScore(Utils.chat(plugin.getConfig().getString("line1")));
        s1.setScore(1);

        Score s0 = objective.getScore(Utils.chat(plugin.getConfig().getString("line0")));
        s0.setScore(0);


        p.setScoreboard(board);
    }

    public void updateScoreboard() {
        for(Player online : Bukkit.getOnlinePlayers()) {
            Score onlineplayer = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§a§l » " + "§7Online§8: §f" + Bukkit.getOnlinePlayers().size());
        }
    }
}
