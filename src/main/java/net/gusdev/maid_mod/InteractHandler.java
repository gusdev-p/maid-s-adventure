package net.gusdev.maid_mod;

import net.gusdev.maid_mod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "maid_adventure")
public class InteractHandler {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;
        if (event.getItemStack().getItem() instanceof BlockItem) return;

        Block clickedBlock = event.getLevel().getBlockState(event.getPos()).getBlock();

        if (clickedBlock == ModBlocks.MAID_WORKSTATION.get()) {
            event.getEntity().swing(event.getHand(), true);
            event.getEntity().sendSystemMessage(
                    Component.translatable("maid_workstation.error")
            );

        } else if (clickedBlock == ModBlocks.COFFEE_MAKER.get()) {
            event.getEntity().swing(event.getHand(), true);
            event.getEntity().sendSystemMessage(
                    Component.translatable("maid_workstation.error")
            );
        } else return;
        }
}

