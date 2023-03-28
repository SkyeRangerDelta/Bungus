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
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skyerangerdelta.bungus.Bungus;
import net.skyerangerdelta.bungus.item.BungusItems;

import java.util.function.Supplier;

public class BungusBlocks {
    //Class Register
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bungus.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> BUNGUS = registerBlock("bungus",
            () -> new FlowerBlock(MobEffects.REGENERATION, 5,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> POTTED_BUNGUS = BLOCKS.register("potted_bungus",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BungusBlocks.BUNGUS,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)));


    //Functions
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> returnedBlock = BLOCKS.register(name, block);
        registerBlockItem(name, returnedBlock, tab);

        return returnedBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return BungusItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
