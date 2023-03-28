package net.skyerangerdelta.bungus.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.skyerangerdelta.bungus.BungusMod;

public class BungusItems {
    //Register
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BungusMod.MOD_ID);

    //Items

    //Enqueue Work
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
