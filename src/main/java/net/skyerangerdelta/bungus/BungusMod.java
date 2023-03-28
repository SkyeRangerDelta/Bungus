package net.skyerangerdelta.bungus;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skyerangerdelta.bungus.block.BungusBlocks;
import net.skyerangerdelta.bungus.item.BungusItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BungusMod.MOD_ID)
public class BungusMod {
    public static final String MOD_ID = "bungus";

    private static final Logger LOGGER = LogManager.getLogger();

    public BungusMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BungusBlocks.register(eventBus);
        BungusItems.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BungusBlocks.BUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BungusBlocks.POTTED_BUNGUS.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BungusBlocks.BUNGUS.getId(), BungusBlocks.POTTED_BUNGUS);
        });
    }
}
