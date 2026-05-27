package me.dtmpanda.levelguard;

import org.bukkit.Location;
import org.bukkit.World;

public class RegionPoint {

	private final double x;
	private final double y;
	private final double z;

	public RegionPoint(double x, double y, double z) {

		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public Location toLocation(World world) {

		return new Location(
				world,
				x,
				y,
				z
		);
	}

	public static RegionPoint fromLocation(Location location) {

		return new RegionPoint(
				location.getX(),
				location.getY(),
				location.getZ()
		);
	}
}