package ru.alfacarus.jewelryTFC.utils;

import com.bioxx.tfc.Core.Player.FoodStatsTFC;
import com.bioxx.tfc.Core.Player.PlayerInfo;
import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
import com.bioxx.tfc.Core.Player.SkillStats;
import com.bioxx.tfc.Core.TFC_Core;
import net.minecraft.entity.player.EntityPlayer;

public class TFCCoreAdapter {

    public FoodStatsTFC getPlayerFoodStats(EntityPlayer player){
        return TFC_Core.getPlayerFoodStats(player);
    }

    public boolean needFood(EntityPlayer player){
        return TFC_Core.getPlayerFoodStats(player).needFood();
    }

    public boolean needDrink(EntityPlayer player){
        return TFC_Core.getPlayerFoodStats(player).needDrink();
    }

    public int getMaxHeals(EntityPlayer player){
        return FoodStatsTFC.getMaxHealth(player);
    }

    public SkillStats getPlayerSkillStats(EntityPlayer player){
        return TFC_Core.getSkillStats(player);
    }

}
