package net.gusdev.maid_mod.item;

import net.gusdev.maid_mod.MaidMod;
import net.gusdev.maid_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MaidMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAID_TAB = CREATIVE_MODE_TAB.register("maid_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COFFEE.get()))
                    .title(Component.translatable("creativemod.maid_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COFFEE.get());
                        output.accept(ModItems.COFFEE_WITH_BLESS.get());
                        output.accept(ModBlocks.MAID_WORKSTATION.get());
                        output.accept(ModBlocks.COFFEE_MAKER.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
