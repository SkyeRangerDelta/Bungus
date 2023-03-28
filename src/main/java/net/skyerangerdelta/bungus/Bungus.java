package net.skyerangerdelta.bungus;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skyerangerdelta.bungus.block.BungusBlocks;
import net.skyerangerdelta.bungus.item.BungusItems;
import net.skyerangerdelta.bungus.world.feature.BungusConfFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Bungus.MOD_ID)
public class Bungus
{
    public static final String MOD_ID = "bungus";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Bungus() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BungusItems.register(modEventBus);
        BungusBlocks.register(modEventBus);
        BungusConfFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BungusBlocks.BUNGUS.getId(), BungusBlocks.POTTED_BUNGUS);
        });

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
