package ru.alfacarus.jewelryTFC.effects;

import com.bioxx.tfc.Core.Player.FoodStatsTFC;
import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import ru.alfacarus.jewelryTFC.Items.jewelrys.Jewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.TFCCoreAdapter;

/**
 * Created by alfac_000 on 18.04.2016.
 */
public class WaterEffect extends AbstractEffect{
    private static String NBT_TAG_NAME = "water_count";
    private static int ACTIVATION_POINTS = 1000;

    public WaterEffect(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    public WaterEffect(ILoadingFactory loadingFactory, String name) {
        super(loadingFactory, name);
    }

    @Override
    public boolean isOnTick() {
        return true;
    }

    @Override
    public void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        Jewelry item = (Jewelry) itemStack.getItem();

        if (null == tagCompound){
            tagCompound = new NBTTagCompound();
            itemStack.setTagCompound(tagCompound);
        }

        if (!tagCompound.hasKey(NBT_TAG_NAME)){
            tagCompound.setDouble(NBT_TAG_NAME, ACTIVATION_POINTS);
            return;
        }

        double waterCount =  tagCompound.getDouble(NBT_TAG_NAME);
        EntityPlayer player = (EntityPlayer) entityLivingBase;

        if(ACTIVATION_POINTS != waterCount){
            double newWaterCount = waterCount + getReloadSpeed(item.getBonus()) >= ACTIVATION_POINTS ? ACTIVATION_POINTS : waterCount + getReloadSpeed(item.getBonus());
            tagCompound.setDouble(NBT_TAG_NAME, newWaterCount);
        }
        else {
            ItemStack actionStack = checkInventory(player);
            if (null != actionStack && itemStack == actionStack) {
                TFCCoreAdapter adapter = runtimeFactory.getTFCCoreAdapter();
                FoodStatsTFC foodStats = adapter.getPlayerFoodStats(player);
                if (foodStats.getMaxWater(player) >= foodStats.waterLevel + getBonusEffect(item.getBonus())) {
                    foodStats.restoreWater(player, (int) getBonusEffect(item.getBonus()));
                    tagCompound.setDouble(NBT_TAG_NAME, 1);
                }
            }
        }
        itemStack.setItemDamage((int)(itemStack.getMaxDamage() - tagCompound.getDouble(NBT_TAG_NAME)));
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

    private double getReloadSpeed(int bonus){
        switch (bonus){
            case 0: return 1;
            case 1: return 2;
            case 2: return 5;
            default: return 7;
        }
    }

    private double getBonusEffect(int bonus){
        switch (bonus){
            case 0: return 100;
            case 1: return 150;
            case 2: return 200;
            case 3: return 250;
            default: return 300;
        }
    }
}
