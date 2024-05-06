package net.maskenary.applestick.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;


public class ChargedAppleStickItem extends Item {
    public ChargedAppleStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 400, 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 400));
            user.sendMessage(Text.literal("You feel invigorated as a surge of energy courses through your veins!"));
        }
        return stack;
    }
}
