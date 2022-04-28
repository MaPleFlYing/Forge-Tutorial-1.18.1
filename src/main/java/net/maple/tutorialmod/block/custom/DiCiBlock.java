package net.maple.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DiCiBlock extends Block {
    public DiCiBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pLevel.isClientSide()){
            if(pEntity instanceof LivingEntity){
                DamageSource D = new DamageSource("被地刺扎死了!");
                LivingEntity livingEntity = (LivingEntity) pEntity;
                livingEntity.setRemainingFireTicks(40);
                livingEntity.setSecondsOnFire(60);
                livingEntity.hurt(DamageSource.IN_FIRE,5.5F);


            }
        }
    }
}
