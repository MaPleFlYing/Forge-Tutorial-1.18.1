package net.maple.tutorialmod.item;

import net.maple.tutorialmod.TutorialMod;
import net.maple.tutorialmod.item.custom.FengWoMei;
import net.maple.tutorialmod.item.custom.ProbeRodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> PINK_INGOT = ITEMS.register("pink_ingot",
            () -> new Item(new Item.Properties().tab(ModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> PINK_PICK = ITEMS.register("pink_pick",
            () -> new Item(new Item.Properties().tab(ModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> PINK_AXE = ITEMS.register("pink_axe",
            () -> new Item(new Item.Properties().tab(ModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> RAW_PINK = ITEMS.register("raw_pink",
            () -> new Item(new Item.Properties().tab(ModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> PROBE_ROD = ITEMS.register("probe_rod",
            () -> new ProbeRodItem(new Item.Properties().tab(ModTab.TUTORIAL_TAB).durability(16)));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().tab(ModTab.TUTORIAL_TAB).food(ModFood.CUCUMBER)));

    public static final RegistryObject<Item> FENGWO = ITEMS.register("fengwo",
            () -> new FengWoMei(new Item.Properties().tab(ModTab.TUTORIAL_TAB).food(ModFood.CUCUMBER)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
