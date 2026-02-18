package net.gusdev.maid_mod.villager;

import com.google.common.collect.ImmutableSet;
import net.gusdev.maid_mod.MaidMod;
import net.gusdev.maid_mod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPE =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MaidMod.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MaidMod.MOD_ID);

    public static final RegistryObject<PoiType> MAID_POI = POI_TYPE.register("maid_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.MAID_WORKSTATION.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> MAID_PROFESSION =
            VILLAGER_PROFESSION.register("maidprofession",
                    () -> new VillagerProfession("maidprofession", holder -> holder.get() == MAID_POI.get(), holder -> holder.get() == MAID_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static void register(IEventBus eventbus) {
        POI_TYPE.register(eventbus);
        VILLAGER_PROFESSION.register(eventbus);
    }
}
