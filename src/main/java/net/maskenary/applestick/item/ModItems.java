package net.maskenary.applestick.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.maskenary.applestick.AppleStick;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item APPLESTICK = Registry.register(Registries.ITEM,
            new Identifier(AppleStick.MOD_ID, "applestick"), new Item(new FabricItemSettings()));

    public static void registerModItems(){
        AppleStick.LOGGER.info("Registering Items for apple-stick");
        //add entries in ModItemGroups too
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(APPLESTICK);
        });
    }

}