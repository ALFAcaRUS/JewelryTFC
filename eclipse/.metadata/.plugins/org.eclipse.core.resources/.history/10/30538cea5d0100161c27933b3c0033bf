package ru.alfacarus.jewelryTFC.effects;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.TFCCoreAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class RemovePotionEffect extends AbstractEffect {

    public RemovePotionEffect(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    @Override
    public boolean isOnTick() {
        return true;
    }

    @Override
    public void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        TFCCoreAdapter adapter = runtimeFactory.getTFCCoreAdapter();
        EntityPlayer player = (EntityPlayer) entityLivingBase;

        float maxWater = adapter.getPlayerFoodStats(player).getMaxWater(player);
        float waterLevel = adapter.getPlayerFoodStats(player).waterLevel;

        boolean needWater = waterLevel / maxWater <= 0.25;

        float maxStomach = adapter.getPlayerFoodStats(player).getMaxStomach(player);
        float stomachLevel = adapter.getPlayerFoodStats(player).stomachLevel;

        boolean needFood = stomachLevel / maxStomach <= 0.25;

        if(needWater || needFood) return;

        Collection<PotionEffect> effects = new ArrayList<>();
        effects.addAll(entityLivingBase.getActivePotionEffects());
        for(PotionEffect effect: effects){
            entityLivingBase.removePotionEffect(effect.getPotionID());
            entityLivingBase.removePotionEffectClient(effect.getPotionID());
        }

    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int targetSide, float targetX, float targetY, float targetZ) {
        return false;
    }

    @Override
    public EventBus getEventBus() {
        return null;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }
}
