package net.gameoverse.dragonrockets.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** A vanilla Firework Rocket used while gliding does nothing; the Dragon's Breath Firework still boosts. */
@Mixin(FireworkRocketItem.class)
public abstract class FireworkRocketItemMixin {
   @Inject(method = "use", at = @At("HEAD"), cancellable = true)
   private void gameoverse_dragon_rockets$noVanillaBoost(Level level, Player player, InteractionHand hand,
                                                          CallbackInfoReturnable<InteractionResult> cir) {
      if (player.isFallFlying() && player.getItemInHand(hand).is(Items.FIREWORK_ROCKET)) {
         if (!level.isClientSide()) {
            player.sendOverlayMessage(Component.translatable("message.gameoverse_dragon_rockets.needs_dragon_breath"));
         }
         cir.setReturnValue(InteractionResult.FAIL);
      }
   }
}
