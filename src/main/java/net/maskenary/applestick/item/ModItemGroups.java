package net.maskenary.applestick.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.maskenary.applestick.AppleStick;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    private static final ItemGroup APPLESTICK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.APPLESTICK))
            .displayName(Text.translatable("itemgroup.applestick"))
            .entries((context, entries) -> {
                entries.add(ModItems.APPLESTICK);
                entries.add(ModItems.CHARGED_APPLESTICK);
            })
            .build();

    public static void registerModItemGroups(){
        AppleStick.LOGGER.info("Registering Item Groups for apple-stick");
        Registry.register(Registries.ITEM_GROUP, new Identifier(AppleStick.MOD_ID, "applestick"), APPLESTICK_GROUP);
    }
}
