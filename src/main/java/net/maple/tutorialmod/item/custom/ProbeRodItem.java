package net.maple.tutorialmod.item.custom;

import net.maple.tutorialmod.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ProbeRodItem extends Item {
    public ProbeRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos blockPos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        boolean foundBlock = false;

        if (pContext.getLevel().isClientSide()) {
            for(int i=0; i<=blockPos.getY() + 64; i++){
                Block blockBelow = pContext.getLevel().getBlockState(blockPos.below(i)).getBlock();

                if (isValuaBlock(blockBelow)) {
                    outputValuaCoordinates(blockPos.below(i),player,blockBelow);
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.tutorialmod.probe_rod.no_valuables"),
                        player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player1) -> player1.broadcastBreakEvent(player1.getUsedItemHand()));

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltis.tutorialmod.prrobe_rod.tooltis.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltis.tutorialmod.prrobe_rod.tooltis"));
        }
    }

    private void outputValuaCoordinates(BlockPos blockPos, Player player, Block block){
        player.sendMessage(new TextComponent("Discover " + block.asItem().getRegistryName().toString() +
                "(" + blockPos.getX() + "," + blockPos.getY() + "," + blockPos.getZ() + ")"),player.getUUID());
    }

    private boolean isValuaBlock(Block block){
        return ModTags.Blocks.PROBE_ROD_VALUABLES.contains(block);
    }


}
