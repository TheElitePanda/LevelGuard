package me.dtmpanda.levelguard;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class RegionManager {

	private final List<ProtectedRegion> regions = new ArrayList<>();

	public void registerRegion(ProtectedRegion region) {
		regions.add(region);
	}

	public void unregisterRegion(String id) {
		regions.removeIf(r -> r.getId().equalsIgnoreCase(id));
	}

	public List<ProtectedRegion> getRegions() {
		return regions;
	}

	public ProtectedRegion getRegionAt(Location location) {

		for (ProtectedRegion region : regions) {

			if (!region.getWorld().equals(location.getWorld().getName())) {
				continue;
			}

			if (location.getBlockY() < region.getMinY()
					|| location.getBlockY() > region.getMaxY()) {
				continue;
			}

			if (region.getPoints().size() < 3) {
				continue;
			}

			if (region.contains(location)) {
				return region;
			}
		}

		return null;
	}

}

