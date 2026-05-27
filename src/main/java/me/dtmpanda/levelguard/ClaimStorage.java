package me.dtmpanda.levelguard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ClaimStorage {

	private final LevelGuardPlugin plugin;

	private final Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();

	public ClaimStorage(LevelGuardPlugin plugin) {
		this.plugin = plugin;
	}

	public void saveClaims(List<ProtectedRegion> regions) {

		try {

			File file = new File(
					plugin.getDataFolder(),
					"claims.json"
			);

			JsonArray array = new JsonArray();

			for (ProtectedRegion region : regions) {

				JsonObject object = new JsonObject();

				object.addProperty("id", region.getId());

				object.addProperty(
						"owner",
						region.getOwner().toString()
				);

				object.addProperty(
						"world",
						region.getWorld()
				);

				object.addProperty(
						"minY",
						region.getMinY()
				);

				object.addProperty(
						"maxY",
						region.getMaxY()
				);

				JsonArray pointsArray = new JsonArray();

				for (RegionPoint point : region.getPoints()) {

					JsonObject pointObject = new JsonObject();

					pointObject.addProperty(
							"x",
							point.getX()
					);

					pointObject.addProperty(
							"y",
							point.getY()
					);

					pointObject.addProperty(
							"z",
							point.getZ()
					);

					pointsArray.add(pointObject);
				}

				object.add(
						"points",
						pointsArray
				);

				array.add(object);
			}

			FileWriter writer = new FileWriter(file);

			gson.toJson(array, writer);

			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ProtectedRegion> loadClaims() {

		try {

			File file = new File(plugin.getDataFolder(), "claims.json");

			if (!file.exists()) {
				return new ArrayList<>();
			}

			FileReader reader = new FileReader(file);

			ProtectedRegion[] regions =
					gson.fromJson(reader, ProtectedRegion[].class);

			reader.close();

			if (regions == null) {
				return new ArrayList<>();
			}

			return new ArrayList<>(List.of(regions));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}
}