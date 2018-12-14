package me.magnum.tntinfo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TNTInfo extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onTNT(EntityExplodeEvent event) {
        if (!event.getEntityType().equals(EntityType.PRIMED_TNT)) {
            return;
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getLocation().distanceSquared(event.getLocation()) <= 625) {
                player.sendMessage(ChatColor.RED + "TNT blew up near you.");
            }
        }
    }
}
