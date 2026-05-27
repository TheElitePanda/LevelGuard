package me.dtmpanda.levelguard;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProtectedRegion {

	private final String id;
	private final UUID owner;

	private final String world;

	private final int minY;
	private final int maxY;

	private final List<RegionPoint> points;

	public ProtectedRegion(
			String id,
			UUID owner,
			String world,
			int minY,
			int maxY,
			List<RegionPoint> points
	) {

		this.id = id;
		this.owner = owner;

		this.world = world;

		this.minY = minY;
		this.maxY = maxY;

		this.points = points;
	}

	public String getId() {
		return id;
	}

	public UUID getOwner() {
		return owner;
	}

	public String getWorld() {
		return world;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxY() {
		return maxY;
	}

	public List<RegionPoint> getPoints() {
		return points;
	}

	public boolean contains(Location location) {

		List<Location> convertedPoints = new ArrayList<>();

		for (RegionPoint point : points) {

			convertedPoints.add(
					point.toLocation(
							Bukkit.getWorld(world)
					)
			);
		}

		return PolygonChecker.isInside(convertedPoints, location);
	}
}
