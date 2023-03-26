package net.skyerangerdelta.bungus.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MushroomBlock;
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
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bungus.MOD_ID);

    public static final RegistryObject<Block> BUNGUS_BLOCK = registerBlock("bungus_block",
            () -> new MushroomBlock(BlockBehaviour.Properties.of(Material.PLANT), () -> ));

    private static <T extends MushroomBlock>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
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
