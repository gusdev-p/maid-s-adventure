package net.gusdev.maid_mod.item;

import net.gusdev.maid_mod.MaidMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MaidMod.MOD_ID);

    public static final RegistryObject<Item> COFFEE = ITEMS.register("coffee",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
                    .build()
            )));

    public static final RegistryObject<Item> COFFEE_WITH_BLESS = ITEMS.register("coffee_with_blessing",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1), 1.0f)
                    .build()
            )));

    public static final RegistryObject<Item> SPOON = ITEMS.register("spoon_item",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
