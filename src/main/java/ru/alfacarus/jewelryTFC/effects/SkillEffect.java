package ru.alfacarus.jewelryTFC.effects;

import com.bioxx.tfc.Core.Player.SkillStats;
import com.bioxx.tfc.api.Events.PlayerSkillEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import ru.alfacarus.jewelryTFC.Items.jewelrys.Jewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.TFCCoreAdapter;

public class SkillEffect extends AbstractEffect{
    public SkillEffect(ILoadingFactory loadingFactory) {
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

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void playerGetSkill(PlayerSkillEvent.Increase event){
        ItemStack itemStack = checkInventory(event.entity);
        if (null != itemStack) {
            if(1 == itemStack.getItemDamage()) {
                return;
            }

            int skillGain = (int) (event.skillGain * getBonusFactor(((Jewelry) itemStack.getItem()).getBonus()));
            TFCCoreAdapter adapter = runtimeFactory.getTFCCoreAdapter();
            SkillStats skillStats = adapter.getPlayerSkillStats((EntityPlayer) event.entity);
            if(null != skillStats) {
                itemStack.setItemDamage(1);
                skillStats.increaseSkill(event.skillName, skillGain);
                itemStack.setItemDamage(0);
            }
        }
    }

    private double getBonusFactor(int bonus){
        switch (bonus){
            case 0: return 15;
            case 1: return 20;
            case 2: return 25;
            case 3: return 30;
            default: return 35;
        }
    }
}
