package net.skyerangerdelta.bungus.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skyerangerdelta.bungus.Bungus;

public class BungusItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bungus.MOD_ID);

    public static final RegistryObject<Item> BUNGUS = ITEMS.register("bungus",
            () -> new Item(new Item.Properties()
                    .tab(CreativeModeTab.TAB_DECORATIONS)
                    .stacksTo(16)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
