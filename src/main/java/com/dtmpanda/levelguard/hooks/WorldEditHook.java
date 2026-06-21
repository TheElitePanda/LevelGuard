package com.dtmpanda.levelguard.hooks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class WorldEditHook {

	private final boolean available;
	private final String provider;

	public WorldEditHook() {

		Plugin fawe = Bukkit.getPluginManager().getPlugin("FastAsyncWorldEdit");
		Plugin we = Bukkit.getPluginManager().getPlugin("WorldEdit");

		if (fawe != null && fawe.isEnabled()) {
			available = true;
			provider = "FastAsyncWorldEdit";
		} else if (we != null && we.isEnabled()) {
			available = true;
			provider = "WorldEdit";
		} else {
			available = false;
			provider = "None";
		}
	}

	public boolean isAvailable() {
		return available;
	}

	public String getProvider() {
		return provider;
	}
}
