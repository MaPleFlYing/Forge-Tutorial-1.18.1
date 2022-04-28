package net.maple.tutorialmod.block;

import net.maple.tutorialmod.TutorialMod;
import net.maple.tutorialmod.block.custom.DiCiBlock;
import net.maple.tutorialmod.block.custom.SpeedBlock;
import net.maple.tutorialmod.item.ModItems;
import net.maple.tutorialmod.item.ModTab;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    //粉方块
    public static final RegistryObject<Block> PINK_BLOCK = registerBlock("pink_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //粉矿
    public static final RegistryObject<Block> PINK_ORE = registerBlock("pink_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //速度方块
    public static final RegistryObject<Block> SPEED_BLOCK = registerBlock("speed_block",
            () -> new SpeedBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB, "tooltis.tutorialmod.speed_block.tis");
    //地刺
    public static final RegistryObject<Block> DICI = registerBlock("dici",
            () -> new DiCiBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //透明方块
    public static final RegistryObject<Block> TOUMING = registerBlock("touming",
            () -> new DiCiBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //粉楼梯
    public static final RegistryObject<Block> PINK_STAIRS = registerBlock("pink_stairs",
            () -> new StairBlock(() -> ModBlocks.PINK_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //粉活板门
    public static final RegistryObject<Block> PINK_SLAB = registerBlock("pink_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                            .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //粉栅栏
    public static final RegistryObject<Block> PINK_FENCE = registerBlock("pink_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //粉栅栏门
    public static final RegistryObject<Block> PINK_FENCE_GATE = registerBlock("pink_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);
    //粉墙
    public static final RegistryObject<Block> PINK_WALL = registerBlock("pink_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3F).requiresCorrectToolForDrops()), ModTab.TUTORIAL_TAB);



    /** 注册方块(有物品提示) */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab,
                                                                     String tis){
        RegistryObject<T> toReturn = BLOCK.register(name, block);
        registerBlockItem(name, toReturn, tab, tis);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tis){
        return ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties().tab(tab)){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                        pTooltip.add(new TranslatableComponent(tis));
                    }
                });
    }

    /** 注册方块(没有物品提示) */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCK.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCK.register(eventBus);
    }
}
