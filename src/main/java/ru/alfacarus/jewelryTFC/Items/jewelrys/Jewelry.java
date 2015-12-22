package ru.alfacarus.jewelryTFC.Items.jewelrys;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import ru.alfacarus.jewelryTFC.Items.BaseItem;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

import java.util.List;


public class Jewelry extends BaseItem implements IBauble{
    private AbstractEffect effect;
    private int bonus;

    public Jewelry(ILoadingFactory loadingFactory, AbstractEffect effect, String name) {
        super(loadingFactory);
        this.effect = effect;
        this.setUnlocalizedName(name);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player){
        if(itemStack.stackTagCompound == null){
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public AbstractEffect getEffect(){
        return this.effect;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    public int getBonus(){
        return bonus;
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return null;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        if (null != getEffect() && getEffect().isOnTick()){
            getEffect().onTick(itemStack, entityLivingBase);
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        effect.onEquipped(itemStack, entityLivingBase);
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        effect.onUnequipped(itemStack, entityLivingBase);
    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int targetSide, float targetX, float targetY, float targetZ){
        if(null == getEffect()){
            return false;
        }
        return getEffect().onItemUse(stack, player, world, x, y, z, targetSide, targetX, targetY, targetZ);
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag) {
        if(null != effect){
            arraylist.add(effect.getName());
        }
        super.addInformation(is, player, arraylist, flag);
    }

    @Override
    public boolean canStack() {
        return false;
    }
}
