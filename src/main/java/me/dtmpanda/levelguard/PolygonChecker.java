package me.dtmpanda.levelguard;

import org.bukkit.Location;

import java.util.List;

public class PolygonChecker {

	public static boolean isInside(List<Location> points, Location location) {

		double x = location.getX();
		double z = location.getZ();

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
