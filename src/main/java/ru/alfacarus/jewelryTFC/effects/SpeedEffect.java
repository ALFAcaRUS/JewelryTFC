package ru.alfacarus.jewelryTFC.effects;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import ru.alfacarus.jewelryTFC.Items.jewelrys.Jewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.TFCCoreAdapter;

public class SpeedEffect extends AbstractEffect{
    private static final String NBT_TAG_NAME = "isEffectWork";

    public SpeedEffect(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    @Override
    public boolean isOnTick() {
        return true;
    }

    @Override
    public void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        EntityPlayer player = (EntityPlayer) entityLivingBase;
        TFCCoreAdapter adapter = runtimeFactory.getTFCCoreAdapter();

        float maxWater = adapter.getPlayerFoodStats(player).getMaxWater(player);
        float waterLevel = adapter.getPlayerFoodStats(player).waterLevel;

        boolean needWater = waterLevel / maxWater <= 0.5;


        if(checkHaveStack(itemStack, player) || needWater) {
            switchSpeed(itemStack, player, false, 2);
            return;
        }

        switchSpeed(itemStack, player, true);
    }

    private void switchSpeed(ItemStack itemStack, EntityPlayer player, boolean addSpeed, int addFactor){

        NBTTagCompound tagCompound = itemStack.getTagCompound();

        if(null == tagCompound) {
            tagCompound = new NBTTagCompound();
            itemStack.setTagCompound(tagCompound);
        }

        if(!tagCompound.hasKey(NBT_TAG_NAME)) tagCompound.setBoolean(NBT_TAG_NAME, addSpeed);

        if(addSpeed != tagCompound.getBoolean(NBT_TAG_NAME)) {
            setNewSpeed(itemStack, player, addSpeed, addFactor);
            tagCompound.setBoolean(NBT_TAG_NAME, addSpeed);
        }
    }

    private void switchSpeed(ItemStack itemStack, EntityPlayer player, boolean addSpeed){
        switchSpeed(itemStack, player, addSpeed, 1);
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
        if(!(itemStack.getItem() instanceof Jewelry)
                || checkHaveStack(itemStack, (EntityPlayer) entityLivingBase)) return;
        switchSpeed(itemStack, (EntityPlayer) entityLivingBase, true);
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if(!(itemStack.getItem() instanceof Jewelry)
                || checkHaveStack(itemStack, (EntityPlayer) entityLivingBase)) return;
        switchSpeed(itemStack, (EntityPlayer) entityLivingBase, false);
    }

    private void setNewSpeed(ItemStack itemStack, EntityLivingBase entityLivingBase, boolean addSpeed, int addFactor){
        float speed = ((EntityPlayer)entityLivingBase).capabilities.getWalkSpeed();
        float bonus = getSpeedBonus(((Jewelry)itemStack.getItem()).getBonus());
        float newSpeed = speed + addFactor * (addSpeed ? bonus : -bonus);
        ((EntityPlayer)entityLivingBase).capabilities.setPlayerWalkSpeed(newSpeed);
    }

    private boolean checkHaveStack(ItemStack itemStack, EntityPlayer player){
        IInventory inventory = runtimeFactory.getBaubleAdapter().getBaublesInventory(player);
        for(int i = 0; i < inventory.getSizeInventory(); i++){
            ItemStack stackInSlot = inventory.getStackInSlot(i);

            if(null == stackInSlot) continue;

            if(stackInSlot != itemStack && ((Jewelry)stackInSlot.getItem()).getEffect() == this){
                return true;
            }
            if(stackInSlot == itemStack) return false;
        }
        return false;
    }

    private float getSpeedBonus(int bonus){
        switch (bonus){
            case 0: return 0.05f;
            case 1: return 0.07f;
            case 2: return 0.1f;
            case 3: return 0.13f;
            default: return 0.15f;
        }
    }
}
