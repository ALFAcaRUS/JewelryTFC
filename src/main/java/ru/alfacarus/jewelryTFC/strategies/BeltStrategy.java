package ru.alfacarus.jewelryTFC.strategies;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.Items.ComponentType;
import ru.alfacarus.jewelryTFC.Items.JewelryComponentItem;
import ru.alfacarus.jewelryTFC.Items.jewelrys.BeltJewelry;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

import java.util.HashMap;
import java.util.LinkedList;

public class BeltStrategy extends AbstractStrategy{

    public BeltStrategy(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    @Override
    public void createItems(ItemManager manager) {
        HashMap<AbstractEffect, Item> bonusMap = getBonusMap();
        LinkedList<JewelryComponentItem> belts = new LinkedList();
        LinkedList<JewelryComponentItem> clasps = new LinkedList();

        for (Item item: manager.getItems()){
            if(item instanceof JewelryComponentItem){
                if(((JewelryComponentItem) item).getType() == ComponentType.BELT){
                    belts.add((JewelryComponentItem) item);
                }
                if(((JewelryComponentItem) item).getType() == ComponentType.THREE_GEM_CLASP){
                    clasps.add((JewelryComponentItem) item);
                }
            }
        }

        for(JewelryComponentItem belt: belts){
            for(JewelryComponentItem clasp: clasps){
                String name = (clasp.getUnlocalizedName() + "_"
                    + belt.getUnlocalizedName()).replaceAll("item.", "").toLowerCase();
                BeltJewelry newItem = new BeltJewelry(loadingFactory, clasp.getEffect(), name);
                newItem.setBonus(clasp.getBonus());

                if(bonusMap.get(newItem.getEffect()) == belt.getMaterial()){
                    newItem.setBonus(newItem.getBonus() + 1);
                }

                manager.addItem(newItem);
                manager.addShapedRecipe(new ItemStack(newItem), new Object[]{belt, clasp});
            }
        }
    }

    protected HashMap<AbstractEffect, Item> getBonusMap(){
        HashMap<AbstractEffect, Item> map = new HashMap();
        return map;
    }

    @Override
    public void registerAnvilRecipes(ItemManager manager) {

    }
}
