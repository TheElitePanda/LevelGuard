package me.dtmpanda.levelguard;

import me.dtmpanda.levelguard.ProtectedRegion;
import me.dtmpanda.levelguard.RegionManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockProtectionListener implements Listener {

	private final RegionManager regionManager;

	public BlockProtectionListener(RegionManager regionManager) {
		this.regionManager = regionManager;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {

		Player player = event.getPlayer();

		ProtectedRegion region =
				regionManager.getRegionAt(event.getBlock().getLocation());

		if (region == null) {
			return;
		}

		// Admin bypass
		if (player.hasPermission("levelguard.bypass")) {
			return;
		}

		// Region owner bypass
		if (region.getOwner().equals(player.getUniqueId())) {
			return;
		}

		event.setCancelled(true);

		player.sendMessage(
				ChatColor.RED + "You cannot break blocks here."
		);
	}
}
