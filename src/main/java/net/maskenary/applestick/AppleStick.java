package net.maskenary.applestick;

import net.fabricmc.api.ModInitializer;

import net.maskenary.applestick.item.ModItemGroups;
import net.maskenary.applestick.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppleStick implements ModInitializer {
	public static final String MOD_ID = "apple-stick";
    public static final Logger LOGGER = LoggerFactory.getLogger("apple-stick");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
	}
}