package ru.alfacarus.jewelryTFC.utils;

import baubles.api.BaublesApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

public class BaubleAdapter {
    public IInventory getBaublesInventory(EntityPlayer player){
        return BaublesApi.getBaubles(player);
    }
}
