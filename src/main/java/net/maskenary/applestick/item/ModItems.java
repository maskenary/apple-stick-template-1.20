package net.maskenary.applestick.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.maskenary.applestick.AppleStick;
import net.maskenary.applestick.item.custom.ChargedAppleStickItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item APPLESTICK = Registry.register(Registries.ITEM,
            new Identifier(AppleStick.MOD_ID, "applestick"), new Item(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).build()
            )));
    public static final Item CHARGED_APPLESTICK = Registry.register(Registries.ITEM,
            new Identifier(AppleStick.MOD_ID, "charged_applestick"), new ChargedAppleStickItem(new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(20).saturationModifier(0.3f).build()
            )));

    public static void registerModItems(){
        AppleStick.LOGGER.info("Registering Items for apple-stick");
    }

}