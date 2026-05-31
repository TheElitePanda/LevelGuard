package me.dtmpanda.levelguard;

import org.bukkit.plugin.java.JavaPlugin;

public final class LevelGuardPlugin extends JavaPlugin {

	private static LevelGuardPlugin instance;

	private RegionManager regionManager;
	private ClaimStorage claimStorage;

	@Override
	public void onEnable() {

		instance = this;

		if (!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}

		this.regionManager = new RegionManager();

		this.claimStorage = new ClaimStorage(this);

		regionManager.getRegions().addAll(
				claimStorage.loadClaims()
		);

		getServer().getPluginManager().registerEvents(
				new BlockProtectionListener(regionManager),
				this
		);

		getLogger().info("Successfully hooked into LevelCore.");

		getLogger().info(
				"Loaded "
						+ regionManager.getRegions().size()
						+ " protected regions."
		);

		getLogger().info("LevelGuard enabled.");
	}

	@Override
	public void onDisable() {

		claimStorage.saveClaims(
				regionManager.getRegions()
		);

		getLogger().info("Saved " + regionManager.getRegions().size() + " protected regions.");

		getLogger().info("LevelGuard disabled.");
	}

	public static LevelGuardPlugin getInstance() {
		return instance;
	}

	public RegionManager getRegionManager() {
		return regionManager;
	}

	public void saveClaims() {

		getLogger().info("Saving " + regionManager.getRegions().size() + " regions.");

		claimStorage.saveClaims(
				regionManager.getRegions()
		);
	}
}
