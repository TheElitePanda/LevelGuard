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

			if (isInsidePolygon(location, region)) {
				return region;
			}
		}

		return null;
	}

	private boolean isInsidePolygon(Location location, ProtectedRegion region) {

		double x = location.getX();
		double z = location.getZ();

		List<Location> points = new ArrayList<>();

		for (RegionPoint point : region.getPoints()) {
			points.add(
					point.toLocation(
							Bukkit.getWorld(region.getWorld())
					)
			);
		}

		boolean inside = false;

		for (int i = 0, j = points.size() - 1; i < points.size(); j = i++) {

			double xi = points.get(i).getX();
			double zi = points.get(i).getZ();

			double xj = points.get(j).getX();
			double zj = points.get(j).getZ();

			boolean intersect =
					((zi > z) != (zj > z))
							&& (x < (xj - xi) * (z - zi) / (zj - zi) + xi);

			if (intersect) {
				inside = !inside;
			}
		}

		return inside;
	}
}

