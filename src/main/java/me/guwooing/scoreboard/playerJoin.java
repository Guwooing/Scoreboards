package me.guwooing.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class playerJoin extends JavaPlugin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        createScoreboard(e.getPlayer());
        updateScoreboard();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        updateScoreboard();
    }

    public void createScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Server", "dummy");
        objective.setDisplayName(Utils.chat(getConfig.getString("server_name"));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score user = objective.getScore("§a§lPLAYER");
        user.setScore(8);

        Score onlineplayer = objective.getScore("§a » §7Online§8: §f" + Bukkit.getOnlinePlayers().size());
        onlineplayer.setScore(7);


        Score blue = objective.getScore("§b§lBLUE");
        blue.setScore(6);

        Score blueinfo = objective.getScore("§b » §7Money§8: §fN/A");
        blueinfo.setScore(5);


        Score pink = objective.getScore("§d§lPINK");
        pink.setScore(4);

        Score pinkinfo = objective.getScore("§d » §7PinkText§8: §fN/A");
        pinkinfo.setScore(3);

        Score server = objective.getScore("§c§lSERVER");
        server.setScore(2);

        Score ip = objective.getScore("§c » §7Server IP§8: §fN/A");
        ip.setScore(1);

        Score version = objective.getScore("§c » §7Version§8: §f0.0.3");
        version.setScore(0);


        player.setScoreboard(board);
    }

    public void updateScoreboard() {
        for(Player online : Bukkit.getOnlinePlayers()) {
            Score onlineplayer = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§a§l » " + "§7Online§8: §f" + Bukkit.getOnlinePlayers().size());
        }
    }
}
