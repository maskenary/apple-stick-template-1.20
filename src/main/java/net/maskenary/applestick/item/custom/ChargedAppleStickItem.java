package net.maskenary.applestick.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;


public class ChargedAppleStickItem extends Item {
    public int lifeforce;
    public ChargedAppleStickItem(Settings settings) {
        super(settings);
        lifeforce = 0;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*(lifeforce/5)+1, lifeforce/25));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20*(lifeforce/5)+1, lifeforce/25));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20*(lifeforce/5)+1));
            user.sendMessage(Text.literal("You feel invigorated as a surge of energy courses through your veins!"));
        }
        return super.finishUsing(stack, world, user);
    }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        lifeforce++;
        return super.postHit(stack, target, attacker);
    }
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient){
            ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 2));
        }
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.of("Hitting living beings gathers Life Force into this item to increase its buff"));
        tooltip.add(Text.of("§e§l Current Life Force Gathered: " + lifeforce + "§e§l"));
    }
}
