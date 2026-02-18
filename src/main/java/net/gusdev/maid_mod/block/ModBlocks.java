package net.gusdev.maid_mod.block;

import net.gusdev.maid_mod.MaidMod;
import net.gusdev.maid_mod.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MaidMod.MOD_ID);

    public static final RegistryObject<Block> MAID_WORKSTATION = registerBlock("maid_workstation",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.IRON_BLOCK)
                    .noOcclusion()
                    .lightLevel(state -> 3)
            ));

    public static final RegistryObject<Block> COFFEE_MAKER = registerBlock("coffee_maker",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.IRON_BLOCK)
                    .noOcclusion()
                    .lightLevel(state -> 3)
            ));

    public static final RegistryObject<Block> TABLE = registerBlock("table",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.QUARTZ_BLOCK)
                    .noOcclusion()
            ));

    public static final RegistryObject<Block> POT_WITHOUT_SUGAR = registerBlock("pot_without_sugar",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.QUARTZ_BLOCK)
                    .noOcclusion()
                    .instabreak()
            ));

    public static final RegistryObject<Block> POT_WITH_SUGAR = registerBlock("pot_with_sugar",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.QUARTZ_BLOCK)
                    .noOcclusion()
                    .instabreak()
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
