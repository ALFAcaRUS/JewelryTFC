package ru.alfacarus.jewelryTFC.utils;

import net.minecraft.item.ItemStack;

public class Recipe{
    private ItemStack result;
    private Object[] craft;

    public Recipe(ItemStack result, Object[] craft){
        this.result = result;
        this.craft = craft;
    }

    public ItemStack getResult(){
        return this.result;
    }

    public Object[] getCraft(){
        return this.craft;
    }
}
