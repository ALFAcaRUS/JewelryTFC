package ru.alfacarus.jewelryTFC.strategies;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.Items.ComponentType;
import ru.alfacarus.jewelryTFC.Items.JewelryComponentItem;
import ru.alfacarus.jewelryTFC.Items.jewelrys.RingJewelry;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

import java.util.List;

public class RingsStrategy extends TreeGemComponentStrategy{


    public RingsStrategy(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    @Override
    protected void addRecipe(ItemManager manager, Item newItem, Item baseItem, Item gem, int damage) {
        ItemStack gemsStack = new ItemStack(gem);
        gemsStack.setItemDamage(damage);
        manager.addRecipe(new ItemStack(newItem), new Object[]{"   ", "gcg", "   ", 'g', gemsStack, 'c', new ItemStack(baseItem)});
    }

    @Override
    protected void addItems(JewelryComponentItem item, ItemManager manager, List<Item> itemList) {
        if(item.getType() != ComponentType.ONE_GEM_RING) return;

        for (Item gem: bonusMap.keySet()){
            String name = (item.getUnlocalizedName() + "_"
                    + gem.getUnlocalizedName()).replaceAll("item.", "").toLowerCase();
            RingJewelry newItem = new RingJewelry(loadingFactory, item.getEffect(), name);

            if(item.getEffect() == bonusMap.get(gem)){
                newItem.setBonus(item.getBonus() + 1);
            }

            itemList.add(newItem);

            addRecipe(manager, newItem, item, gem, 1);
            addRecipe(manager, newItem, item, gem, 2);
        }
    }
}
