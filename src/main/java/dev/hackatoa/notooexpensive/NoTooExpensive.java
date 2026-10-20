package dev.hackatoa.notooexpensive;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.view.AnvilView;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Removes the anvil's "Too Expensive!" cap. The vanilla limit is 40 levels per
 * operation; here it is raised so combining books never gets blocked.
 */
public final class NoTooExpensive extends JavaPlugin implements Listener {
    private int limit;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        limit = Math.max(41, getConfig().getInt("max-repair-cost", 32767));
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Anvil cost cap raised to " + limit);
    }

    // Set as soon as the anvil opens, before any result is computed.
    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        if (e.getView() instanceof AnvilView view) view.setMaximumRepairCost(limit);
    }

    // And again on every update, in case another plugin reset it.
    @EventHandler
    public void onPrepare(PrepareAnvilEvent e) {
        e.getView().setMaximumRepairCost(limit);
    }
}
