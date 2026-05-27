package me.dtmpanda.levelguard;

public class LevelGuardAPI {

	public static RegionManager getRegionManager() {

		return LevelGuardPlugin
				.getInstance()
				.getRegionManager();
	}
}