package ru.alfacarus.jewelryTFC.effects;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import ru.alfacarus.jewelryTFC.Items.jewelrys.Jewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

public class ExperienceEffect extends AbstractEffect{

    public ExperienceEffect(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    @Override
    public boolean isOnTick() {
        return false;
    }

    @Override
    public void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {

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
    public void playerGetExperience(PlayerPickupXpEvent event){
        ItemStack itemStack = checkInventory(event.entityPlayer);
        if(null != itemStack){
            event.orb.xpValue *= getBonusFactor(((Jewelry) itemStack.getItem()).getBonus());
        }
    }

    private double getBonusFactor(int bonus){
        switch (bonus){
            case 0: return 1.5;
            case 1: return 2.0;
            case 2: return 2.5;
            case 3: return 3.0;
            default: return 3.5;
        }
    }

}
