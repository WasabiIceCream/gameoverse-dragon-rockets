package net.gameoverse.dragonrockets;

import java.util.List;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Fireworks;

/**
 * Elytra boosting needs a Dragon's Breath Firework: vanilla Firework Rockets no longer boost
 * a gliding player (see {@code FireworkRocketItemMixin}), everything else about them is
 * unchanged. The new rocket is a plain {@link FireworkRocketItem}, so it boosts exactly like
 * a vanilla one of the same flight duration.
 */
public final class DragonRockets implements ModInitializer {
   public static final String MOD_ID = "gameoverse_dragon_rockets";
   public static final ResourceKey<Item> DRAGON_BREATH_FIREWORK_KEY =
      ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "dragon_breath_firework"));
   public static final Item DRAGON_BREATH_FIREWORK = Registry.register(BuiltInRegistries.ITEM, DRAGON_BREATH_FIREWORK_KEY,
      new FireworkRocketItem(new Item.Properties().setId(DRAGON_BREATH_FIREWORK_KEY)
         .component(DataComponents.FIREWORKS, new Fireworks(1, List.of()))));

   @Override
   public void onInitialize() {
      CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
         .register(entries -> entries.insertAfter(Items.FIREWORK_ROCKET, DRAGON_BREATH_FIREWORK));
   }
}
