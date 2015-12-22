package ru.alfacarus.jewelryTFC.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

/**
 *
 */
public class JewelryCreativeTab extends CreativeTabs{
    private ItemManager manager;
    private String itemName;

    public JewelryCreativeTab(String lable, ItemManager manager) {
        super(lable);
        this.manager = manager;
    }

    public void setItemName(String name){
        this.itemName = name;
    }

    @Override
    public Item getTabIconItem() {
        return manager.getItemByName(itemName);
    }
}
