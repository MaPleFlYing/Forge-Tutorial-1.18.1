package net.maple.tutorialmod.util;

import net.maple.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> PROBE_ROD_VALUABLES = tag("probe_rod_valuables");

        private static Tags.IOptionalNamedTag<Block> tag(String name){
            return BlockTags.createOptional(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> forgeTag(String name){
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> PINK_INGOT = forgeTag("ingot/pink_ingot");

        private static Tags.IOptionalNamedTag<Item> tag(String name){
            return ItemTags.createOptional(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> forgeTag(String name){
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }

}
