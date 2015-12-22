package ru.alfacarus.jewelryTFC.effects;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import ru.alfacarus.jewelryTFC.Items.jewelrys.Jewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

public class MobProtectionEffect extends AbstractEffect {
    private static final String NTB_TAG_NAME = "protection_points";
    private static final int ONE_DAMAGE_POINTS = 1000;

    public MobProtectionEffect(ILoadingFactory loadingFactory){
        super(loadingFactory);
    }

    @Override
    public boolean isOnTick() {
        return true;
    }

    @Override
    public void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        Jewelry item = (Jewelry) itemStack.getItem();
        int bonus = item.getBonus();

        if(null == tagCompound){
            tagCompound = new NBTTagCompound();
            itemStack.setTagCompound(tagCompound);
        }

        if(!tagCompound.hasKey(NTB_TAG_NAME)){
            tagCompound.setInteger(NTB_TAG_NAME, getMaxPoints(bonus));
        }

        int protPoints = tagCompound.getInteger(NTB_TAG_NAME);
        int maxPoints = getMaxPoints(bonus);
        if(!(protPoints >= maxPoints)){
            protPoints = protPoints + getReloadingSpeed(bonus);
            protPoints = protPoints > maxPoints ? maxPoints : protPoints;
            runtimeFactory.getLogger().additionalLog("Protection points: ", protPoints);
            tagCompound.setInteger(NTB_TAG_NAME, protPoints);
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int targetSide, float targetX, float targetY, float targetZ) {
        return false;
    }

    @Override
    public EventBus getEventBus() {
        return MinecraftForge.EVENT_BUS;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @SubscribeEvent
    public void livingHurt(LivingHurtEvent event){
        if(event.isCancelable()){
            ItemStack eventIS = checkInventory(event.entityLiving);
            if(null != eventIS) {
                NBTTagCompound tagCompound = eventIS.getTagCompound();
                if (null != tagCompound && tagCompound.hasKey(NTB_TAG_NAME)){
                    int protPoint = tagCompound.getInteger(NTB_TAG_NAME);
                    if(ONE_DAMAGE_POINTS <= protPoint){
                        event.setCanceled(true);
                        tagCompound.setInteger(NTB_TAG_NAME, protPoint - ONE_DAMAGE_POINTS);
                        runtimeFactory.getLogger().additionalLog("Block damage: ", protPoint - ONE_DAMAGE_POINTS);
                    }
                }
            }
        }
    }

    private int getReloadingSpeed(int bonus){
        switch (bonus){
            case 0: return 1;
            case 1: return 2;
            case 2: return 5;
            default: return 7;
        }
    }

    private int getMaxPoints(int bonus){
        switch (bonus){
            case 0: return 1000;
            case 1: return 2000;
            case 2: return 3000;
            default: return 4000;
        }
    }
}
