package net.maple.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import java.util.function.Supplier;

public class ModFood {
    public static final FoodProperties CUCUMBER = (
            new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).fast().
            effect(() -> new MobEffectInstance(MobEffects.POISON, 30, 1), 1).build();

}
