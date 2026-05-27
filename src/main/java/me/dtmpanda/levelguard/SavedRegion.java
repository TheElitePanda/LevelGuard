package me.dtmpanda.levelguard;

import java.util.List;
import java.util.UUID;

public class SavedRegion {

	public String id;
	public UUID owner;

	public String world;

	public int minY;
	public int maxY;

	public List<RegionPoint> points;
}
