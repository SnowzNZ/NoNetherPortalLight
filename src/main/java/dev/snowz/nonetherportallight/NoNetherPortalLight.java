package dev.snowz.nonetherportallight;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoNetherPortalLight extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPortalLight(PortalCreateEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                event.setCancelled(true);
                player.sendMessage("You cannot light portals in the nether!");
            }
        }
    }
}
