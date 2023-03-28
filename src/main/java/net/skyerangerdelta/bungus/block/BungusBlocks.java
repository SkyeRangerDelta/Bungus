package net.skyerangerdelta.bungus.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skyerangerdelta.bungus.BungusMod;
import net.skyerangerdelta.bungus.item.BungusItems;

import java.util.function.Supplier;

public class BungusBlocks {
    //Register
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BungusMod.MOD_ID);

    //BLOCKS
    public static final RegistryObject<Block> BUNGUS = registerBlock("bungus",
            () -> new FlowerBlock(MobEffects.REGENERATION, 8,
                    BlockBehaviour.Properties.copy(Blocks.BLUE_ORCHID).noOcclusion()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> POTTED_BUNGUS = registerBlockWithoutItem("potted_bungus",
            () -> new FlowerPotBlock(null, BungusBlocks.BUNGUS,
                    BlockBehaviour.Properties.copy(Blocks.BLUE_ORCHID).noOcclusion()));

    //Enqueue Register
    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab) {
        RegistryObject<T> doReturn = BLOCKS.register(name, block);
        registerBlockItem(name, doReturn, CreativeModeTab.TAB_DECORATIONS);
        return doReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return BungusItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
