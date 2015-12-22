package ru.alfacarus.jewelryTFC.effects;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.alfacarus.jewelryTFC.Items.jewelrys.Jewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.IRuntimeFactory;

/**
 *
 */
public abstract class AbstractEffect {
    protected IRuntimeFactory runtimeFactory;
    private String name;

    public AbstractEffect(ILoadingFactory loadingFactory){
        this.runtimeFactory = loadingFactory.getRuntimeFactory();
    }

    public AbstractEffect(ILoadingFactory loadingFactory, String name){
        this.runtimeFactory = loadingFactory.getRuntimeFactory();
        this.name = name;
    }

    public abstract boolean isOnTick();
    public abstract void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase);
    public abstract boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int targetSide, float targetX, float targetY, float targetZ);
    public abstract EventBus getEventBus();
    public abstract void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase);
    public abstract void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase);

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ItemStack checkInventory(Entity entity){
        if(entity instanceof EntityPlayer) {
            IInventory inventory = runtimeFactory.getBaubleAdapter().getBaublesInventory((EntityPlayer) entity);
            for (int i = 0; i < inventory.getSizeInventory(); ++i) {
                ItemStack jewelryItemStack = inventory.getStackInSlot(i);
                if (null != jewelryItemStack) {
                    Item item = jewelryItemStack.getItem();
                    if (item instanceof Jewelry && ((Jewelry) item).getEffect() == this) {
                        return jewelryItemStack;
                    }
                }
            }
        }
        return null;
    }
}
