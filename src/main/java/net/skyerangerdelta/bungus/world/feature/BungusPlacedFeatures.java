package net.skyerangerdelta.bungus.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.skyerangerdelta.bungus.Bungus;

import java.util.List;

public class BungusPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Bungus.MOD_ID);

    public static final Holder<PlacedFeature> PLACED_BUNGUS = PlacementUtils.register("placed_bungus", VegetationFeatures.FLOWER_SWAMP, RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
