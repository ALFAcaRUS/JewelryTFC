package ru.alfacarus.jewelryTFC.effects;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.alfacarus.jewelryTFC.Items.jewelrys.Jewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.TFCCoreAdapter;

public class HealingEffect extends AbstractEffect{
    private static final String POINTS_TAG_NAME = "healing_points";
    private static final double MAX_HEALING_POINTS = 1000;

    public HealingEffect(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    @Override
    public boolean isOnTick() {
        return true;
    }

    @Override
    public void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();

        if(!itemStack.hasTagCompound()){
            tagCompound = new NBTTagCompound();
            itemStack.setTagCompound(tagCompound);
        }

        if(!tagCompound.hasKey(POINTS_TAG_NAME)){
            tagCompound.setDouble(POINTS_TAG_NAME, MAX_HEALING_POINTS);
        }

        double healingPoints = tagCompound.getDouble(POINTS_TAG_NAME);
        if(MAX_HEALING_POINTS <= healingPoints){
            double maxHeals = entityLivingBase.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
            double currentLife = entityLivingBase.getHealth();
            if (currentLife < maxHeals) {
                entityLivingBase.addPotionEffect(new PotionEffect(Potion.regeneration.id, 500, 0, false));
                tagCompound.setDouble(POINTS_TAG_NAME, 0);
            }
        } else {
            int bonus = ((Jewelry) itemStack.getItem()).getBonus();
            double newHealingPoints = healingPoints + getHealingReloadSpeed(bonus);
            tagCompound.setDouble(POINTS_TAG_NAME, newHealingPoints > MAX_HEALING_POINTS ? MAX_HEALING_POINTS: newHealingPoints);
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

    private double getHealingReloadSpeed(int bonus){
        switch(bonus){
            case 0: return 0.1;
            case 1: return 0.5;
            case 2: return 0.1;
            case 3: return 0.15;
            default: return 0.2;
        }
    }
}
